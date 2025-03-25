package BakeryManager.repository;

import BakeryManager.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    Recipe findByRecipeName(String recipeName);
}