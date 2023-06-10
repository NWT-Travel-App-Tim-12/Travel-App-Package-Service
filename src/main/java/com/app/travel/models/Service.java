package com.app.travel.models;

import com.app.travel.util.annotations.IgnoreOnObjectUpdate;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "services")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Data
public class Service {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Integer id;
    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "service_type_id", insertable = false, updatable = false)
    @IgnoreOnObjectUpdate
    @JsonIgnore
    private ServiceType serviceTypeRef;
    @Getter
    @Setter
    @Column(name = "service_type_id")
    private Integer serviceTypeId;
    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "region_id", insertable = false, updatable = false)
    @IgnoreOnObjectUpdate
    @JsonBackReference
    private Region regionRef;
    @Getter
    @Setter
    @Column(name = "region_id")
    private Integer regionId;
    @Getter
    @Setter
    private Integer agentId;
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
    @Column(updatable = false)
    @CreationTimestamp
    private LocalDate createdAt;
    @Getter
    @Setter
    private Double cost;
    @Getter
    @Setter
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(
            name = "package_services",
            joinColumns = {@JoinColumn(name = "service_id")},
            inverseJoinColumns = {@JoinColumn(name = "package_id")}
    )
    @JsonIgnore
    @IgnoreOnObjectUpdate
    private List<Package> packages;
    @Getter
    @Setter
    @Column(columnDefinition="TEXT")
    private String additionalData;

    private String imageUrl;
}
