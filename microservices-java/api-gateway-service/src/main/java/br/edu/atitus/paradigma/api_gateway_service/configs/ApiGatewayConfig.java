package br.edu.atitus.paradigma.api_gateway_service.configs;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfig {

    @Bean
    public RouteLocator getRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
            .route("cambio-service", route -> route
                .path("/cambio-service/**")
                .filters(f -> f.addRequestHeader("Usuario", "Nycolas Musskopf Fachi"))
                .uri("lb://CAMBIO-SERVICE"))

            .route("produto-service", route -> route
                .path("/produto-service/**")
                .filters(f -> f.addRequestHeader("Usuario", "Nycolas Musskopf Fachi"))
                .uri("lb://PRODUTO-SERVICE"))

            .route("saudacao-service", route -> route
                .path("/saudacao-service/**")
                .filters(f -> f.addRequestHeader("Usuario", "Nycolas Musskopf Fachi"))
                .uri("lb://SAUDACAO-SERVICE"))

            .build();
    }
}
