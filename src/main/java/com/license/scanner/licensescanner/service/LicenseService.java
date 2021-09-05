package com.license.scanner.licensescanner.service;

import com.license.scanner.licensescanner.model.BlockedLicenses;
import com.license.scanner.licensescanner.repository.LicenseRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LicenseService {

    private final LicenseRepo licenseRepo;
    private final com.license.scanner.licensescanner.service.IdScanService idScanService;

    public LicenseService(LicenseRepo licenseRepo, com.license.scanner.licensescanner.service.IdScanService idScanService) {
        this.licenseRepo = licenseRepo;
        this.idScanService = idScanService;

    }

    public BlockedLicenses blockLicense(BlockedLicenses blockedLicensesRequest) throws Exception {
        Optional<BlockedLicenses> blockedLicenses = licenseRepo.findByLicenseIgnoreCase(blockedLicensesRequest.getLicense());
        if (blockedLicenses.isPresent()) {
            throw new Exception("License is already blocked");
        }
        return licenseRepo.save(blockedLicensesRequest);
    }

    public String parseText(String text) throws Exception {
        String license = idScanService.getLicense(text);

        Optional<BlockedLicenses> blockedLicenses = licenseRepo.findByLicenseIgnoreCase(license);
        if (blockedLicenses.isPresent()) {
            throw new Exception("License is blocked due to :" + blockedLicenses.get().getReason());
        }
        return "License is not blocked";
    }
}
