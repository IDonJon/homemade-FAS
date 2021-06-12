package pe.edu.upc.models;

import lombok.Data;
import lombok.Builder;
import java.beans.Transient;
import java.util.Date;

@Data
@Builder
public class Comment {
    private Long id;
    private Date date;
    private String text;
    private Integer Likes;
    private Publication publication;
}
