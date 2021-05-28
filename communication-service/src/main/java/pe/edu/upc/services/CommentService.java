package pe.edu.upc.services;

import pe.edu.upc.entities.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentService extends CrudService<Comment, Long>{
    Optional<List<Comment>> findByPublicationId(Long publicationId);
}
