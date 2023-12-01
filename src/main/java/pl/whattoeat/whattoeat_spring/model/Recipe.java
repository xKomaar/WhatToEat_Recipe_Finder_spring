package pl.whattoeat.whattoeat_spring.model;

import java.util.ArrayList;
import java.util.Objects;

public final class Recipe {
    private final String title;
    private final ArrayList<Ingredient> ingredientList;
    private final String instructions;
    private int matchPercent;

    public Recipe(String title, ArrayList<Ingredient> ingredientList, String instructions) {
        this.title = title;
        this.ingredientList = ingredientList;
        this.instructions = instructions;
        this.matchPercent = 0;
    }

    public String getTitle() {
        return this.title;
    }

    public ArrayList<Ingredient> getIngredientList() {
        return this.ingredientList;
    }

    public String getInstructions() {
        return this.instructions;
    }

    public void setMatchPercent(int matchPercent) {
        this.matchPercent = matchPercent;
    }

    public int getMatchPercent() {
        return this.matchPercent;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Recipe) obj;
        return Objects.equals(this.title, that.title) &&
                Objects.equals(this.ingredientList, that.ingredientList) &&
                Objects.equals(this.instructions, that.instructions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, ingredientList, instructions);
    }

    @Override
    public String toString() {
        return "Recipe[" +
                "title=" + title + ", " +
                "ingredientList=" + ingredientList + ", " +
                "instructions=" + instructions + ']';
    }
}