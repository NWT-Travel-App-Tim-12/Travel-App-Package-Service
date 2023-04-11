package com.app.travel.controllers;

import com.app.travel.models.Service;
import com.app.travel.models.additinaldata.ExcursionData;
import com.app.travel.models.dto.ServiceInsertDTO;
import com.app.travel.models.dto.ServiceReturnDTO;
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
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ServiceControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate template;

    private final String baseUrl = "http://localhost:%d/v1/api/package-service/service";



    @Test
    @Order(2)
    void getAll_checker() {
        final ResponseEntity<String> response = template.getForEntity(String.format(baseUrl, port) + "/list?page=0&pageSize=2", String.class);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        String body = response.getBody();
        Assertions.assertFalse(Objects.requireNonNull(body).isBlank());
        Assertions.assertEquals("[{\"id\":1,\"serviceTypeId\":4,\"regionId\":3,\"agentRef\":1,\"serviceCode\":\"LV_visit\",\"name\":\"lovre visit\",\"description\":\"visit to lovre\",\"createdAt\":\"2023-04-12\",\"cost\":255.0,\"additionalData\":{\"tour_guide_name\":\"meho\"}},{\"id\":2,\"serviceTypeId\":1,\"regionId\":1,\"agentRef\":2,\"serviceCode\":\"H_123\",\"name\":\"hotel\",\"description\":\"room in grand hotel\",\"createdAt\":\"2023-04-12\",\"cost\":555.0,\"additionalData\":{\"number_of_beds\":2,\"pet_friendly\":false,\"accommodation_raiting\":5,\"capacity\":2}}]", body);
    }

    @Test
    @Order(3)
    void post_checker() {
        var map = new HashMap<String, Object>();
        map.put("tour_guide_name", "mego");
        final ServiceInsertDTO sType = new ServiceInsertDTO(
                5,
                1,
                1,
                123,
                "code",
                "name",
                "desc",
                LocalDate.now(),
                225.,
                map
        );

        final ResponseEntity<Service> response = template.postForEntity(
                String.format(baseUrl, port),
                sType,
                Service.class);

        Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
        Service body = response.getBody();
        Assertions.assertNotNull(body);
        Assertions.assertEquals(sType.getId(), body.getId());
        Assertions.assertEquals(sType.getName(), body.getName());
    }

    @Test
    @Order(4)
    void delete_checker() {
        final Service sType = new Service(
                5,
                null,
                1,
                null,
                1,
                123,
                "code",
                "name",
                "desc",
                LocalDate.now(),
                225.,
                null,
                "{\"tour_guide_name\": \"meho\"}"
        );

        final String url = String.format(baseUrl, port) + "?id=5";

        template.delete(url, sType, Service.class);

        final ResponseEntity<Service> response = template.getForEntity(url, Service.class);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}