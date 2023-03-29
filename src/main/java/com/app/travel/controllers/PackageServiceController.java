package com.app.travel.controllers;

import com.app.travel.models.Package;
import com.app.travel.models.additinaldata.AdditionalData;
import com.app.travel.models.dto.ServiceReturnDTO;
import com.app.travel.service.PackageService;
import com.app.travel.service.ServiceService;
import com.app.travel.util.GenericCaster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public List<ServiceReturnDTO> getPackageServices(Integer id) throws Exception {
        return packageService.get(id).getServices().stream().map(service -> {
            AdditionalData additionalData = GenericCaster.castToAppropriateType(service.getAdditionalData());
            return new ServiceReturnDTO(
                    service.getId(),
                    service.getServiceTypeRef(),
                    service.getRegionRef(),
                    service.getAgentRef(),
                    service.getServiceCode(),
                    service.getName(),
                    service.getDescription(),
                    service.getCreatedAt(),
                    service.getCost(),
                    additionalData
            );
        }).toList();
    }

    @GetMapping("/service-packages")
    public List<Package> getServicePackages(Integer id) throws Exception {
        return serviceService.get(id).getPackages();
    }

    @PostMapping("/connect")
    public int insertNewConnection(Integer packageId, Integer serviceId) throws Exception {
        var packageO = packageService.get(packageId);
        var serviceO = serviceService.get(serviceId);
        packageO.getServices().add(serviceO);
        serviceO.getPackages().add(packageO);
        packageService.update(packageId, packageO);
        serviceService.update(serviceId, serviceO);
        return 1;
    }
}
