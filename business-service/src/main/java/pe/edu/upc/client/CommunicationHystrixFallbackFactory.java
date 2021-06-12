package pe.edu.upc.client;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import pe.edu.upc.models.Comment;

@Component
public class CommunicationHystrixFallbackFactory implements  CommunicationClient{
    @Override
    public ResponseEntity<Comment> getComment(long id) {
        Comment comment = Comment.builder()
                .text("none").build();
        return ResponseEntity.ok(comment);
    }
}

/*private Long id;
    private Date date;
    private String text;
    private Integer Likes;
    private Publication publication;*/
