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
public class TypeDefinition {
    private String type;
    private Map<String, Userset> relations;
    private Map<String, String> metadata;
}