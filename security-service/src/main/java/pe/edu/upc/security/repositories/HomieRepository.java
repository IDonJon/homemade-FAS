package pe.edu.upc.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.security.entities.Homie;

@Repository
public interface HomieRepository extends JpaRepository<Homie, Long> {
}
