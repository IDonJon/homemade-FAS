package pe.edu.upc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.entities.Menu;

public interface MenuRepository extends JpaRepository<Menu, Long> {

}
