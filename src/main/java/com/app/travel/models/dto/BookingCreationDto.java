package com.app.travel.models.dto;

import lombok.Data;

import java.util.List;

@Data
public class BookingCreationDto {
    private Integer packageId;

    private List<Integer> serviceIds;



}
