package com.example.kanbanserv.domain.error;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorDetails {
    @JsonProperty
    private String field;

    @JsonProperty
    private String value;

    @JsonProperty
    private String issue;

    @JsonProperty
    private String description;

    @JsonProperty
    private String location;
}
