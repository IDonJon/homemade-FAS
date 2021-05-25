package pe.edu.upc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.entities.Ingredients;
import pe.edu.upc.entities.Recipe;
import pe.edu.upc.services.RecipeService;

import java.util.Optional;

@RestController
@RequestMapping("/recipe")
public class RecipeController {
    @Autowired
    private RecipeService recipeService;

    @GetMapping(path = "/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Recipe> fetchById(@PathVariable("id") Long id) {
        try {
            Optional<Recipe> optionalRecipe = recipeService.findById(id);
            if(optionalRecipe.isPresent()){
                return new ResponseEntity<Recipe>(optionalRecipe.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Falta Title
    //Falta Name
    @GetMapping(path = "/title/{title}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Recipe> fetchById(@PathVariable("title") String title){
        try {
            Optional<Recipe> optionalRecipe = recipeService.findbyTitle(title);
            if (optionalRecipe.isPresent()){
                return ResponseEntity.ok(optionalRecipe.get());
            } else{
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            //e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
