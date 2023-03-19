package com.app.travel.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.app.travel.models.Service;
import com.app.travel.service.ServiceService;

@RestController
@RequestMapping(path = "service")
public class ServiceControler extends BaseController<Service, Integer, ServiceService>{
    @Autowired
    public ServiceControler(ServiceService service) {
        super(service);
    }
}
