package pl.whattoeat.whattoeat_spring.model;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.InputStreamReader;
import java.util.ArrayList;

public final class RecipeJsonParser {

    private static RecipeJsonParser instance;
    private final ArrayList<Recipe> recipeList;

    private RecipeJsonParser() {
        recipeList = new ArrayList<>();
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new InputStreamReader(this.getClass().getResourceAsStream("/recipes.json")));
            JSONArray recipeJsonArray = (JSONArray)obj;

            for (Object recipe : recipeJsonArray) {
                JSONObject recipeJson = (JSONObject)recipe;

                String title = (String) recipeJson.get("Title");
                String instructions = (String) recipeJson.get("Instructions");
                String pictureLink = (String) recipeJson.get("Image_Name");

                JSONArray ingredientJsonArray = (JSONArray) recipeJson.get("Ingredients");
                ArrayList<Ingredient> ingredientList = new ArrayList<>();
                for (Object ingredient : ingredientJsonArray) {
                    ingredientList.add(new Ingredient((String)ingredient));
                }
                if(!ingredientList.isEmpty() && !title.equals("") && !instructions.equals("") && !pictureLink.equals("")) {
                    recipeList.add(new Recipe(title, ingredientList, instructions, pictureLink));
                }
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    //Singleton
    public static ArrayList<Recipe> getRecipeList() {
        if(instance == null) {
            instance = new RecipeJsonParser();
        }
        return instance.recipeList;
    }
}
