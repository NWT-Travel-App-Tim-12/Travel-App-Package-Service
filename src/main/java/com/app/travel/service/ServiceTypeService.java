package com.app.travel.service;

import com.app.travel.models.ServiceType;
import com.app.travel.repositories.ServiceTypeRepository;
import org.springframework.stereotype.Service;

@Service
public class ServiceTypeService extends BaseCrudService<ServiceType, Integer> {
    public ServiceTypeService(ServiceTypeRepository repository) {
        super(repository);
    }
}
