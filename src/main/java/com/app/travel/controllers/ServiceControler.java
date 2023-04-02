package com.app.travel.controllers;

import com.app.travel.models.Service;
import com.app.travel.models.dto.ServiceInsertDTO;
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
    public ResponseEntity<Service> post(@RequestBody @Valid ServiceInsertDTO request) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.insert(request));
    }

    @GetMapping
    public ResponseEntity<ServiceReturnDTO> getDto(int id) throws Exception {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.getDto(id));
    }

    @GetMapping(path = "/list")
    public ResponseEntity<List<ServiceReturnDTO>> getAllDto(int page, int pageSize) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.getAllDto(page, pageSize));
    }

    @PutMapping
    public ResponseEntity<ServiceReturnDTO> put(Integer id, @RequestBody @Valid ServiceInsertDTO request) throws Exception {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.update(id, request));
    }

    @PatchMapping
    public ResponseEntity<ServiceReturnDTO> patch(Integer id, @RequestBody ServiceInsertDTO request) throws Exception {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.patch(id, request));
    }

    @DeleteMapping
    public ResponseEntity<Integer> delete(Integer id){
        return super.delete(id);
    }






}
