package com.app.travel.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
@Entity
@Table(name = "packages")
public class Package {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY)
    private Region regionRef;
    private Integer agentRef;
    private UUID agency;
    @Column(name = "package_code")
    private String packageCode;
    private String name;
    private String description;
    private LocalDate validFrom;
    private LocalDate validTo;
    private LocalDate createdAt;

    @ManyToMany(mappedBy = "packages", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private Set<Service> services = new HashSet<>();

    public Package(Integer id, Region regionRef, Integer agentRef, UUID agency, String packageCode, String name, String description, LocalDate validFrom, LocalDate validTo, LocalDate createdAt, Set<Service> services) {
        this.id = id;
        this.regionRef = regionRef;
        this.agentRef = agentRef;
        this.agency = agency;
        this.packageCode = packageCode;
        this.name = name;
        this.description = description;
        this.validFrom = validFrom;
        this.validTo = validTo;
        this.createdAt = createdAt;
        this.services = services;
    }

    public Package() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Region getRegionRef() {
        return regionRef;
    }

    public void setRegionRef(Region regionRef) {
        this.regionRef = regionRef;
    }

    public Integer getAgentRef() {
        return agentRef;
    }

    public void setAgentRef(Integer agentRef) {
        this.agentRef = agentRef;
    }

    public UUID getAgency() {
        return agency;
    }

    public void setAgency(UUID agency) {
        this.agency = agency;
    }

    public String getPackageCode() {
        return packageCode;
    }

    public void setPackageCode(String packageCode) {
        this.packageCode = packageCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(LocalDate validFrom) {
        this.validFrom = validFrom;
    }

    public LocalDate getValidTo() {
        return validTo;
    }

    public void setValidTo(LocalDate validTo) {
        this.validTo = validTo;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public Set<Service> getServices() {
        return services;
    }

    public void setServices(Set<Service> services) {
        this.services = services;
    }
}
