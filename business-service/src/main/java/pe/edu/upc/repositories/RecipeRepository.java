package pe.edu.upc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.entities.Ingredients;
import pe.edu.upc.entities.Recipe;

import java.util.Optional;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    Optional<Recipe> findByTitle(String title);
}
