package pe.edu.upc.security.services.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.security.entities.Chef;
import pe.edu.upc.security.exception.ResourceNotFoundException;
import pe.edu.upc.security.repositories.ChefRepository;
import pe.edu.upc.security.services.ChefService;

import java.util.List;
import java.util.Optional;

@Service
public class ChefServiceImplementation implements ChefService {
    @Autowired
    private ChefRepository chefRepository;

    @Transactional
    @Override
    public Chef save(Chef entity) throws Exception {
        return chefRepository.save(entity);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Chef> findAll() throws Exception {
        return chefRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Chef> findById(Long aLong) throws Exception {
        return chefRepository.findById(aLong);
    }

    @Transactional
    @Override
    public Chef update(Chef entity) throws Exception {
        return chefRepository.save(entity);
    }

    @Transactional
    @Override
    public void deleteById(Long aLong) throws Exception {
        chefRepository.deleteById(aLong);
    }

    @Override
    public Chef getChefById(Long chefId) {
        return chefRepository.findById(chefId).orElseThrow(() -> new ResourceNotFoundException("Chef", "Id", chefId));
    }
}
