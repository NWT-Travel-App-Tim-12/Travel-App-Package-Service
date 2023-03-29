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
class TransportationData extends AdditionalData {
    @Getter
    @Setter
    private String vehicle_type;
    @Getter
    @Setter
    private Integer capacity;

    public static TransportationData CastFromMap(Map<String, String> kvp) {
        return GenericCaster.mapToType(kvp, TransportationData.class, new TransportationData());
    }

    public static AdditionalData CastFromString(String json) {
        return GenericCaster.mapToType(json, TransportationData.class);
    }

}
