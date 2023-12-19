package com.pokeapi.Swagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition
public class SwaggerConfig {
    //http://localhost:8080/swagger-ui/index.html
    public OpenAPI api(){

        return new OpenAPI();
    }

}
