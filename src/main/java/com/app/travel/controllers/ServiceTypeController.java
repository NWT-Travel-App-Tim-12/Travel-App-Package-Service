package com.app.travel.controllers;

import com.app.travel.models.ServiceType;
import com.app.travel.service.ServiceTypeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<ServiceType> get(int id) throws Exception {
        return super.get(id);
    }

    @GetMapping(path = "/list")
    public ResponseEntity<List<ServiceType>> getAll(int page, int pageSize) throws Exception {
        return super.getAll(page, pageSize);
    }

    @PostMapping
    public ResponseEntity<ServiceType> post(@RequestBody @Valid ServiceType request) throws Exception {
        return super.post(request);
    }

    @PutMapping
    public ResponseEntity<ServiceType> put(Integer id, @RequestBody @Valid ServiceType request) throws Exception {
        return super.put(id, request);
    }

    @PatchMapping
    public ResponseEntity<ServiceType> patch(Integer id, @RequestBody ServiceType request) throws Exception {
        return super.patch(id, request);
    }

    @DeleteMapping
    public ResponseEntity<Integer> delete(Integer id){
        return super.delete(id);
    }
}
