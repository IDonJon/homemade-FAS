package pe.edu.upc.security.services;

import pe.edu.upc.security.entities.Payment;
import pe.edu.upc.security.repositories.PaymentRepository;

public interface PaymentService extends CrudService<Payment, Long> {
    Payment getPaymentById(Long aLong);
}
