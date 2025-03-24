package BakeryManager.model;

import java.util.Map;

public class Recipe {
    private String recipeName; 
    private Map<String, Integer> ingredientsForRecipe; // Ingrediente e quantidade 
    private int bakingTime; 
     
    public Recipe(String recipeName, Map<String, Integer> ingredientsForRecipe, int bakingTime) {
        this.recipeName = recipeName;
        this.ingredientsForRecipe = ingredientsForRecipe;
        this.bakingTime = bakingTime;
    } 
     
    public String getName() {
        return recipeName;
    }

    public Map<String, Integer> getIngredients() {
        return ingredientsForRecipe;
    }

    public int getBakingTime() {
        return bakingTime;
    }

    @Override
    public String toString() {
        return "Receita: " + recipeName + ", Tempo de preparo: " + bakingTime + " minutos, Ingredientes: " + ingredientsForRecipe;
    }
}
