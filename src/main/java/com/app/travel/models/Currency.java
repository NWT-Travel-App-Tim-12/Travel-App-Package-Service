package com.app.travel.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "currencies")
@AllArgsConstructor
@NoArgsConstructor
public class Currency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    @Getter
    @Setter
    private Integer id;
    @Getter
    @Setter
    private String name;
}
