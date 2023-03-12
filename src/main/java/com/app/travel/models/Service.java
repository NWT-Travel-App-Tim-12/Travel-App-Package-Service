package com.app.travel.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "services")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY)
    private ServiceType serviceTypeRef;
    @ManyToOne(fetch = FetchType.LAZY)
    private Region regionRef;
    private Integer agentRef;
    private String serviceCode;
    private String name;
    private String description;
    private LocalDate createdAt;
    private Double cost;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "package_services",
            joinColumns = {@JoinColumn(name = "service_id")},
            inverseJoinColumns = {@JoinColumn(name = "package_id")}
    )
    private Set<Package> packages = new HashSet<>();
    @Column(columnDefinition = "jsonb")
    private Object additionalData;

    public Service(Integer id, ServiceType serviceTypeRef, Region regionRef, Integer agentRef, String serviceCode, String name, String description, LocalDate createdAt, Double cost, Set<Package> packages, Object additionalData) {
        this.id = id;
        this.serviceTypeRef = serviceTypeRef;
        this.regionRef = regionRef;
        this.agentRef = agentRef;
        this.serviceCode = serviceCode;
        this.name = name;
        this.description = description;
        this.createdAt = createdAt;
        this.cost = cost;
        this.packages = packages;
        this.additionalData = additionalData;
    }

    public Service() {
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ServiceType getServiceTypeRef() {
        return serviceTypeRef;
    }

    public void setServiceTypeRef(ServiceType serviceTypeRef) {
        this.serviceTypeRef = serviceTypeRef;
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

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
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

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public Set<Package> getPackages() {
        return packages;
    }

    public void setPackages(Set<Package> packages) {
        this.packages = packages;
    }

    public Object getAdditionalData() {
        return additionalData;
    }

    public void setAdditionalData(Object additionalData) {
        this.additionalData = additionalData;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }
}
