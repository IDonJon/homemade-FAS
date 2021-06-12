package pe.edu.upc.models;

import lombok.Data;

import java.util.Date;

@Data
public class Publication {
    private Long id;
    private Date date;
    private String text;
    private Integer likes;
}
