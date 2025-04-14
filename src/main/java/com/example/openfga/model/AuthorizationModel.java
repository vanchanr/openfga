package com.example.openfga.model;

import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthorizationModel {
    private String id;
    private String schemaVersion;
    private List<TypeDefinition> typeDefinitions;
    private List<Condition> conditions;
}