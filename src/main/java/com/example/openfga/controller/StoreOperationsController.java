package com.example.openfga.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.openfga.model.CheckRequest;
import com.example.openfga.model.CheckResponse;
import com.example.openfga.model.TupleKey;
import com.example.openfga.model.WriteTuplesRequest;
import com.example.openfga.service.OpenFgaService;

import java.util.Map;

@RestController
@RequestMapping("/stores/{storeId}")
public class StoreOperationsController {

    private final OpenFgaService openFgaService;

    @Autowired
    public StoreOperationsController(OpenFgaService openFgaService) {
        this.openFgaService = openFgaService;
    }

    @PostMapping("/check")
    public ResponseEntity<CheckResponse> check(
            @PathVariable String storeId,
            @RequestBody CheckRequest request) {
        return openFgaService.check(storeId, request);
    }

    @PostMapping("/write")
    public ResponseEntity<Map<String, Object>> writeTuples(
            @PathVariable String storeId,
            @RequestBody WriteTuplesRequest request) {
        return openFgaService.writeTuples(storeId, request);
    }

    @PostMapping("/read")
    public ResponseEntity<Map<String, Object>> readTuples(
            @PathVariable String storeId,
            @RequestBody TupleKey tupleKey,
            @RequestParam(required = false) String authorizationModelId) {
        return openFgaService.readTuples(storeId, tupleKey, authorizationModelId);
    }
}