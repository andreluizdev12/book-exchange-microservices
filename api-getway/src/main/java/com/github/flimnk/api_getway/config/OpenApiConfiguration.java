package com.github.flimnk.api_getway.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springdoc.core.properties.SwaggerUiConfigParameters;
import org.springdoc.core.properties.SwaggerUiConfigProperties;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import java.util.ArrayList;
import java.util.List;
@Configuration
public class OpenApiConfiguration {

    @Bean
    public List<GroupedOpenApi> apis(RouteDefinitionLocator locator) {

        List<GroupedOpenApi> groups = new ArrayList<>();

        locator.getRouteDefinitions()
                .filter(route -> route.getId().matches(".*-service"))
                .toStream() // seguro apenas no startup
                .forEach(route -> {
                    String name = route.getId();

                    groups.add(GroupedOpenApi.builder()
                            .group(name)
                            .pathsToMatch("/" + name + "/**")
                            .build());
                });

        return groups;
    }
}
