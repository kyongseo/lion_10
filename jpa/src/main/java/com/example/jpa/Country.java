package com.example.jpa;

import jakarta.persistence.*;

@Entity
@Table(name = "countries")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id",nullable = false)
    private String id;

    @Column(name = "country_name")
    private String name;

    @Column(name = "region_id", nullable = false)
    private Region region;
}
