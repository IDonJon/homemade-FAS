package pe.edu.upc.security.services.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.security.entities.Payment;
import pe.edu.upc.security.exception.ResourceNotFoundException;
import pe.edu.upc.security.repositories.PaymentRepository;
import pe.edu.upc.security.services.PaymentService;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentServiceImplementation implements PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    @Transactional
    @Override
    public Payment save(Payment entity) throws Exception {
        return paymentRepository.save(entity);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Payment> findAll() throws Exception {
        return paymentRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Payment> findById(Long aLong) throws Exception {
        return paymentRepository.findById(aLong);
    }

    @Transactional
    @Override
    public Payment update(Payment entity) throws Exception {
        return paymentRepository.save(entity);
    }

    @Transactional
    @Override
    public void deleteById(Long aLong) throws Exception {
        paymentRepository.deleteById(aLong);
    }

    @Override
    public Payment getPaymentById(Long paymentId) {
        return paymentRepository.findById(paymentId).orElseThrow(() -> new ResourceNotFoundException("Payment", "Id", paymentId));
    }
}
