package com.example.openfga.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.openfga.model.AuthorizationModel;
import com.example.openfga.model.WriteAuthorizationModelRequest;
import com.example.openfga.service.OpenFgaService;

import java.util.Map;

@RestController
@RequestMapping("/authorization-models")
public class AuthorizationModelController {

    private final OpenFgaService openFgaService;

    @Autowired
    public AuthorizationModelController(OpenFgaService openFgaService) {
        this.openFgaService = openFgaService;
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> writeAuthorizationModel(@RequestBody WriteAuthorizationModelRequest request) {
        return openFgaService.writeAuthorizationModel(request);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorizationModel> readAuthorizationModel(@PathVariable String id) {
        return openFgaService.readAuthorizationModel(id);
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> listAuthorizationModels(
            @RequestParam(required = false) Integer pageSize,
            @RequestParam(required = false) String continuationToken) {
        return openFgaService.listAuthorizationModels(pageSize, continuationToken);
    }
}