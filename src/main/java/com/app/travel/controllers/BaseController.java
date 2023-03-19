package com.app.travel.controllers;

import com.app.travel.service.BaseCrudService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class BaseController <ModelType, ModelIdType,  ModelService extends BaseCrudService<ModelType, ModelIdType>>{

    protected final ModelService service;
    public BaseController(ModelService service){
        this.service = service;
    }

    @GetMapping
    public ModelType get(ModelIdType id) throws Exception {
        var nesto = service.get(id);
        return nesto;
    }

    @GetMapping(path = "/list")
    public List<ModelType> getAll() throws Exception {
        return service.getAll();
    }

    @PostMapping
    public ModelType post(@RequestBody ModelType request){
        return service.insert(request);
    }

    @PutMapping
    public ModelType put(ModelIdType id, @RequestBody ModelType request) throws Exception {
        return service.update(id, request);
    }

    @PatchMapping
    public ModelType patch(ModelIdType id, @RequestBody ModelType request) throws Exception {
        return service.update(id, request);
    }

    @DeleteMapping
    public int delete(ModelIdType id){
        service.delete(id);
        return 200;
    }
}
