package pe.edu.upc.security.controllers;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.security.entities.Homie;
import pe.edu.upc.security.entities.Payment;
import pe.edu.upc.security.services.HomieService;
import pe.edu.upc.security.services.PaymentService;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@Api
@RequestMapping("/homies")
public class HomieController {
    @Autowired
    private HomieService homieService;


    @GetMapping(path = "/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Homie> fetchById(@PathVariable("id") Long id) {
        try {
            Optional<Homie> optionalHomie = homieService.findById(id);
            if(optionalHomie.isPresent()) {
                return new ResponseEntity<Homie>(optionalHomie.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Homie> save(@Valid @RequestBody Homie homie, BindingResult result) {

        try {
            Homie homieCreate = homieService.save(homie);
            return ResponseEntity.status(HttpStatus.CREATED).body(homieCreate);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Homie> update(@PathVariable("id") Long id, @RequestBody Homie homie) {

        try {
            Optional<Homie> optionalHomie = homieService.findById(id);
            if (optionalHomie.isPresent()) {
                Homie homieCreate = homieService.save(homie);
                return ResponseEntity.status(HttpStatus.CREATED).body(homieCreate);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Homie> deleteById(@PathVariable("id") Long id) {


        try {
            Optional<Homie> optionalHomie = homieService.findById(id);
            if (optionalHomie.isPresent()) {
                homieService.deleteById(id);
                return new ResponseEntity<Homie>(HttpStatus.OK);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
