package pe.edu.upc.security;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pe.edu.upc.security.entities.Homie;
import pe.edu.upc.security.exception.ResourceNotFoundException;
import pe.edu.upc.security.repositories.HomieRepository;
import pe.edu.upc.security.services.HomieService;
import pe.edu.upc.security.services.impls.HomieServiceImplementation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class HomieServiceImpIntegrationTest {
    @MockBean
    private HomieRepository homieRepository;

    @Autowired
    private HomieService homieService;

    @TestConfiguration
    static class HomieServiceImpTestConfiguration {
        @Bean
        public HomieService homieService() {
            return new HomieServiceImplementation();
        }
    }

    @Test
    @DisplayName("When Get Homie By Id With Valid Id Then Returns Homie")
    public void whenGetHomieByIdWithValidIdThenReturnsHomie() throws ParseException {
        //Arrange
        Homie homie = new Homie();
        homie.setId(10L);
        homie.setName("John");
        homie.setSurname("Doe");
        homie.setDni(1234567L);
        homie.setEmail("johndoe@gmail.com");
        homie.setPhone(123456789L);
        when(homieRepository.findById(10L)).thenReturn(Optional.of(homie));
        //Act
        Homie foundHomie = homieService.getHomieById(10L);
        //Assert
        assertThat(foundHomie.getId()).isEqualTo(10L);
    }

    @Test
    @DisplayName("When Get Homie Id With Invalid Id Then Returns ResourceNotFoundException")
    public void whenGetHomieByIdWithInvalidIdThenReturnsResourceNotFoundException() {
        //Arrange
        Long id = 5L;
        String template = "Resource %s not found for %s with value %s";
        when(homieRepository.findById(id)).thenReturn(Optional.empty());
        String expectedMessage = String.format(template, "Homie", "Id", id);

        //Act
        Throwable exception = catchThrowable(() -> {
            Homie homie = homieService.getHomieById(id);
        });

        //Assert
        assertThat(exception).isInstanceOf(ResourceNotFoundException.class).hasMessage(expectedMessage);
    }
}
