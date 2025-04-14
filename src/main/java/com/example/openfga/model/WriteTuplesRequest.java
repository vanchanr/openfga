package com.example.openfga.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WriteTuplesRequest {
    private List<TupleKey> writes;
    private List<TupleKey> deletes;
    private String authorizationModelId;
}