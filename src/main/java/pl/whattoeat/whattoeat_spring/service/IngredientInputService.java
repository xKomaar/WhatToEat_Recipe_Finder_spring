package pl.whattoeat.whattoeat_spring.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.regex.Pattern;

@Service
@AllArgsConstructor
public class IngredientInputService {
    private ArrayList<String> ingredientList;

    public void addIngredient(String input) {
        if(input != null) {
            input = input.toLowerCase();
            if(!input.equals("") && !ingredientList.contains(input) && isAWord(input)) {
                ingredientList.add(input);
            }
        }
    }

    public ArrayList<String> getIngredients() {
        return ingredientList;
    }

    public void deleteIngredient(String ingredient) {
        ingredientList.remove(ingredient);
    }

    public void deleteAllIngredients() {
        ingredientList.clear();
    }

    private boolean isAWord(String s) {
        Pattern pattern = Pattern.compile("[a-z\\s]+");
        if(pattern.matcher(s).matches()) {
            return true;
        }
        return false;
    }
}
