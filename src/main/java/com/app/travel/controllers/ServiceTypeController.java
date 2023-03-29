package com.app.travel.controllers;

import com.app.travel.models.ServiceType;
import com.app.travel.service.ServiceTypeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "service-type")
public class ServiceTypeController extends BaseController<ServiceType, Integer, ServiceTypeService>{
    @Autowired
    public ServiceTypeController(ServiceTypeService service) {
        super(service);
    }


    @GetMapping
    public ServiceType get(int id) throws Exception {
        return super.get(id);
    }

    @GetMapping(path = "/list")
    public List<ServiceType> getAll(int page, int pageSize) throws Exception {
        return super.getAll(page, pageSize);
    }

    @PostMapping
    public ServiceType post(@RequestBody @Valid ServiceType request) {
        return super.post(request);
    }

    @PutMapping
    public ServiceType put(Integer id, @RequestBody @Valid ServiceType request) throws Exception {
        return super.put(id, request);
    }

    @PatchMapping
    public ServiceType patch(Integer id, @RequestBody @Valid ServiceType request) throws Exception {
        return super.patch(id, request);
    }

    @DeleteMapping
    public int delete(Integer id){
        return super.delete(id);
    }
}
