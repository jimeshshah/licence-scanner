package com.license.scanner.licensescanner.repository;

import com.license.scanner.licensescanner.model.BlockedLicenses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LicenseRepo extends JpaRepository<BlockedLicenses, Long> {

    Optional<BlockedLicenses> findByLicenseIgnoreCase(String license);
}
