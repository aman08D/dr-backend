package com.dr.backend.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name="booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Customer Ki Details
    private String customerName;
    private String customerPhone;
    private String customerEmail;
    private String district;

    // Kya Book Ho Raha Hai?
    // Types: "DOCTOR", "WORKER", "EVENT", "PRODUCT"
    private String bookingType;

    // Kis Item Ko Book Kiya (Doctor ID / Event ID / Product ID)
    private Long referenceId;
    private String referenceTitle; // e.g. "Dr. Rahul Kumar" ya "Royal Palace Banquet"

    // Custom Message / Requirements
    private String message;
    private String bookingDate; // e.g. "2024-11-25"

    // Status: "PENDING", "CONFIRMED", "CANCELLED"
    private String status = "PENDING";

    private LocalDateTime createdAt = LocalDateTime.now();
}
