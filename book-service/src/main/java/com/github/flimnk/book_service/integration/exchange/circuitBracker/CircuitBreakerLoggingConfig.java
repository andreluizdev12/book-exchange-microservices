package com.github.flimnk.book_service.integration.exchange.circuitBracker;

import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CircuitBreakerLoggingConfig {

    private static final Logger logger = LoggerFactory.getLogger(CircuitBreakerLoggingConfig.class);
    private final CircuitBreakerRegistry registry;

    public CircuitBreakerLoggingConfig(CircuitBreakerRegistry registry) {
        this.registry = registry;
    }

    @PostConstruct
    public void setupLogs() {

        registry.getAllCircuitBreakers().forEach(cb -> {
            cb.getEventPublisher()
                .onStateTransition(event -> 
                    logger.warn("Circuit Breaker '{}' transitioned from {} to {}", 
                        event.getCircuitBreakerName(), 
                        event.getStateTransition().getFromState(), 
                        event.getStateTransition().getToState()))
                
                .onError(event -> 
                    logger.error("Circuit Breaker '{}' recorded an error: {}", 
                        event.getCircuitBreakerName(), 
                        event.getThrowable().getMessage()))
                
                .onCallNotPermitted(event -> 
                    logger.info("Circuit Breaker '{}' is OPEN. Call rejected.", 
                        event.getCircuitBreakerName()));
        });
    }
}
