package com.app.travel.client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatedItineraries {
    private Integer id;

    private Integer serviceRef;

    private Integer day;

    private Integer capacity;

    private String regionNote;

    private String name;

    private String description;

    private String serviceType;

    private String additionalDetails;
    private String imageUrl;
}
