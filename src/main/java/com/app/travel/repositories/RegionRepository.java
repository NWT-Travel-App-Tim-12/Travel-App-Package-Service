package com.app.travel.repositories;

import com.app.travel.models.Region;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionRepository
        extends JpaRepository<Region, Integer> {
}
