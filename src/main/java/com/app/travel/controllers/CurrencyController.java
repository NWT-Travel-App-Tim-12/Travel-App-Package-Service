package com.app.travel.controllers;

import com.app.travel.models.Currency;
import com.app.travel.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "currency")
public class CurrencyController extends BaseController<Currency, Integer, CurrencyService> {
    @Autowired
    public CurrencyController(CurrencyService currencyService){
        super(currencyService);
    }


}
