package com.app.travel.models.dto;

import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookingProducerDto {
    private Integer bookingId;

    private BookingCreationDto bookingComponents;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
