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
class MealData extends AdditionalData {
    @Getter
    @Setter
    private String meal_type;
    @Getter
    @Setter
    private Boolean is_vegetarian;
    @Getter
    @Setter
    private Boolean is_halal;

    public static MealData CastFromMap(Map<String, Object> kvp) {
        return GenericCaster.mapToType(kvp, MealData.class, new MealData());
    }

    public static AdditionalData CastFromString(String json) {
        return GenericCaster.mapToType(json, MealData.class);
    }
}
