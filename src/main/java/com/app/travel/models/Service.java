package com.app.travel.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "services")
@AllArgsConstructor
@NoArgsConstructor
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    @Getter
    @Setter
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY)
    @Getter
    @Setter
    private ServiceType serviceTypeRef;
    @ManyToOne(fetch = FetchType.LAZY)
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
    private Set<Package> packages = new HashSet<>();
    @Column(columnDefinition = "jsonb")
    @Getter
    @Setter
    private Object additionalData;
}
