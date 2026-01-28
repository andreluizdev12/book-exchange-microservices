## System Architecture Overview

This project follows microservices architecture principles, focusing on scalability, resilience, and loose coupling.

All applications are built with Spring Boot and orchestrated using Spring Cloud components. Client requests are routed through an API Gateway, which acts as the single entry point to the system.

---

## Architectural Components

### Service Discovery (Eureka Naming Server)

- Central registry for all microservices  
- Automatic service registration and discovery  
- No hardcoded service addresses  
- Enables dynamic scaling and fault tolerance  

---

### API Gateway (Spring Cloud Gateway)

- Single entry point for external requests  
- Dynamic routing using service discovery  
- Integrated load balancing  
- Centralized exposure of API documentation  

---

### Book Service

- Core business microservice  
- Exposes REST APIs related to book operations  
- Communicates with Exchange Service using OpenFeign  
- Implements Circuit Breaker with Resilience4j  
- Provides fallback responses on failures  

---

### Exchange Service

- Supporting microservice for external integration or data transformation  
- Exposes REST APIs  
- Registered and discoverable via Eureka  
- Independently scalable  

---

## Inter-Service Communication

- REST-based communication  
- OpenFeign used as declarative HTTP client  
- Logical service names resolved via Eureka  
- Loose coupling between services  

---

## Resilience and Fault Tolerance

- Circuit Breaker Pattern implemented with Resilience4j  
- Automatic fallback mechanisms  
- Prevention of cascading failures  
- Graceful degradation under partial failures  

---

## Load Balancing

- Implemented using Spring Cloud LoadBalancer  
- Integrated at the API Gateway level  
- Requests distributed across registered service instances  
- Transparent horizontal scalability  

---

## API Documentation

- Each microservice exposes its own OpenAPI specification  
- Documentation generated automatically with SpringDoc OpenAPI  
- Swagger UI centralized through the API Gateway  
- Improves maintainability and developer experience  

---

## Design Principles Applied

- Microservices Architecture  
- API Gateway Pattern  
- Service Discovery Pattern  
- Circuit Breaker Pattern  
- Separation of Concerns  
- Loose Coupling  
- High Availability  

---

## Technology Stack

- Java 21  
- Spring Boot  
- Spring Cloud Gateway  
- Eureka Naming Server  
- OpenFeign  
- Resilience4j  
- Spring Cloud LoadBalancer  
- SpringDoc OpenAPI  
- Maven  

---

## Project Goal

This project was developed to practice real-world Spring Cloud microservices architecture, focusing on resilience, scalability, and clean service communication.

