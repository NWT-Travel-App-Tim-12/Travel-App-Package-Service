package com.app.travel.controllers;

import com.app.travel.service.BaseCrudService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class BaseController <ModelType, ModelIdType,  ModelService extends BaseCrudService<ModelType, ModelIdType>>{

    public final ModelService service;
    public BaseController(ModelService service){
        this.service = service;
    }
    
    public ResponseEntity<ModelType> get(ModelIdType id) throws Exception {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.get(id));
    }
    
    public ResponseEntity<List<ModelType>> getAll(int page, int pageSize) throws Exception {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.getAll(page, pageSize));
    }
    
    public ResponseEntity<ModelType> post(@RequestBody ModelType request){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.insert(request));
    }
    
    public ResponseEntity<ModelType> put(ModelIdType id, @RequestBody ModelType request) throws Exception {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.update(id, request));
    }
    
    public ResponseEntity<ModelType> patch(ModelIdType id, @RequestBody ModelType request) throws Exception {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.patch(id, request));
    }
    
    public ResponseEntity<ModelIdType> delete(ModelIdType id){
        service.delete(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(id);
    }
}
