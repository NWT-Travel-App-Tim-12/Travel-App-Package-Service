package com.app.travel.models;

import com.app.travel.util.annotations.IgnoreOnObjectUpdate;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
@Entity
@Table(name = "packages")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Package {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Integer id;
    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "region_id", insertable = false, updatable = false)
    @IgnoreOnObjectUpdate
    @JsonIgnore
    private Region regionRef;
    @Getter
    @Setter
    @Column(name = "region_id")
    private Integer regionId;
    @Getter
    @Setter
    @NotNull(message = "The package must have a defined agent reference!")
    private Integer agentRef;
    @Getter
    @Setter
    @NotNull(message = "The package must have a defined agency!")
    private UUID agency;
    @Getter
    @Setter
    @Column(name = "package_code")
    private String packageCode;
    @Getter
    @Setter
    @NotEmpty(message = "The package must have a defined name!")
    private String name;
    @Getter
    @Setter
    private String description;
    @Getter
    @Setter
    private LocalDate validFrom;
    @Getter
    @Setter
    @Future(message = "Unable to create package that is already finished!")
    private LocalDate validTo;
    @Getter
    @Setter
    @Column(updatable = false)
    @CreationTimestamp
    private LocalDate createdAt;
    @Getter
    @Setter
    @ManyToMany(mappedBy = "packages", cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JsonIgnore
    @IgnoreOnObjectUpdate
    private List<Service> services;
}
