package Model;

import java.util.Map;

public class Recipe {
    private String recipeName; 
    private Map<String, Integer> ingredients; // Ingrediente e quantidade 
    private int bakingTime; 
     
    public Recipe(String recipeName, Map<String, Integer> ingredients, int bakingTime) {
        this.recipeName = recipeName;
        this.ingredients = ingredients;
        this.bakingTime = bakingTime;
    } 
     
    public String getName() {
        return recipeName;
    }

    public Map<String, Integer> getIngredients() {
        return ingredients;
    }

    public int getBakingTime() {
        return bakingTime;
    }

    @Override
    public String toString() {
        return "Receita: " + recipeName + ", Tempo de preparo: " + bakingTime + " minutos, Ingredientes: " + ingredients;
    }
}
