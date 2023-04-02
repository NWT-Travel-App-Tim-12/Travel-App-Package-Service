package com.app.travel.service;

import com.app.travel.util.annotations.IgnoreOnObjectUpdate;
import com.app.travel.util.exceptions.MissingParameterInRequest;
import com.app.travel.util.exceptions.ObjectDoesNotExistInDb;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class BaseCrudService<ModelType, ModelIdType> {

    protected final JpaRepository<ModelType, ModelIdType> repository;

    private final Class<ModelType> modelClass;

    public BaseCrudService(JpaRepository<ModelType, ModelIdType> repository) {
        this.repository = repository;
        modelClass = (Class<ModelType>)((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public ModelType get(ModelIdType id) throws Exception {
        var result = repository.findById(id);
        if(result.isPresent()) return result.get();
        throw new ObjectDoesNotExistInDb("No data with id " + id + "!", modelClass.getName());
    }

    public List<ModelType> getAll(int page, int pageSize) {
        return repository.findAll(
                PageRequest.of(page, pageSize)
        ).stream().toList();
    }

    public ModelType insert(ModelType model) throws Exception {
        var field = modelClass.getDeclaredField("id");
        field.setAccessible(true);
        field.set(model, null);
        return repository.save(model);
    }

    public ModelType update(ModelIdType id, ModelType model) throws Exception {
        var field = modelClass.getDeclaredField("id");
        field.setAccessible(true);
        field.set(model, id);
        var result = repository.findById(id);
        if (result.isEmpty()) throw new ObjectDoesNotExistInDb("No data with id " + id + "!", modelClass.getName());
        var modelInDB = result.get();
        updateFields(modelInDB, model, true);
        repository.save(modelInDB);
        return modelInDB;
    }

    public ModelType patch(ModelIdType id, ModelType model) throws Exception {
        var result = repository.findById(id);
        if (result.isEmpty()) throw new ObjectDoesNotExistInDb("No data with id " + id + "!", model.getClass().getName());
        var modelInDB = result.get();
        updateFields(modelInDB, model, false);
        repository.save(modelInDB);
        return modelInDB;
    }

    public void delete(ModelIdType id) {
        repository.deleteById(id);
    }


    private void updateFields(ModelType acceptor, ModelType donor, boolean updateAll) throws Exception {
        for (Field field : modelClass.getDeclaredFields()) {
            field.setAccessible(true);
            Object value = field.get(donor);
            if (updateAll) {
                if (
                        !field.isAnnotationPresent(IgnoreOnObjectUpdate.class)
                        && value == null
                ) throw new MissingParameterInRequest("Missing value for field " + field.getName(), field.getName());
                field.set(acceptor, value);
            } else {
                if (value != null) field.set(acceptor, value);
            }
        }
    }

}
