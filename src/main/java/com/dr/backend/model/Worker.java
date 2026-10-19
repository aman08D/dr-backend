package com.dr.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="workers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;                // e.g. "Ramesh Kumar"

    @Column(nullable = false)
    private String skill;               // e.g. "ELECTRICIAN", "PLUMBER", "CARPENTER", "PAINTER"

    private Double experienceYears;     // e.g. 5

    @Column(nullable = false)
    private String phoneNumber;        // Contact Number

    @Column(nullable = false)
    private String district;           // e.g. "Patna", "Gaya", "Muzaffarpur"

    private String cityOrArea;         // e.g. "Kankarbagh"

    private Double dailyRate;          // e.g. 600.00 per day

    private Double hourlyRate;         // e.g. 100.00 per hour

    private String profileImgUrl;      // Photo URL

    private Double rating;             // e.g. 4.5 (Out of 5)

    private Boolean isAvailable;       // Available for work (true/false)



}
