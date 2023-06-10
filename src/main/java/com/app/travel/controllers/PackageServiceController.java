package com.app.travel.controllers;

import com.app.travel.models.Package;
import com.app.travel.models.additinaldata.AdditionalData;
import com.app.travel.models.dto.ServiceReturnDTO;
import com.app.travel.service.PackageService;
import com.app.travel.service.ServiceService;
import com.app.travel.util.GenericCaster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping
public class PackageServiceController {

    private final PackageService packageService;
    private final ServiceService serviceService;

    @Autowired
    public PackageServiceController(PackageService packageService, ServiceService serviceService){
        this.packageService = packageService;
        this.serviceService = serviceService;
    }

    @GetMapping("/package-services")
    public ResponseEntity<List<ServiceReturnDTO>> getPackageServices(Integer id) throws Exception {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(packageService.get(id).getServices().stream().map(service -> {
            AdditionalData additionalData = GenericCaster.castToAppropriateType(service.getAdditionalData());
            return new ServiceReturnDTO(
                    service.getId(),
                    service.getServiceTypeId(),
                    service.getRegionId(),
                    service.getAgentId(),
                    service.getServiceCode(),
                    service.getName(),
                    service.getDescription(),
                    service.getCreatedAt(),
                    service.getCost(),
                    additionalData,
                    service.getImageUrl()
            );
        }).toList());
    }

    @GetMapping("/service-packages")
    public ResponseEntity<List<Package>> getServicePackages(Integer id) throws Exception {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(serviceService.get(id).getPackages());
    }

    @PostMapping("/connect")
    public ResponseEntity<HashMap<String, Integer>> insertNewConnection(Integer packageId, Integer serviceId) throws Exception {
        var packageO = packageService.get(packageId);
        var serviceO = serviceService.get(serviceId);
        packageO.getServices().add(serviceO);
        serviceO.getPackages().add(packageO);
        packageService.update(packageId, packageO);
        serviceService.update(serviceId, serviceO);
        var response = new HashMap<String, Integer>();
        response.put("package_id", packageId);
        response.put("service_id", serviceId);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
