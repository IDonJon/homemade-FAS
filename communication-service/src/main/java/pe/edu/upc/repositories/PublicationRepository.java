package pe.edu.upc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.entities.Publication;

public interface PublicationRepository extends JpaRepository<Publication, Long> {

}
