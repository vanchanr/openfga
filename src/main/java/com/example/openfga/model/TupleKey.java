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
public class TupleKey {
    private String user;
    private String relation;
    private String object;
    private String condition;
    private Map<String, Object> conditionContext;
}