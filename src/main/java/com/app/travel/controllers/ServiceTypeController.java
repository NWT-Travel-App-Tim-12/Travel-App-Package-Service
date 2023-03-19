package com.app.travel.controllers;

import com.app.travel.models.ServiceType;
import com.app.travel.service.ServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "service-type")
public class ServiceTypeController extends BaseController<ServiceType, Integer, ServiceTypeService>{
    @Autowired
    public ServiceTypeController(ServiceTypeService service) {
        super(service);
    }
}
