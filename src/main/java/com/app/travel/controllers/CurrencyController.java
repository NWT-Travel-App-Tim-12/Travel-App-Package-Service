package com.app.travel.controllers;

import com.app.travel.models.Currency;
import com.app.travel.service.CurrencyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "currency")
public class CurrencyController extends BaseController<Currency, Integer, CurrencyService> {
    @Autowired
    public CurrencyController(CurrencyService currencyService) {
        super(currencyService);
    }

    @GetMapping
    public ResponseEntity<Currency> get(int id) throws Exception {
        return super.get(id);
    }

    @GetMapping(path = "/list")
    public ResponseEntity<List<Currency>> getAll(int page, int pageSize) throws Exception {
        return super.getAll(page, pageSize);
    }

    @PostMapping
    public ResponseEntity<Currency> post(@RequestBody @Valid Currency request) throws Exception {
        return super.post(request);
    }

    @PutMapping
    public ResponseEntity<Currency> put(Integer id, @RequestBody @Valid Currency request) throws Exception {
        return super.put(id, request);
    }

    @PatchMapping
    public ResponseEntity<Currency> patch(Integer id, @RequestBody @Valid Currency request) throws Exception {
        return super.patch(id, request);
    }

    @DeleteMapping
    public ResponseEntity<Integer> delete(Integer id) {
        return super.delete(id);
    }

}
