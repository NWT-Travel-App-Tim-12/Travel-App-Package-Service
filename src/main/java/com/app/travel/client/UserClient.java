package com.app.travel.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-service")
public interface UserClient {

    @GetMapping(path = "/users/{id}")
    public UserClientModel getUser(@PathVariable Integer id);

}
