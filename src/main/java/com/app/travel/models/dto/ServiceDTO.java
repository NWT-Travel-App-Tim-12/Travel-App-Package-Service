package com.app.travel.models.dto;

import com.app.travel.models.Package;
import com.app.travel.models.Region;
import com.app.travel.models.ServiceType;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
public class ServiceDTO {
    @Getter
    @Setter
    private ServiceType serviceTypeRef;
    @Getter
    @Setter
    private Region regionRef;
    @Getter
    @Setter
    @NotNull(message = "The service must have a defined agent reference")
    private Integer agentRef;
    @Getter
    @Setter
    private String serviceCode;
    @Getter
    @Setter
    @NotEmpty(message = "The service must have a defined name")
    private String name;
    @Getter
    @Setter
    private String description;
    @Getter
    @Setter
    @PositiveOrZero(message = "The service cost cannot be negative")
    private Double cost;
    @Getter
    @Setter
    private List<Package> packages;
    @Getter
    @Setter
    private Map<String, String> additionalData;
}
