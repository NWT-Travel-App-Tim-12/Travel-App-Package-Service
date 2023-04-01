package com.app.travel.util;

import com.app.travel.models.additinaldata.*;
import com.app.travel.util.exceptions.InvalidAdditionalDataCast;
import com.google.gson.Gson;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class GenericCaster {
    private static String camelToSnakeCase(String camelCaseString) {
        StringBuilder snakeCaseBuilder = new StringBuilder();
        for (int i = 0; i < camelCaseString.length(); i++) {
            char c = camelCaseString.charAt(i);
            if (Character.isUpperCase(c)) {
                snakeCaseBuilder.append("_");
                snakeCaseBuilder.append(Character.toLowerCase(c));
            } else {
                snakeCaseBuilder.append(c);
            }
        }
        return snakeCaseBuilder.toString();
    }
    public static <T> T mapToType(Map<String, Object> kvp, Class<T> objectClass, T newObject) {
        try {
            for (Field field : objectClass.getDeclaredFields()) {
                field.setAccessible(true);
                String name = GenericCaster.camelToSnakeCase(field.getName());
                var value = kvp.get(name);
                if (value == null) {
                    return null;
                }
                field.set(newObject, value);
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return newObject;
    }

    public static <T> T mapToType(String json, Class<T> objectClass){
        Gson gson = new Gson();
        return gson.fromJson(json, objectClass);
    }

    public static AdditionalData castToAppropriateType(Map<String, Object> kvp) {
        if(kvp == null) return null;

        var list = List.of((Function<Map<String, Object>, AdditionalData>) AccommodationData::CastFromMap, MealData::CastFromMap, TransportationData::CastFromMap, ExcursionData::CastFromMap);

        for (var caster : list) {
            var obj = caster.apply(kvp);
            if (obj != null) return obj;
        }
        throw new InvalidAdditionalDataCast("Additional data field is not in a valid format");
    }

    public static AdditionalData castToAppropriateType(String json){
        if(json == null || json.isBlank()) return null;

        var list = List.of((Function<String, AdditionalData>) AccommodationData::CastFromString, MealData::CastFromString, TransportationData::CastFromString, ExcursionData::CastFromString);

        for (var caster : list) {
            var obj = caster.apply(json);
            var fields = obj.getClass().getDeclaredFields();
            boolean invalidCast = false;
            for (var f : fields){
                try{
                    f.setAccessible(true);
                    var v = f.get(obj);
                    if(v == null) {
                        invalidCast = true;
                        break;
                    }
                }catch (IllegalAccessException ignored){

                }
            }
            if (!invalidCast) return obj;
        }
        throw new InvalidAdditionalDataCast("Additional data field is not in a valid format");
    }
}
