package com.dr.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "doctors")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;                // e.g. "Dr. A. K. Sharma"

    @Column(nullable = false)
    private String specialization;     // e.g. "DENTIST", "CARDIOLOGIST", "PEDIATRICIAN"

    private String qualification;      // e.g. "MBBS, MD (AIIMS)"

    private String clinicName;         // e.g. "Sharma Dental Care"

    @Column(nullable = false)
    private String address;            // Full Street Address

    @Column(nullable = false)
    private String district;           // e.g. "Patna", "Gaya", "Muzaffarpur"

    @Column(nullable = false)
    private String phoneNumber;        // Appointment Contact Number

    private Double consultationFee;    // e.g. 500.00

    private String availableTiming;    // e.g. "Mon-Sat: 10:00 AM - 4:00 PM"

    private String profileImgUrl;      // Doctor Photo or Visiting Card Image

    private Boolean isAvailable;       // Currently practicing (true/false)
}
