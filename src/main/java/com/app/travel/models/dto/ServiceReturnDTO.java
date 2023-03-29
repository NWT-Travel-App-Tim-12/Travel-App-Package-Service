package com.app.travel.models.dto;

import com.app.travel.models.Package;
import com.app.travel.models.Region;
import com.app.travel.models.ServiceType;
import com.app.travel.models.additinaldata.AdditionalData;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
public class ServiceReturnDTO {

    @Getter
    @Setter
    private Integer id;
    @Getter
    @Setter
    private ServiceType serviceTypeRef;
    @Getter
    @Setter
    private Region regionRef;
    @Getter
    @Setter
    private Integer agentRef;
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
