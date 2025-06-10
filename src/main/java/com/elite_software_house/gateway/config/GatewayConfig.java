package com.elite_software_house.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {
    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        String corso = "http://localhost:8080";
        String discenteDocente = "http://localhost:8081";

        return builder.routes()

                .route(r -> r.path("/api/corsi/**")
                        .uri(corso))
                .route(r -> r.path("/api/discenti/**", "/api/docenti/**")
                        .uri(discenteDocente))
                .build();
    }
}
