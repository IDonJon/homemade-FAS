package pe.edu.upc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.entities.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

}
