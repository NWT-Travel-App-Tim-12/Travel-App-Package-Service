package com.app.travel.service;

import com.app.travel.models.Service;
import com.app.travel.models.additinaldata.AdditionalData;
import com.app.travel.models.dto.ServiceDTO;
import com.app.travel.models.dto.ServiceReturnDTO;
import com.app.travel.repositories.ServiceRepository;
import com.app.travel.util.GenericCaster;

import java.time.LocalDate;
import java.util.List;

@org.springframework.stereotype.Service
public class ServiceService extends BaseCrudService<Service, Integer>{
    public ServiceService(ServiceRepository repository) {
        super(repository);
    }

    public ServiceDTO insert(ServiceDTO model) {
        AdditionalData data = GenericCaster.castToAppropriateType(model.getAdditionalData());
        assert data != null;
        var newService = new Service(
                null,
                model.getServiceTypeRef(),
                model.getRegionRef(),
                model.getAgentRef(),
                model.getServiceCode(),
                model.getName(),
                model.getDescription(),
                LocalDate.now(),
                model.getCost(),
                model.getPackages(),
                data.toJson()
        );
        repository.save(newService);

        return model;
    }

    public ServiceReturnDTO getDto(Integer id) throws Exception {
        var service = super.get(id);
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
    }

    public List<ServiceReturnDTO> getAllDto(int page, int pageSize){
        var serviceList = super.getAll(page, pageSize);
        return serviceList.stream().map(service -> {
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
}
