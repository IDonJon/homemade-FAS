package pe.edu.upc.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.security.entities.Chef;

@Repository
public interface ChefRepository extends JpaRepository<Chef, Long> {

}
