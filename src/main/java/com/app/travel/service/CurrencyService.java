package com.app.travel.service;

import com.app.travel.models.Currency;
import com.app.travel.repositories.CurrencyRepository;
import org.springframework.stereotype.Service;

@Service
public class CurrencyService extends BaseCrudService<Currency, Integer> {
    public CurrencyService(CurrencyRepository repository) {
        super(repository);
    }
}
