package com.app.travel.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
@Entity
@Table(name = "packages")
@AllArgsConstructor
@NoArgsConstructor
public class Package {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    @Getter
    @Setter
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY)
    @Getter
    @Setter
    private Region regionRef;
    @Getter
    @Setter
    private Integer agentRef;
    @Getter
    @Setter
    private UUID agency;
    @Column(name = "package_code")
    @Getter
    @Setter
    private String packageCode;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String description;
    @Getter
    @Setter
    private LocalDate validFrom;
    @Getter
    @Setter
    private LocalDate validTo;
    @Getter
    @Setter
    private LocalDate createdAt;

    @ManyToMany(mappedBy = "packages", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @Getter
    @Setter
    private Set<Service> services = new HashSet<>();
}
