package com.app.travel.client;

import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "booking-service")
public interface BookingClient {
    @PutMapping(path = "/booking/message/{id}")
    void putBooking(@PathVariable Integer id, @RequestBody CreatedBooking booking);
}
