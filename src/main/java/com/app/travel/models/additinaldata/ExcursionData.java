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
class ExcursionData extends AdditionalData {
    @Getter
    @Setter
    private String tour_guide_name;

    public static ExcursionData CastFromMap(Map<String, String> kvp) {
        return GenericCaster.mapToType(kvp, ExcursionData.class, new ExcursionData());
    }

    public static AdditionalData CastFromString(String json) {
        return GenericCaster.mapToType(json, ExcursionData.class);
    }
}
