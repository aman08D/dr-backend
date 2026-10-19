package com.dr.backend.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "users")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true, nullable = false)
    private String email;      // Admin ka Email (e.g. admin@dr.com)

    @Column(nullable = false)
    private String password;   // Admin ka Password

    private String role = "ROLE_ADMIN"; // Fixed 1 Admin Role
}
