package com.app.travel.controllers;

import com.app.travel.models.Package;
import com.app.travel.service.PackageService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Package> post(@RequestBody @Valid Package request) {
        return super.post(request);
    }

    @GetMapping
    public ResponseEntity<Package> get(int id) throws Exception {
        return super.get(id);
    }

    @GetMapping(path = "/list")
    public ResponseEntity<List<Package>> getAll(int page, int pageSize) throws Exception {
        return super.getAll(page, pageSize);
    }

    @PutMapping
    public ResponseEntity<Package> put(Integer id, @RequestBody @Valid Package request) throws Exception {
        return super.put(id, request);
    }

    @PatchMapping
    public ResponseEntity<Package> patch(Integer id, @RequestBody @Valid Package request) throws Exception {
        return super.patch(id, request);
    }

    @DeleteMapping
    public ResponseEntity<Integer> delete(Integer id){
        return super.delete(id);
    }
}
