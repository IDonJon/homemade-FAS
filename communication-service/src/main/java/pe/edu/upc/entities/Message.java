package pe.edu.upc.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;


import javax.persistence.*;

@Entity
@Table(name = "messages")
@Data
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String text;

    private String file;

    /*@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore
    private User user;

    */@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chat_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private Chat chat;
}