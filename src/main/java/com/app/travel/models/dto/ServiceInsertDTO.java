package com.app.travel.models.dto;

import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
public class ServiceInsertDTO {
    @Getter
    @Setter
    private Integer id;
    @Getter
    @Setter
    private Integer serviceTypeId;
    @Getter
    @Setter
    private Integer regionId;
    @Getter
    @Setter
    //@NotNull(message = "The service must have a defined agent reference")
    private Integer agentId;
    @Getter
    @Setter
    private String serviceCode;
    @Getter
    @Setter
    //@NotEmpty(message = "The service must have a defined name")
    private String name;
    @Getter
    @Setter
    private String description;
    @Getter
    @Setter
    private LocalDate createdAt;
    @Getter
    @Setter
    @PositiveOrZero(message = "The service cost cannot be negative")
    private Double cost;
    @Getter
    @Setter
    private Map<String, Object> additionalData;
}
