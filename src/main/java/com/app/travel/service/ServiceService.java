package com.app.travel.service;

import com.app.travel.models.Service;
import com.app.travel.repositories.ServiceRepository;

@org.springframework.stereotype.Service
public class ServiceService extends BaseCrudService<Service, Integer>{
    public ServiceService(ServiceRepository repository) {
        super(repository);
    }
}
