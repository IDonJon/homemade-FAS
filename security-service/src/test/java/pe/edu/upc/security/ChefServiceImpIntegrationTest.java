package pe.edu.upc.security;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pe.edu.upc.security.entities.Chef;
import pe.edu.upc.security.entities.Homie;
import pe.edu.upc.security.exception.ResourceNotFoundException;
import pe.edu.upc.security.repositories.ChefRepository;
import pe.edu.upc.security.repositories.HomieRepository;
import pe.edu.upc.security.services.ChefService;
import pe.edu.upc.security.services.HomieService;
import pe.edu.upc.security.services.impls.ChefServiceImplementation;
import pe.edu.upc.security.services.impls.HomieServiceImplementation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class ChefServiceImpIntegrationTest {
    @MockBean
    private ChefRepository chefRepository;

    @Autowired
    private ChefService chefService;

    @TestConfiguration
    static class ChefServiceImpTestConfiguration {
        @Bean
        public ChefService chefService() {
            return new ChefServiceImplementation();
        }
    }

    @Test
    @DisplayName("When Get Chef By Id With Valid Id Then Returns Chef")
    public void whenGetChefByIdWithValidIdThenReturnsChef() throws ParseException {
        //Arrange
        Chef chef = new Chef();
        chef.setId(10L);
        chef.setName("John");
        chef.setSurname("Doe");
        chef.setDni(1234567L);
        chef.setEmail("johndoe@gmail.com");
        chef.setPhone(123456789L);
        chef.setFile("url.jpg");
        chef.setAddress("av. john doe");
        chef.setAge(10);
        when(chefRepository.findById(10L)).thenReturn(Optional.of(chef));
        //Act
        Chef foundChef = chefService.getChefById(10L);
        //Assert
        assertThat(foundChef.getId()).isEqualTo(10L);
    }

    @Test
    @DisplayName("When Get Chef Id With Invalid Id Then Returns ResourceNotFoundException")
    public void whenGetChefByIdWithInvalidIdThenReturnsResourceNotFoundException() {
        //Arrange
        Long id = 5L;
        String template = "Resource %s not found for %s with value %s";
        when(chefRepository.findById(id)).thenReturn(Optional.empty());
        String expectedMessage = String.format(template, "Chef", "Id", id);

        //Act
        Throwable exception = catchThrowable(() -> {
            Chef chef = chefService.getChefById(id);
        });

        //Assert
        assertThat(exception).isInstanceOf(ResourceNotFoundException.class).hasMessage(expectedMessage);
    }
}
