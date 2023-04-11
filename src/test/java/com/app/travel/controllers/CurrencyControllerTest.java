package com.app.travel.controllers;

import com.app.travel.models.Currency;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CurrencyControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate template;

    private final String baseUrl = "http://localhost:%d/v1/api/package-service/currency";

    @Test
    @Order(1)
    void get_checker() {
        final ResponseEntity<Currency> response = template.getForEntity(String.format(baseUrl, port) + "?id=1", Currency.class);


        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Currency body = response.getBody();
        Assertions.assertNotNull(body);
    }

    @Test
    @Order(2)
    void getAll_checker() {
        final ResponseEntity<String> response = template.getForEntity(String.format(baseUrl, port) + "/list?page=0&pageSize=2", String.class);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        String body = response.getBody();
        Assertions.assertFalse(Objects.requireNonNull(body).isBlank());
        Assertions.assertEquals("[{\"id\":1,\"name\":\"BAM\"},{\"id\":2,\"name\":\"USD\"}]", body);
    }

    @Test
    @Order(3)
    void post_checker() {
        final Currency sType = new Currency(
                5,
                "FPB"
        );

        final ResponseEntity<Currency> response = template.postForEntity(
                String.format(baseUrl, port),
                sType,
                Currency.class);

        Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
        Currency body = response.getBody();
        Assertions.assertNotNull(body);
        Assertions.assertEquals(sType.getId(), body.getId());
        Assertions.assertEquals(sType.getName(), body.getName());
    }

    @Test
    @Order(4)
    void delete_checker() {
        final Currency sType = new Currency(
                4,
                "NISTA2"
        );

        final String url = String.format(baseUrl, port) + "?id=5";

        template.delete(url, sType, Currency.class);

        final ResponseEntity<Currency> response = template.getForEntity(url, Currency.class);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

}