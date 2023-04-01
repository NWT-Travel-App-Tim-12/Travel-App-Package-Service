package com.app.travel.service;

import com.app.travel.models.Service;
import com.app.travel.models.additinaldata.AdditionalData;
import com.app.travel.models.dto.ServiceInsertDTO;
import com.app.travel.models.dto.ServiceReturnDTO;
import com.app.travel.repositories.ServiceRepository;
import com.app.travel.util.GenericCaster;

import java.time.LocalDate;
import java.util.List;

@org.springframework.stereotype.Service
public class ServiceService extends BaseCrudService<Service, Integer> {
    public ServiceService(ServiceRepository repository) {
        super(repository);
    }

    public Service insert(ServiceInsertDTO model) {
        AdditionalData data = GenericCaster.castToAppropriateType(model.getAdditionalData());
        var newService = new Service(
                null,
                null,
                model.getServiceTypeId(),
                null,
                model.getRegionId(),
                model.getAgentRef(),
                model.getServiceCode(),
                model.getName(),
                model.getDescription(),
                LocalDate.now(),
                model.getCost(),
                null,
                data.toJson()
        );
        repository.save(newService);

        return newService;
    }

    public ServiceReturnDTO getDto(Integer id) throws Exception {
        return castToReturnObject(super.get(id));
    }

    private ServiceReturnDTO castToReturnObject(Service service) {
        AdditionalData additionalData = GenericCaster.castToAppropriateType(service.getAdditionalData());
        return new ServiceReturnDTO(
                service.getId(),
                service.getServiceTypeId(),
                service.getRegionId(),
                service.getAgentRef(),
                service.getServiceCode(),
                service.getName(),
                service.getDescription(),
                service.getCreatedAt(),
                service.getCost(),
                additionalData
        );
    }

    public List<ServiceReturnDTO> getAllDto(int page, int pageSize) {
        var serviceList = super.getAll(page, pageSize);
        return serviceList.stream().map(this::castToReturnObject).toList();
    }

    public ServiceReturnDTO update(Integer id, ServiceInsertDTO model) throws Exception {
        AdditionalData data = GenericCaster.castToAppropriateType(model.getAdditionalData());
        return castToReturnObject(
                super.update(id, new Service(
                        id,
                        null,
                        model.getServiceTypeId(),
                        null,
                        model.getRegionId(),
                        model.getAgentRef(),
                        model.getServiceCode(),
                        model.getName(),
                        model.getDescription(),
                        LocalDate.now(),
                        model.getCost(),
                        null,
                        data.toJson()
                )));
    }

    public ServiceReturnDTO patch(Integer id, ServiceInsertDTO model) throws Exception {
        AdditionalData data = GenericCaster.castToAppropriateType(model.getAdditionalData());
        return castToReturnObject(
                super.patch(id, new Service(
                        id,
                        null,
                        model.getServiceTypeId(),
                        null,
                        model.getRegionId(),
                        model.getAgentRef(),
                        model.getServiceCode(),
                        model.getName(),
                        model.getDescription(),
                        LocalDate.now(),
                        model.getCost(),
                        null,
                        data == null ? null : data.toJson()
                )));
    }
}
