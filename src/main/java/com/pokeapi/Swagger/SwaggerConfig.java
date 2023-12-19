package com.pokeapi.Swagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition
public class SwaggerConfig {
    @Bean
    public OpenAPI api(){
        return new OpenAPI().info(new Info().title("Pokémon Statistics API with Spring-boot and MySQL")
                .description("Aplication Back-end Spring, Spring Boot, Gradle, Lombok, JPA y MySQL: PokeAPI, statistics, Domain architecture")
                .contact(new Contact().name("Github").url("https://github.com/MarioMozo/apiPokemonEstadisticas")));

      // url swagger  http://localhost:8080/swagger-ui/index.html
    }

}
