package com.app.travel.controllers;

import com.app.travel.models.Package;
import com.app.travel.service.PackageService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "package")
public class PackageController extends BaseController<Package, Integer, PackageService> {
    @Autowired
    public PackageController(PackageService service) {
        super(service);
    }
    @PostMapping
    public Package post(@RequestBody @Valid Package request) {
        return super.post(request);
    }

    @GetMapping
    public Package get(int id) throws Exception {
        return super.get(id);
    }

    @GetMapping(path = "/list")
    public List<Package> getAll(int page, int pageSize) throws Exception {
        return super.getAll(page, pageSize);
    }

    @PutMapping
    public Package put(Integer id, @RequestBody @Valid Package request) throws Exception {
        return super.put(id, request);
    }

    @PatchMapping
    public Package patch(Integer id, @RequestBody @Valid Package request) throws Exception {
        return super.patch(id, request);
    }

    @DeleteMapping
    public int delete(Integer id){
        return super.delete(id);
    }
}
