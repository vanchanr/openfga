package com.example.openfga.model;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CheckRequest {
    private String user;
    private String relation;
    private String object;
    private Map<String, Object> contextualTuples;
    private Map<String, Object> context;
    private String authorizationModelId;
    private Boolean trace;
}