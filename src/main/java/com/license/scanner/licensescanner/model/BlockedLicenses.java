package com.license.scanner.licensescanner.model;

import lombok.Data;

import javax.persistence.*;


@Table(name = "blocked_licenses")
@Entity
@Data
public class BlockedLicenses extends AbstractEntity{

    @Column(nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    private User user;

    private String license;

    private String reason;

}
