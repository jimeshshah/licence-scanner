package com.license.scanner.licensescanner.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ValidationCode {
    @JsonProperty("Errors")
    public List<Object> errors;
    @JsonProperty("IsValid")
    public boolean isValid;
}
