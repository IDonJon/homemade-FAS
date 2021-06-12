package pe.edu.upc.security.services;

import pe.edu.upc.security.entities.Homie;

public interface HomieService extends CrudService<Homie, Long> {
    Homie getHomieById(Long aLong);
}
