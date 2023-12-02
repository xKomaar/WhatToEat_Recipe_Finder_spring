package pl.whattoeat.whattoeat_spring.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.whattoeat.whattoeat_spring.model.Recipe;
import pl.whattoeat.whattoeat_spring.model.Selectors;
import pl.whattoeat.whattoeat_spring.service.IngredientInputService;
import pl.whattoeat.whattoeat_spring.service.RecipesService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/recipes")
@AllArgsConstructor
public class RecipesController {

    private final IngredientInputService ingredientInputService;

    private final RecipesService recipesService;

    @GetMapping("")
    public String getRecipes(Model model) {
        ArrayList<String> ingredientList = ingredientInputService.getIngredients();
        if(checkIfListEmpty(ingredientList)) {
            return "redirect:/ingredients_input";
        }
        ArrayList<Recipe> recipeList = recipesService.getMatchingRecipes(ingredientList);
        if(checkIfListEmpty(recipeList)) {
            return "redirect:/ingredients_input";
        }
        model.addAttribute("recipeList", recipeList);
        recipesService.resetIngredientsAvailability(recipeList);
        return "recipes";
    }

    @GetMapping("/recipeView")
    public String viewRecipe(Model model, @RequestParam("title") String recipeTitle) {
        ArrayList<String> ingredientList = ingredientInputService.getIngredients();
        if(checkIfListEmpty(ingredientList)) {
            return "redirect:/ingredients_input";
        }
        ArrayList<Recipe> recipeList = recipesService.getMatchingRecipes(ingredientList);
        if(checkIfListEmpty(recipeList)) {
            return "redirect:/ingredients_input";
        }
        model.addAttribute("recipeList", recipeList);
        Recipe recipe = recipesService.findRecipeByTitle(recipeTitle);
        model.addAttribute("recipe", recipe);
        recipesService.resetIngredientsAvailability(recipeList);
        return "recipeView";
    }

    private boolean checkIfListEmpty(ArrayList list) {
        if(list == null || list.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    @GetMapping("/sortByIngredientCount")
    public String sortByIngredientCount() {
        Selectors.sortingSelector = Selectors.SortingSelector.SORT_BY_INGREDIENT_COUNT;
        return "redirect:/recipes";
    }

    @GetMapping("/sortByMatchPercent")
    public String sortByMatchPercent() {
        Selectors.sortingSelector = Selectors.SortingSelector.SORT_BY_MATCH_PERCENTAGE;
        return "redirect:/recipes";
    }

    @GetMapping("/dontSort")
    public String dontSort() {
        Selectors.sortingSelector = Selectors.SortingSelector.SORT_BY_MATCH_PERCENTAGE;
        return "redirect:/recipes";
    }

    @PostMapping("/search")
    public String search(@RequestParam(name="search") String search, Model model) {
        if(search == null || search.isEmpty()) {
            return "redirect:/recipes";
        } else {
            ArrayList<String> ingredientList = ingredientInputService.getIngredients();
            if(checkIfListEmpty(ingredientList)) {
                return "redirect:/ingredients_input";
            }
            ArrayList<Recipe> recipeList = recipesService.getMatchingRecipes(ingredientList);
            if(checkIfListEmpty(recipeList)) {
                return "redirect:/ingredients_input";
            }

            List<Recipe> filteredRecipeList = recipeList.stream().filter(r -> r.getTitle().toLowerCase().contains(search.toLowerCase())).toList();

            model.addAttribute("recipeList", filteredRecipeList);
            recipesService.resetIngredientsAvailability(recipeList);
        }
        return "recipes";
    }
}
