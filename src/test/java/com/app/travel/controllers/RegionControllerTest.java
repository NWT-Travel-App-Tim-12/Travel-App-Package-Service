package com.app.travel.controllers;

import com.app.travel.models.Region;
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
class RegionControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate template;

    private final String baseUrl = "http://localhost:%d/v1/api/package-service/region";

    @Test
    @Order(1)
    void get_checker() {
        final ResponseEntity<Region> response = template.getForEntity(String.format(baseUrl, port) + "?id=1", Region.class);


        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Region body = response.getBody();
        Assertions.assertNotNull(body);
    }

    @Test
    @Order(2)
    void getAll_checker() {
        final ResponseEntity<String> response = template.getForEntity(String.format(baseUrl, port) + "/list?page=0&pageSize=2", String.class);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        String body = response.getBody();
        Assertions.assertFalse(Objects.requireNonNull(body).isBlank());
        Assertions.assertEquals("[{\"id\":1,\"currencyId\":1,\"superRegionId\":null,\"name\":\"Bosnia\",\"notes\":\"Urban region\"},{\"id\":2,\"currencyId\":1,\"superRegionId\":1,\"name\":\"Kakanj\",\"notes\":\"Mountains\"}]", body);
    }

    @Test
    @Order(3)
    void post_checker() {
        final Region sType = new Region(
                5,
                null,
                1,
                null,
                null,
                "bf",
                "",
                null
        );

        final ResponseEntity<Region> response = template.postForEntity(
                String.format(baseUrl, port),
                sType,
                Region.class);

        Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
        Region body = response.getBody();
        Assertions.assertNotNull(body);
        Assertions.assertEquals(sType.getId(), body.getId());
        Assertions.assertEquals(sType.getName(), body.getName());
    }

    @Test
    @Order(4)
    void delete_checker() {
        final Region sType = new Region(
                5,
                null,
                1,
                null,
                null,
                "bf",
                "",
                null
        );

        final String url = String.format(baseUrl, port) + "?id=5";

        template.delete(url, sType, Region.class);

        final ResponseEntity<Region> response = template.getForEntity(url, Region.class);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}