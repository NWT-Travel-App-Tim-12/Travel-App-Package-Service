package com.app.travel.controllers;

import com.app.travel.models.Region;
import com.app.travel.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "region")
public class RegionController extends BaseController<Region, Integer, RegionService>{
    @Autowired
    public RegionController(RegionService service) {
        super(service);
    }

    @GetMapping("/super-region")
    public Region getRegionsSuperRegion(Integer id) throws Exception {
        return service.getRegionsSuperRegion(id);
    }
}
