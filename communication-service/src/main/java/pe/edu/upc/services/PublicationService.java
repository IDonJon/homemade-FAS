package pe.edu.upc.services;

import pe.edu.upc.entities.Publication;

public interface PublicationService extends CrudService<Publication, Long>{
    Publication getPublicationById(Long aLong);
}
