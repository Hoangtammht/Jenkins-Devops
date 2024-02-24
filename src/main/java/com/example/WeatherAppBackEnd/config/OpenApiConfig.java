package com.example.WeatherAppBackEnd.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(
                title = "Weather Project Awesome API",
                version = "1.0.0",
                description = "Weather App Back-end"
        ),
        servers = {
                @Server(url = "http://localhost:8080", description = "Local Development Server"),
                @Server(url = "http://192.168.1.12:8080", description = "Local IP Address Server"),

        }
)

@Configuration
public class OpenApiConfig {
}
