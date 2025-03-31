package br.com.developeralexandresantos.santander_dev_week.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.util.List;

@Configuration
public class OpenAPIConfig {

    @Autowired
    Environment env;

    @Bean
    public OpenAPI customOpenAPI() {
        if ("dev".equalsIgnoreCase(env.getActiveProfiles()[0])) {
            return new OpenAPI()
                    .servers(List.of(new Server().url("http://localhost:8080")
                            .description("Local Development Server")));
        }

        return new OpenAPI()
                .servers(List.of(
                        new Server()
                                .url("https://sdw-2023-api-production-prd.up.railway.app")
                                .description("Railway Production Server")
                ));
    }
}
