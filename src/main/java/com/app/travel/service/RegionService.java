package com.app.travel.service;

import com.app.travel.models.Region;
import com.app.travel.repositories.RegionRepository;
import org.springframework.stereotype.Service;

@Service
public class RegionService extends BaseCrudService<Region, Integer>{
    public RegionService(RegionRepository repository) {
        super(repository);
    }
}
