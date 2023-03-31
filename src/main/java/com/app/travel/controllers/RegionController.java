package com.app.travel.controllers;

import com.app.travel.models.Package;
import com.app.travel.models.Region;
import com.app.travel.service.RegionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "region")
public class RegionController extends BaseController<Region, Integer, RegionService>{
    @Autowired
    public RegionController(RegionService service) {
        super(service);
    }

    @GetMapping("/super-region")
    public ResponseEntity<Region> getRegionsSuperRegion(Integer id) throws Exception {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.getRegionsSuperRegion(id));
    }

    @GetMapping
    public ResponseEntity<Region> get(int id) throws Exception {
        return super.get(id);
    }

    @GetMapping(path = "/list")
    public ResponseEntity<List<Region>> getAll(int page, int pageSize) throws Exception {
        return super.getAll(page, pageSize);
    }

    @PostMapping
    public ResponseEntity<Region> post(@RequestBody @Valid Region request) {
        return super.post(request);
    }

    @PutMapping
    public ResponseEntity<Region> put(Integer id, @RequestBody @Valid Region request) throws Exception {
        return super.put(id, request);
    }

    @PatchMapping
    public ResponseEntity<Region> patch(Integer id, @RequestBody @Valid Region request) throws Exception {
        return super.patch(id, request);
    }

    @DeleteMapping
    public ResponseEntity<Integer> delete(Integer id){
        return super.delete(id);
    }
}
