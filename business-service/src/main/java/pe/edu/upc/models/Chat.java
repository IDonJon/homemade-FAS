package pe.edu.upc.models;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Data
public class Chat {
    private Long id;
    private Date date;

}
