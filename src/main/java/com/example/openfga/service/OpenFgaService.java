package com.example.openfga.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.openfga.config.OpenFgaConfig;
import com.example.openfga.model.*;

import java.util.Map;

@Service
public class OpenFgaService {

    private final RestTemplate restTemplate;
    private final OpenFgaConfig openFgaConfig;

    @Autowired
    public OpenFgaService(RestTemplate restTemplate, OpenFgaConfig openFgaConfig) {
        this.restTemplate = restTemplate;
        this.openFgaConfig = openFgaConfig;
    }

    // Authorization Model Operations
    public ResponseEntity<Map<String, Object>> writeAuthorizationModel(WriteAuthorizationModelRequest request) {
        String url = openFgaConfig.getServerUrl() + "/authorization-models";
        return restTemplate.postForEntity(url, request, Map.class);
    }

    public ResponseEntity<AuthorizationModel> readAuthorizationModel(String id) {
        String url = openFgaConfig.getServerUrl() + "/authorization-models/" + id;
        return restTemplate.getForEntity(url, AuthorizationModel.class);
    }

    public ResponseEntity<Map<String, Object>> listAuthorizationModels(Integer pageSize, String continuationToken) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(openFgaConfig.getServerUrl() + "/authorization-models");
        
        if (pageSize != null) {
            builder.queryParam("page_size", pageSize);
        }
        
        if (continuationToken != null && !continuationToken.isEmpty()) {
            builder.queryParam("continuation_token", continuationToken);
        }
        
        return restTemplate.getForEntity(builder.toUriString(), Map.class);
    }

    // Check Operations
    public ResponseEntity<CheckResponse> check(String storeId, CheckRequest request) {
        String url = openFgaConfig.getServerUrl() + "/stores/" + storeId + "/check";
        return restTemplate.postForEntity(url, request, CheckResponse.class);
    }

    // Tuple Operations
    public ResponseEntity<Map<String, Object>> writeTuples(String storeId, WriteTuplesRequest request) {
        String url = openFgaConfig.getServerUrl() + "/stores/" + storeId + "/write";
        return restTemplate.postForEntity(url, request, Map.class);
    }

    public ResponseEntity<Map<String, Object>> readTuples(String storeId, TupleKey tupleKey, String authorizationModelId) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(openFgaConfig.getServerUrl() + "/stores/" + storeId + "/read");
        
        if (authorizationModelId != null && !authorizationModelId.isEmpty()) {
            builder.queryParam("authorization_model_id", authorizationModelId);
        }
        
        return restTemplate.postForEntity(builder.toUriString(), tupleKey, Map.class);
    }

    // Store Operations
    public ResponseEntity<Map<String, Object>> createStore(Map<String, Object> request) {
        String url = openFgaConfig.getServerUrl() + "/stores";
        return restTemplate.postForEntity(url, request, Map.class);
    }

    public ResponseEntity<Map<String, Object>> getStore(String storeId) {
        String url = openFgaConfig.getServerUrl() + "/stores/" + storeId;
        return restTemplate.getForEntity(url, Map.class);
    }

    public ResponseEntity<Map<String, Object>> listStores(Integer pageSize, String continuationToken) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(openFgaConfig.getServerUrl() + "/stores");
        
        if (pageSize != null) {
            builder.queryParam("page_size", pageSize);
        }
        
        if (continuationToken != null && !continuationToken.isEmpty()) {
            builder.queryParam("continuation_token", continuationToken);
        }
        
        return restTemplate.getForEntity(builder.toUriString(), Map.class);
    }

    public ResponseEntity<Void> deleteStore(String storeId) {
        String url = openFgaConfig.getServerUrl() + "/stores/" + storeId;
        return restTemplate.exchange(url, HttpMethod.DELETE, null, Void.class);
    }
}