package BakeryManager.controller;

import BakeryManager.model.Recipe;
import BakeryManager.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @GetMapping
    public List<Recipe> getAllRecipes() {
        return recipeService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recipe> getRecipeById(@PathVariable Long id) {
        Optional<Recipe> recipe = recipeService.findById(id);
        return recipe.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Recipe createRecipe(@RequestBody Recipe recipe) {
        return recipeService.save(recipe);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Recipe> updateRecipe(@PathVariable Long id, @RequestBody Recipe recipeDetails) {
        Optional<Recipe> recipe = recipeService.findById(id);
        if (recipe.isPresent()) {
            Recipe updatedRecipe = recipe.get();
            updatedRecipe.setRecipeName(recipeDetails.getRecipeName());
            updatedRecipe.setIngredientsForRecipe(recipeDetails.getIngredientsForRecipe());
            updatedRecipe.setBakingTime(recipeDetails.getBakingTime());
            return ResponseEntity.ok(recipeService.save(updatedRecipe));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecipe(@PathVariable Long id) {
        recipeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}