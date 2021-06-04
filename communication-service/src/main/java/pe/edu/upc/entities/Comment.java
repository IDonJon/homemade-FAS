package pe.edu.upc.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "comments")
@Data
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Date date;

    private String text;

    private Integer likes;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "publication_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private Publication publication;

    /*@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "recipe_id", nullable = false)
    @JsonIgnore
    private Recipe recipe;*/
    }

