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
import java.util.UUID;
@Entity
@Table(name = "packages")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Package {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    @Getter
    @Setter
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
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
    @JsonIgnore
    private List<Service> services;
}
