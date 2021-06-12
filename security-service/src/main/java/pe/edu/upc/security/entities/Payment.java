package pe.edu.upc.security.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "payments")
@Data
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(name = "description", length = 200)
    private String description;
    @Column(name = "dateOfPayment")
    private Date date;
}
