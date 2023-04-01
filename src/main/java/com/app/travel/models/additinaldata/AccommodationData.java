package com.app.travel.models.additinaldata;

import com.app.travel.util.GenericCaster;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
public
class AccommodationData extends AdditionalData {
    @Getter
    @Setter
    private Integer number_of_beds;
    @Getter
    @Setter
    private Boolean pet_friendly;
    @Getter
    @Setter
    private Integer accommodation_raiting;
    @Getter
    @Setter
    private Integer capacity;

    public static AccommodationData CastFromMap(Map<String, Object> kvp) {
        return GenericCaster.mapToType(kvp, AccommodationData.class, new AccommodationData());
    }

    public static AdditionalData CastFromString(String json) {
        return GenericCaster.mapToType(json, AccommodationData.class);
    }
}
