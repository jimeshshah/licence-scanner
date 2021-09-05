package com.license.scanner.licensescanner.repository;

import com.license.scanner.licensescanner.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface RoleRepository extends JpaRepository<Role, Long>{

    Set<Role> findByNameIgnoreCaseIsContaining(String role);
}
