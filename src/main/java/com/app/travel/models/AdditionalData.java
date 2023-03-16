package com.app.travel.models;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
class AccommodationData {
    @Getter
    @Setter
    private Integer numberOfBeds;
    @Getter
    @Setter
    private Boolean petFriendly;
    @Getter
    @Setter
    private Integer accommodationRating;
    @Getter
    @Setter
    private Integer capacity;
}

@AllArgsConstructor
@NoArgsConstructor
class TransportationData{
    @Getter
    @Setter
    private String vehicleType;
    @Getter
    @Setter
    private Integer capacity;
}

@AllArgsConstructor
@NoArgsConstructor
class MealData{
    @Getter
    @Setter
    private String mealType;
    @Getter
    @Setter
    private Boolean isVegetarian;
    @Getter
    @Setter
    private Boolean isHalal;
}

@AllArgsConstructor
@NoArgsConstructor
class ExcursionData{
    @Getter
    @Setter
    private String tourGuideName;
}
