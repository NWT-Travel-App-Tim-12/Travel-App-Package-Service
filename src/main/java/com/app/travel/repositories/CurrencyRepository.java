package com.app.travel.repositories;

import com.app.travel.models.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyRepository
        extends JpaRepository<Currency, Integer> {
}
