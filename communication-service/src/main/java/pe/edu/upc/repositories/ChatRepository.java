package pe.edu.upc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.entities.Chat;

import java.util.Optional;
@Repository
public interface ChatRepository extends JpaRepository<Chat, Long> {

}