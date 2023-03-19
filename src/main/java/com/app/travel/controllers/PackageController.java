package com.app.travel.controllers;

import com.app.travel.models.Package;
import com.app.travel.service.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "package")
public class PackageController extends BaseController<Package, Integer, PackageService> {
    @Autowired
    public PackageController(PackageService service) {
        super(service);
    }
}
