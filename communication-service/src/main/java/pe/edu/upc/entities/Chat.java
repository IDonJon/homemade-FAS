package pe.edu.upc.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "chats")
@Data
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dateOfChat")
    private Date date;

    /*@ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    /*@JoinTable(name = "chats_users",
            joinColumns = {@JoinColumn(name = "chat_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")})
    /*private List<User> users;*/
}

