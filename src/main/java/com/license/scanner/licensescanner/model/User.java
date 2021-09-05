package com.license.scanner.licensescanner.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
@Data
public class User extends AbstractEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    @Transient
    private String passwordConfirm;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "restaurant_id", referencedColumnName = "id")
    private Restaurant restaurant;

    private String firstName;

    private String lastName;

    @Column(name = "is_active")
    private Boolean isActive = true;

    @ManyToMany
    private Set<Role> roles = new HashSet<>();

    private Boolean isAdmin = false;


}
