package com.app.travel.repositories;

import com.app.travel.models.Package;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PackageRepository
        extends JpaRepository<Package, Integer> {
}
