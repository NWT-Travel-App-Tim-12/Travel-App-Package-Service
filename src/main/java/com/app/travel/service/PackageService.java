package com.app.travel.service;

import com.app.travel.client.UserClient;
import com.app.travel.models.Package;
import com.app.travel.repositories.PackageRepository;
import com.app.travel.util.exceptions.ObjectDoesNotExistInDb;
import feign.FeignException;
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
        try{
            var user = userClient.getUser(model.getAgentId());
        }catch (FeignException e){
            if(e.status() == 500) throw e;
            throw new ObjectDoesNotExistInDb("No data with id " + model.getAgentId() + "!", "agentRef");
        }

        return super.insert(model);
    }
}
