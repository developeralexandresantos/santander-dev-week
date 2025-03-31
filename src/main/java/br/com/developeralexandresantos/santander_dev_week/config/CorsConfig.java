package br.com.developeralexandresantos.santander_dev_week.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Autowired
    Environment env;

    @Bean
    public WebMvcConfigurer corsConfigurer() {

        if(!"dev".equalsIgnoreCase(env.getActiveProfiles()[0])) {
            return new WebMvcConfigurer() {
                @Override
                public void addCorsMappings(CorsRegistry registry) {
                    registry.addMapping("/**")
                            .allowedOrigins("https://sdw-2023-api-production-prd.up.railway.app")
                            .allowedMethods("*")
                            .allowedHeaders("*");
                }
            };
        }
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins(
                                "http://localhost:8080" // localhost
                        )
                        .allowedMethods("*")
                        .allowedHeaders("*");
            }
        };
    }
}
