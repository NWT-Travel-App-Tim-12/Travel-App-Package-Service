package com.app.travel.controllers;

import com.app.travel.models.Package;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PackageControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate template;

    private final String baseUrl = "http://localhost:%d/v1/api/package-service/package";

    @Test
    @Order(1)
    void get_checker() {
        final ResponseEntity<Package> response = template.getForEntity(String.format(baseUrl, port) + "?id=1", Package.class);


        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Package body = response.getBody();
        Assertions.assertNotNull(body);
    }

    @Test
    @Order(2)
    void getAll_checker() {
        final ResponseEntity<String> response = template.getForEntity(String.format(baseUrl, port) + "/list?page=0&pageSize=2", String.class);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        String body = response.getBody();
        Assertions.assertFalse(Objects.requireNonNull(body).isBlank());
        Assertions.assertEquals("[{\"id\":1,\"regionId\":3,\"agentRef\":1,\"agency\":\"64da5ad1-b828-4987-86af-c4d38ec21a33\",\"packageCode\":\"PT123\",\"name\":\"Paris travel\",\"description\":\"Travel to Paris\",\"validFrom\":\"2023-03-03\",\"validTo\":\"2023-12-03\",\"createdAt\":\"2023-04-12\"},{\"id\":2,\"regionId\":1,\"agentRef\":1,\"agency\":\"35307f4e-4dc7-4493-bdf4-2d1a9b115fd7\",\"packageCode\":\"KT123\",\"name\":\"Kakanj travel\",\"description\":\"Travel to Kakanj\",\"validFrom\":\"2023-03-03\",\"validTo\":\"2023-12-03\",\"createdAt\":\"2023-04-12\"}]", body);
    }

    @Test
    @Order(3)
    void post_checker() {
        final Package sType = new Package(
                3,
                null,
                1,
                1,
                UUID.randomUUID(),
                "code",
                "travel",
                "description",
                LocalDate.now().plusDays(100),
                LocalDate.now().plusDays(10),
                LocalDate.now(),
                null,
                ""
        );

        final ResponseEntity<Package> response = template.postForEntity(
                String.format(baseUrl, port),
                sType,
                Package.class);

        Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
        Package body = response.getBody();
        Assertions.assertNotNull(body);
        Assertions.assertEquals(sType.getId(), body.getId());
        Assertions.assertEquals(sType.getName(), body.getName());
    }

    @Test
    @Order(4)
    void delete_checker() {
        final Package sType = new Package(
                3,
                null,
                1,
                1,
                UUID.randomUUID(),
                "code",
                "travel",
                "description",
                LocalDate.MAX,
                LocalDate.MIN,
                LocalDate.now(),
                null,
                ""
        );

        final String url = String.format(baseUrl, port) + "?id=5";

        template.delete(url, sType, Package.class);

        final ResponseEntity<Package> response = template.getForEntity(url, Package.class);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}