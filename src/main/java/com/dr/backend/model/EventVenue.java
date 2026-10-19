package com.dr.backend.model;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import java.util.Map;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "event_venues")
public class EventVenue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;           // Hall ya service ka naam (e.g., "Grand Banquet Hall")
    private String serviceType;    // Venue, Decoration, Catering, DJ, etc.
    private String district;       // Kahan par hai
    private String address;
    private int capacity;          // Kitne logo ki capacity hai (agar Venue hai toh)
    private double pricePerDay;    // Ek din ka kiraya
    private String contactNumber;
    private String description;

    private String imageUrl;       // Photo ka URL
    private Boolean isAvailable =true;

    private String eventType;     // NAYA: e.g., "Wedding", "Birthday"


    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb")
    private Map<String, Object> attributes;


}
