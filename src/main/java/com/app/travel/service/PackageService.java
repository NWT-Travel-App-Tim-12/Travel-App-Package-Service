package com.app.travel.service;

import com.app.travel.models.Package;
import com.app.travel.repositories.PackageRepository;
import org.springframework.stereotype.Service;

@Service
public class PackageService extends BaseCrudService<Package, Integer>{
    public PackageService(PackageRepository repository) {
        super(repository);
    }
}
