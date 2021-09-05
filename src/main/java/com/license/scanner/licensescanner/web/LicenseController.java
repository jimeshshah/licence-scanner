package com.license.scanner.licensescanner.web;

import com.license.scanner.licensescanner.model.BlockedLicenses;
import com.license.scanner.licensescanner.model.dto.Request;
import com.license.scanner.licensescanner.service.LicenseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/api")
@RestController
public class LicenseController {

    private final LicenseService licenseService;

    public LicenseController(LicenseService licenseService) {
        this.licenseService = licenseService;
    }

    @RequestMapping(value = "/blockLicense", method = RequestMethod.POST)
    public ResponseEntity<BlockedLicenses> blockLicense(@RequestBody BlockedLicenses blockedLicenses) {
        try {
            return new ResponseEntity<>(licenseService.blockLicense(blockedLicenses), HttpStatus.OK);
        } catch (Exception e) {
            Map<String, String> map = new HashMap<>();
            map.put("status", "false");
            map.put("message", e.getMessage());
            return new ResponseEntity(map, HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/parse", method = RequestMethod.POST)
    public ResponseEntity<String> parse(@RequestBody Request request) {
        try {
            return new ResponseEntity<>(licenseService.parseText(request.getText()), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
