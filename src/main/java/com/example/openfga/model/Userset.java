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
public class Userset {
    private UsersetThis usersetThis;
    private ComputedUserset computedUserset;
    private TupleToUserset tupleToUserset;
    private UsersetUnion union;
    private UsersetIntersection intersection;
    private UsersetDifference difference;
}