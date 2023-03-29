package com.app.travel.controllers;

import com.app.travel.service.BaseCrudService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class BaseController <ModelType, ModelIdType,  ModelService extends BaseCrudService<ModelType, ModelIdType>>{

    public final ModelService service;
    public BaseController(ModelService service){
        this.service = service;
    }
    
    public ModelType get(ModelIdType id) throws Exception {
        return service.get(id);
    }
    
    public List<ModelType> getAll(int page, int pageSize) throws Exception {
        return service.getAll(page, pageSize);
    }
    
    public ModelType post(@RequestBody ModelType request){
        return service.insert(request);
    }
    
    public ModelType put(ModelIdType id, @RequestBody ModelType request) throws Exception {
        return service.update(id, request);
    }
    
    public ModelType patch(ModelIdType id, @RequestBody ModelType request) throws Exception {
        return service.update(id, request);
    }
    
    public int delete(ModelIdType id){
        service.delete(id);
        return 200;
    }
}
