package pe.edu.upc.security.controllers;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.security.entities.Chef;
import pe.edu.upc.security.entities.Homie;
import pe.edu.upc.security.services.ChefService;
import pe.edu.upc.security.services.HomieService;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@Api
@RequestMapping("/chefs")
public class ChefController {
    @Autowired
    private ChefService chefService;


    @GetMapping(path = "/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Chef> fetchById(@PathVariable("id") Long id) {
        try {
            Optional<Chef> optionalChef = chefService.findById(id);
            if(optionalChef.isPresent()) {
                return new ResponseEntity<Chef>(optionalChef.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Chef> save(@Valid @RequestBody Chef chef, BindingResult result) {

        try {
            Chef chefCreate = chefService.save(chef);
            return ResponseEntity.status(HttpStatus.CREATED).body(chefCreate);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Chef> update(@PathVariable("id") Long id, @RequestBody Chef chef) {

        try {
            Optional<Chef> optionalChef = chefService.findById(id);
            if (optionalChef.isPresent()) {
                Chef chefCreate = chefService.save(chef);
                return ResponseEntity.status(HttpStatus.CREATED).body(chefCreate);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Chef> deleteById(@PathVariable("id") Long id) {

        try {
            Optional<Chef> optionalChef = chefService.findById(id);
            if (optionalChef.isPresent()) {
                chefService.deleteById(id);
                return new ResponseEntity<Chef>(HttpStatus.OK);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
