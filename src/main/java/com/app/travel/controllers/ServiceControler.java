package com.app.travel.controllers;

import com.app.travel.models.Service;
import com.app.travel.models.dto.ServiceDTO;
import com.app.travel.models.dto.ServiceReturnDTO;
import com.app.travel.service.ServiceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "service")
public class ServiceControler extends BaseController<Service, Integer, ServiceService>{
    private final ServiceService service;
    @Autowired
    public ServiceControler(ServiceService service) {
        super(service);
        this.service = service;
    }

    @PostMapping
    public ServiceDTO post(@RequestBody @Valid ServiceDTO request) {
        return service.insert(request);
    }

    @GetMapping
    public ResponseEntity<ServiceReturnDTO> getDto(int id) throws Exception {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.getDto(id));
    }

    @GetMapping(path = "/list")
    public ResponseEntity<List<ServiceReturnDTO>> getAllDto(int page, int pageSize) throws Exception {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.getAllDto(page, pageSize));
    }

    @PutMapping
    public ResponseEntity<Service> put(Integer id, @RequestBody @Valid Service request) throws Exception {
        return super.put(id, request);
    }

    @PatchMapping
    public ResponseEntity<Service> patch(Integer id, @RequestBody @Valid Service request) throws Exception {
        return super.patch(id, request);
    }

    @DeleteMapping
    public ResponseEntity<Integer> delete(Integer id){
        return super.delete(id);
    }






}
