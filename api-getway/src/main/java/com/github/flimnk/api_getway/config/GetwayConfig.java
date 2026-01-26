//package com.github.flimnk.api_getway.config;
//
//import org.springframework.cloud.gateway.route.RouteLocator;
//import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
////@Configuration
////public class GetwayConfig {
////    @Bean
////    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
////        return builder.routes()
////                .route(p -> p
////                        .path("/api/exchange/**")
////                       .uri("lb://EXCHANGE-SERVICE"))
////                .route(p -> p
////                        .path("/api/book/**")
////                        .uri("lb://BOOK-SERVICE"))
//////                .route(p -> p
//////                        .path("/get")
//////                        .filters(f -> f.addRequestHeader("Hello", "World")
//////                                .addRequestHeader("LOOOSE","Vadia"))
//////                        .uri("http://httpbin.org:80"))
//////                .route(p -> p
//////                        .host("*.circuitbreaker.com")
//////                        .filters(f -> f.circuitBreaker(config -> config
//////                                .setName("mycmd")
//////                                .setFallbackUri("forward:/fallback")))
//////                        .uri("http://httpbin.org:80"))
////                .build();
////    }
//
//}
