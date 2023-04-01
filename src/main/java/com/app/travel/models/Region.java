package com.app.travel.models;

import com.app.travel.util.annotations.IgnoreOnObjectUpdate;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "regions")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Region {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Integer id;
    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "currency_id", insertable = false, updatable = false)
    @IgnoreOnObjectUpdate
    @JsonIgnore
    private Currency currencyRef;
    @Getter
    @Setter
    @Column(name = "currency_id")
    private Integer currencyId;
    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(columnDefinition = "integer", name = "super_region_id", insertable = false, updatable = false)
    @JsonIgnore
    @IgnoreOnObjectUpdate
    private Region superRegion;
    @Getter
    @Setter
    @Column(name = "super_region_id")
    private Integer superRegionId;
    @Getter
    @Setter
    @NotEmpty(message = "The region must have a defined name!")
    private String name;
    @Getter
    @Setter
    private String notes;
    @Getter
    @Setter
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JsonIgnore
    private List<Package> packages;
}
