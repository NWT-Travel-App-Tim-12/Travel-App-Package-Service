package com.app.travel.service;

import org.springframework.data.jpa.repository.JpaRepository;

import java.lang.reflect.Field;
import java.util.List;

public class BaseCrudService<ModelType, ModelIdType > {
    protected final JpaRepository<ModelType, ModelIdType> repository;


    public BaseCrudService(JpaRepository<ModelType, ModelIdType> repository){
        this.repository = repository;
    }

    public ModelType get(ModelIdType id) throws Exception {
        var result = repository.findById(id);
        if(result.isPresent()) return result.get();
        throw new Exception("Object with id " + id + " does not exist.");
    }

    public List<ModelType> getAll(){
        return repository.findAll();
    }

    public ModelType insert(ModelType model){
        return repository.save(model);
    }

    public ModelType update(ModelIdType id, ModelType model) throws Exception {
        var result = repository.findById(id);
        if(result.isEmpty()) throw new Exception("Object with id " + id + " does not exist.");
        var modelInDB = result.get();
        updateAllFieldOfObject(modelInDB, model);
        repository.save(modelInDB);
        return modelInDB;
    }

    public void delete(ModelIdType id){
        repository.deleteById(id);
    }

    private void updateAllFieldOfObject(ModelType acceptor, ModelType donor) throws IllegalAccessException {
        for(Field field : donor.getClass().getDeclaredFields()){
            field.setAccessible(true);
            Object value = field.get(donor);
            if(value != null)
                field.set(acceptor, value);
        }
    }

}
