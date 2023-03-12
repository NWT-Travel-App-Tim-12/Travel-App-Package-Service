package com.app.travel.models;

class AccommodationData {
    private Integer numberOfBeds;
    private Boolean petFriendly;
    private Integer accommodationRating;
    private Integer capacity;

    public AccommodationData(Integer numberOfBeds, Boolean petFriendly, Integer accommodationRating, Integer capacity) {
        this.numberOfBeds = numberOfBeds;
        this.petFriendly = petFriendly;
        this.accommodationRating = accommodationRating;
        this.capacity = capacity;
    }

    public AccommodationData() {
    }

    public Integer getNumberOfBeds() {
        return numberOfBeds;
    }

    public void setNumberOfBeds(Integer numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

    public Boolean getPetFriendly() {
        return petFriendly;
    }

    public void setPetFriendly(Boolean petFriendly) {
        this.petFriendly = petFriendly;
    }

    public Integer getAccommodationRating() {
        return accommodationRating;
    }

    public void setAccommodationRating(Integer accommodationRating) {
        this.accommodationRating = accommodationRating;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
}

class TransportationData{
    private String vehicleType;
    private Integer capacity;

    public TransportationData(String vehicleType, Integer capacity) {
        this.vehicleType = vehicleType;
        this.capacity = capacity;
    }

    public TransportationData() {
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
}

class MealData{
    private String mealType;
    private Boolean isVegetarian;
    private Boolean isHalal;

    public MealData(String mealType, Boolean isVegetarian, Boolean isHalal) {
        this.mealType = mealType;
        this.isVegetarian = isVegetarian;
        this.isHalal = isHalal;
    }

    public MealData() {
    }

    public String getMealType() {
        return mealType;
    }

    public void setMealType(String mealType) {
        this.mealType = mealType;
    }

    public Boolean getVegetarian() {
        return isVegetarian;
    }

    public void setVegetarian(Boolean vegetarian) {
        isVegetarian = vegetarian;
    }

    public Boolean getHalal() {
        return isHalal;
    }

    public void setHalal(Boolean halal) {
        isHalal = halal;
    }
}

class ExcursionData{
    private String tourGuideName;
}
