package BakeryManager.model;

import java.util.Map;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapKeyColumn;
import jakarta.persistence.Table;
 
@Entity 
@Table(name = "BM_RECIPES")
public class Recipe { 
     
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 
     
    @Column(nullable = false, unique = true)
    private String recipeName;  
     
    @ElementCollection
    @CollectionTable(name = "recipe_ingredients", joinColumns = @JoinColumn(name = "recipe_id"))
    @MapKeyColumn(name = "ingredient_name")
    @Column(name = "quantity")
    private Map<String, Integer> ingredientsForRecipe; // Ingrediente e quantidade  
     
    @Column(nullable = false)
    private int bakingTime; 
      
    public Recipe() {} 

    public Recipe(String recipeName, Map<String, Integer> ingredientsForRecipe, int bakingTime) {
        this.recipeName = recipeName;
        this.ingredientsForRecipe = ingredientsForRecipe;
        this.bakingTime = bakingTime;
    } 
     
    //Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public Map<String, Integer> getIngredientsForRecipe() {
        return ingredientsForRecipe;
    }

    public void setIngredientsForRecipe(Map<String, Integer> ingredientsForRecipe) {
        this.ingredientsForRecipe = ingredientsForRecipe;
    }

    public int getBakingTime() {
        return bakingTime;
    }

    public void setBakingTime(int bakingTime) {
        this.bakingTime = bakingTime;
    }

    @Override
    public String toString() {
        return "Receita: " + recipeName + ", Tempo de preparo: " + bakingTime + " minutos, Ingredientes: " + ingredientsForRecipe;
    }
}
