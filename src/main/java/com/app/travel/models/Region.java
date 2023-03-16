package com.app.travel.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "regions")
@AllArgsConstructor
@NoArgsConstructor
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    @Getter
    @Setter
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY)
    @Getter
    @Setter
    private Currency currencyRef;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(columnDefinition="integer", name = "super_region_id")
    @Getter
    @Setter
    private Region superRegion;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String notes;
}
