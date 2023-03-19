package com.app.travel.repositories;

import com.app.travel.models.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository
        extends JpaRepository<Service, Integer> {
}
