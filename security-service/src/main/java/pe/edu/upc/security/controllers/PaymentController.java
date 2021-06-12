package pe.edu.upc.security.controllers;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.security.entities.Payment;
import pe.edu.upc.security.services.PaymentService;

import javax.validation.Valid;
import javax.xml.ws.Response;
import java.util.Optional;


@RestController
@Api
@RequestMapping("/payments")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;


    @GetMapping(path = "/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Payment> fetchById(@PathVariable("id") Long id) {
        try {
            Optional<Payment> optionalPayment = paymentService.findById(id);
            if(optionalPayment.isPresent()) {
                return new ResponseEntity<Payment>(optionalPayment.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Payment> save(@Valid @RequestBody Payment payment, BindingResult result) {

        try {
            Payment paymentCreate = paymentService.save(payment);
            return ResponseEntity.status(HttpStatus.CREATED).body(paymentCreate);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Payment> update(@PathVariable("id") Long id, @RequestBody Payment payment) {

        try {
            Optional<Payment> optionalPayment = paymentService.findById(id);
            if (optionalPayment.isPresent()) {
                Payment paymentCreate = paymentService.save(payment);
                return ResponseEntity.status(HttpStatus.CREATED).body(paymentCreate);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Payment> deleteById(@PathVariable("id") Long id) {


        try {
            Optional<Payment> optionalPayment = paymentService.findById(id);
            if (optionalPayment.isPresent()) {
                paymentService.deleteById(id);
                return new ResponseEntity<Payment>(HttpStatus.OK);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
