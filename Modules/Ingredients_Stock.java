package Modules;

public class Ingredients_Stock extends Stock{ 
    
    public void addIngredient(String ingredient, int quantity){ 
        addItem(ingredient, quantity);
    }; 
     
    public void removeIngredient(String ingredient, int quantity) {
        removeItem(ingredient, quantity);
    }
}
