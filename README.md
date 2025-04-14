# OpenFGA API Proxy

A Spring Boot application that exposes OpenFGA API endpoints based on the official OpenFGA API specification.

## Overview

This application serves as a proxy for the OpenFGA (Fine-Grained Authorization) service. It implements the API endpoints defined in the [OpenFGA Swagger Specification](https://raw.githubusercontent.com/openfga/api/main/docs/openapiv2/apidocs.swagger.json).

## Technology Stack

- Java 21
- Spring Boot 3.4.3
- Gradle 8.12.1
- SpringDoc OpenAPI for API documentation

## Configuration

The application can be configured through `application.yml`. The primary configuration is:

```yaml
openfga:
  serverUrl: http://your-openfga-server:8080
```

## API Endpoints

The application exposes the following main endpoints:

- **Authorization Models**: `/authorization-models` - Manage authorization models
- **Stores**: `/stores` - Manage OpenFGA stores
- **Check**: `/stores/{storeId}/check` - Check permissions
- **Tuples**: `/stores/{storeId}/write` - Write and delete tuples

## Getting Started

1. Configure the OpenFGA server URL in `application.yml`
2. Run the application
3. Access the Swagger UI at: http://localhost:8080/swagger-ui.html

## Building and Running

```bash
./gradlew build
java -jar build/libs/openfga-0.0.1-SNAPSHOT.jar
```
