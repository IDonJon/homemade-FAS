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
import pe.edu.upc.services.IngredientsService;

import java.util.Optional;

@RestController
@RequestMapping("/ingredients")
public class IngredientsController {
    @Autowired
    private IngredientsService ingredientsService;

    @GetMapping(path = "/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Ingredients> fetchById(@PathVariable("id") Long id) {
        try {
            Optional<Ingredients> optionalIngredients = ingredientsService.findById(id);
            if(optionalIngredients.isPresent()){
                return new ResponseEntity<Ingredients>(optionalIngredients.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Falta Name
}
