package pe.edu.upc.security.services;

import pe.edu.upc.security.entities.Chef;

public interface ChefService extends  CrudService<Chef, Long> {
    Chef getChefById(Long aLong);
}
