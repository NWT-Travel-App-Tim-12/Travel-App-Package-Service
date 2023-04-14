package com.app.travel.service;

import com.app.travel.client.UserClient;
import com.app.travel.models.Package;
import com.app.travel.repositories.PackageRepository;
import com.app.travel.util.exceptions.ObjectDoesNotExistInDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PackageService extends BaseCrudService<Package, Integer>{
    public PackageService(PackageRepository repository) {
        super(repository);
    }

    @Autowired
    private UserClient userClient;
    @Override
    public Package insert(Package model) throws Exception {
        if(userClient.getUser(model.getAgentRef())==null)
            throw new ObjectDoesNotExistInDb("No data with id " + model.getAgentRef() + "!", "agentRef");

        return super.insert(model);
    }
}
