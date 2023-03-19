package com.app.travel.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "regions")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    @Getter
    @Setter
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @Getter
    @Setter
    private Currency currencyRef;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(columnDefinition="integer", name = "super_region_id")
    @Getter
    @Setter
    @JsonIgnore
    private Region superRegion;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String notes;
}
