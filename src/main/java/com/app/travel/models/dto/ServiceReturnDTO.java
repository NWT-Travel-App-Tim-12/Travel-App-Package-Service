package com.app.travel.models.dto;

import com.app.travel.models.additinaldata.AdditionalData;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
public class ServiceReturnDTO {

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
    private Integer agentId;
    @Getter
    @Setter
    private String serviceCode;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String description;
    @Getter
    @Setter
    private LocalDate createdAt;
    @Getter
    @Setter
    private Double cost;
    @Getter
    @Setter
    private AdditionalData additionalData;
}
