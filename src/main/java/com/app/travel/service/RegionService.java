package com.app.travel.service;

import com.app.travel.models.Region;
import com.app.travel.repositories.RegionRepository;
import com.app.travel.util.exceptions.ObjectDoesNotExistInDb;
import org.springframework.stereotype.Service;

@Service
public class RegionService extends BaseCrudService<Region, Integer>{
    public RegionService(RegionRepository repository) {
        super(repository);
    }

    public Region getRegionsSuperRegion(Integer id) throws Exception {
        var result = repository.findById(id);
        if(result.isPresent()) return result.get().getSuperRegion();
        throw new ObjectDoesNotExistInDb("Object with id " + id + " does not exist.", Region.class.getName());
    }
}
