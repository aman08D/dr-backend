package com.dr.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    // level 1: Main Section
    // "SCHOOL_PRODUCT" ya "PRINTING_SERVICE"
    @Column(nullable = false)
    private String productType;

    // level: 2 Main section
    // "UNIFORM", "STATIONERY", "PRINTING"
    @Column(nullable = false)
    private String category;

    //Level: 3 Sub Category;
    // "TIE", "BELT", "ID_CARD", "JHOLA", "BOOK"
    @Column(nullable = false)
    private  String subCategory;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Double price;

    private Boolean isAvailable;

    private Boolean isCustomizable;

    private Integer stockQuantity;

    @Column(columnDefinition = "TEXT")

    private String imgUrl;
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb")
    private Map<String ,Object> attributes;




}
