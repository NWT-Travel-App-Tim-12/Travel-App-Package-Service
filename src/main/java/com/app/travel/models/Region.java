package com.app.travel.models;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
@Entity
@Table(name = "regions")
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY)
    private Currency currencyRef;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(columnDefinition="integer", name = "super_region_id")
    private Region superRegion;
    private String name;
    private String notes;

    public Region(Integer id, Currency currencyRef, Region superRegion, String name, String notes) {
        this.id = id;
        this.currencyRef = currencyRef;
        this.superRegion = superRegion;
        this.name = name;
        this.notes = notes;
    }

    public Region() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Currency getCurrencyRef() {
        return currencyRef;
    }

    public void setCurrencyRef(Currency currencyRef) {
        this.currencyRef = currencyRef;
    }

    public Region getSuperRegion() {
        return superRegion;
    }

    public void setSuperRegion(Region superRegion) {
        this.superRegion = superRegion;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
