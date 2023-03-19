package com.app.travel.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "services")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    @Getter
    @Setter
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @Getter
    @Setter
    private ServiceType serviceTypeRef;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
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
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "package_services",
            joinColumns = {@JoinColumn(name = "service_id")},
            inverseJoinColumns = {@JoinColumn(name = "package_id")}
    )
    @Getter
    @Setter
    @JsonIgnore
    private List<Package> packages;
    @Column(columnDefinition = "jsonb")
    @Getter
    @Setter
    private Object additionalData;
}
