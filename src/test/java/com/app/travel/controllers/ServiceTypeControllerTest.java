package com.app.travel.controllers;

import com.app.travel.models.ServiceType;
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
class ServiceTypeControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate template;

    private final String baseUrl = "http://localhost:%d/v1/api/package-service/service-type";

    @Test
    @Order(1)
    void get_checker() {
        final ResponseEntity<ServiceType> response = template.getForEntity(String.format(baseUrl, port) + "?id=1", ServiceType.class);


        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        ServiceType body = response.getBody();
        Assertions.assertNotNull(body);
    }

    @Test
    @Order(2)
    void getAll_checker() {
        final ResponseEntity<String> response = template.getForEntity(String.format(baseUrl, port) + "/list?page=0&pageSize=2", String.class);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        String body = response.getBody();
        Assertions.assertFalse(Objects.requireNonNull(body).isBlank());
        Assertions.assertEquals("[{\"id\":1,\"name\":\"ACCOMMODATION\"},{\"id\":2,\"name\":\"MEAL\"}]", body);
    }

    @Test
    @Order(3)
    void post_checker() {
        final ServiceType sType = new ServiceType(
                5,
                "MEHO",
                null
        );

        final ResponseEntity<ServiceType> response = template.postForEntity(
                String.format(baseUrl, port),
                sType,
                ServiceType.class);

        Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
        ServiceType body = response.getBody();
        Assertions.assertNotNull(body);
        Assertions.assertEquals(sType.getId(), body.getId());
        Assertions.assertEquals(sType.getName(), body.getName());
    }

    @Test
    @Order(4)
    void delete_checker() {
        final ServiceType sType = new ServiceType(
                5,
                "NISTA2",
                null
        );

        final String url = String.format(baseUrl, port) + "?id=5";

        template.delete(url, sType, ServiceType.class);

        final ResponseEntity<ServiceType> response = template.getForEntity(url, ServiceType.class);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}