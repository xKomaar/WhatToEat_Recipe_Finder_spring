package pl.whattoeat.whattoeat_spring.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.whattoeat.whattoeat_spring.model.Recipe;
import pl.whattoeat.whattoeat_spring.service.IngredientInputService;
import pl.whattoeat.whattoeat_spring.service.RecipesService;

import java.util.ArrayList;

@Controller
@RequestMapping("/recipes")
@AllArgsConstructor
public class RecipesController {

    private final RecipesService recipesService;

    private final IngredientInputService ingredientInputService;

    @GetMapping("")
    public String getRecipes(Model model) {
        ArrayList<String> ingredientList = ingredientInputService.getIngredients();
        if(ingredientList == null || ingredientList.isEmpty()) {
            return "redirect:/ingredients_input";
        }
        ArrayList<Recipe> recipeList = recipesService.getMatchingRecipes(ingredientList);
        model.addAttribute("recipeList", recipeList);
        return "recipes";
    }
}
