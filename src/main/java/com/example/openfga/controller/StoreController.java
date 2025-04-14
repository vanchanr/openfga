package com.example.openfga.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.openfga.service.OpenFgaService;

import java.util.Map;

@RestController
@RequestMapping("/stores")
public class StoreController {

    private final OpenFgaService openFgaService;

    @Autowired
    public StoreController(OpenFgaService openFgaService) {
        this.openFgaService = openFgaService;
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> createStore(@RequestBody Map<String, Object> request) {
        return openFgaService.createStore(request);
    }

    @GetMapping("/{storeId}")
    public ResponseEntity<Map<String, Object>> getStore(@PathVariable String storeId) {
        return openFgaService.getStore(storeId);
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> listStores(
            @RequestParam(required = false) Integer pageSize,
            @RequestParam(required = false) String continuationToken) {
        return openFgaService.listStores(pageSize, continuationToken);
    }

    @DeleteMapping("/{storeId}")
    public ResponseEntity<Void> deleteStore(@PathVariable String storeId) {
        return openFgaService.deleteStore(storeId);
    }
}