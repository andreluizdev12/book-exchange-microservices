package com.github.flimnk.book_service.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(
                title = "Book Service API",
                version = "v1",
                description = "Documetation of Book Microsservice API"
        )
)
@Configuration
public class OpenApiConfig {
        @Bean
        public OpenAPI customOpenApi() {
                return  new OpenAPI().
                        components(new Components()).
                                info(new io.swagger.v3.oas.models.info.Info()
                                        .title("Book Service API")
                                        .description("Documetation of Book Microsservice API")
                                        .version("V1")
                                        .license(new License()
                                                .name("Flimnk.osss")
                                                .url("https://github.com/andreluizdev12?tab=repositories")));


        }
}
