package pl.whattoeat.whattoeat_spring.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.whattoeat.whattoeat_spring.service.IngredientInputService;

import java.util.ArrayList;

@Controller
@RequestMapping("/ingredients_input")
@AllArgsConstructor
public class IngredientInputController {

    private final IngredientInputService ingredientInputService;

    @GetMapping("")
    public String getIngredients(Model model) {
        ArrayList<String> ingredientList = ingredientInputService.getIngredients();
        model.addAttribute("ingredientList", ingredientList);
        return "ingredients";
    }

    @GetMapping("/add")
    public String redirectAdd(Model model) {
        ArrayList<String> ingredientList = ingredientInputService.getIngredients();
        model.addAttribute("ingredientList", ingredientList);
        return "addIngredient";
    }

    @PostMapping("/add")
    public String addIngredient(@RequestParam String ingredient) {
        ingredientInputService.addIngredient(ingredient);
        return "redirect:/ingredients_input";
    }

    @GetMapping("/delete/{ingredient}")
    public String deleteIngredient(@PathVariable String ingredient) {
        ingredientInputService.deleteIngredient(ingredient);
        return "redirect:/ingredients_input";
    }

    @GetMapping("/deleteAll")
    public String deleteAllIngredients() {
        ingredientInputService.deleteAllIngredients();
        return "redirect:/ingredients_input";
    }

}
