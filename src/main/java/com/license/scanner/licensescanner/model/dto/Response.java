package com.license.scanner.licensescanner.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Response {

    @JsonProperty("ParseResult")
    public ParseResult parseResult;
}
