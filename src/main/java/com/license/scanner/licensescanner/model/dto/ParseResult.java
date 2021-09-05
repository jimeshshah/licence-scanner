package com.license.scanner.licensescanner.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ParseResult {
    @JsonProperty("DriverLicense")
    public DriverLicense driverLicense;
    @JsonProperty("ErrorMessage")
    public String errorMessage;
    @JsonProperty("Reference")
    public String reference;
    @JsonProperty("Success")
    public boolean success;
    @JsonProperty("ValidationCode")
    public ValidationCode validationCode;
}
