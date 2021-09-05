package com.license.scanner.licensescanner.model;

import lombok.*;

import javax.persistence.*;

@Table(name = "restaurant")
@Entity
@Data
public class Restaurant extends AbstractEntity{

    @Column(nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String address1;

    private String address2;

    private String city;

    @Column(name = "zip_code")
    private String zipCode;

    private String country;

    @Column(name = "is_active")
    private Boolean isActive = true;

}
