package pe.edu.upc.security;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pe.edu.upc.security.entities.Payment;
import pe.edu.upc.security.exception.ResourceNotFoundException;
import pe.edu.upc.security.repositories.PaymentRepository;
import pe.edu.upc.security.services.PaymentService;
import pe.edu.upc.security.services.impls.PaymentServiceImplementation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class PaymentServiceImpIntegrationTest {
    @MockBean
    private PaymentRepository paymentRepository;

    @Autowired
    private PaymentService paymentService;

    @TestConfiguration
    static class PaymentServiceImpTestConfiguration {
        @Bean
        public PaymentService paymentService() {
            return new PaymentServiceImplementation();
        }
    }

    @Test
    @DisplayName("When Get Payments By Id With Valid Id Then Returns Payments")
    public void whenGetPaymentsByIdWithValidIdThenReturnsPayments() throws ParseException {
        //Arrange
        Date date = new SimpleDateFormat("dd/MM/yy").parse("28/10/2020");
        String description = "Pago de suscripción";
        Payment payment = new Payment();
        payment.setId(10L);
        payment.setDescription(description);
        payment.setDate(date);
        when(paymentRepository.findById(10L)).thenReturn(Optional.of(payment));
        //Act
        Payment foundPayment = paymentService.getPaymentById(10L);
        //Assert
        assertThat(foundPayment.getId()).isEqualTo(10L);
    }

    @Test
    @DisplayName("When Get Payment Id With Invalid Id Then Returns ResourceNotFoundException")
    public void whenGetPaymentByIdWithInvalidIdThenReturnsResourceNotFoundException() {
        //Arrange
        Long id = 5L;
        String template = "Resource %s not found for %s with value %s";
        when(paymentRepository.findById(id)).thenReturn(Optional.empty());
        String expectedMessage = String.format(template, "Payment", "Id", id);

        //Act
        Throwable exception = catchThrowable(() -> {
            Payment payment = paymentService.getPaymentById(id);
        });

        //Assert
        assertThat(exception).isInstanceOf(ResourceNotFoundException.class).hasMessage(expectedMessage);
    }
}
