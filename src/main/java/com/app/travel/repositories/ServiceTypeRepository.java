package com.app.travel.repositories;

import com.app.travel.models.ServiceType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceTypeRepository
        extends JpaRepository<ServiceType, Integer> {
}
