package com.educa.backend.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI apiInfo() {
        return new OpenAPI()
                .info(new Info()
                        .title("Plataforma Educativa API")
                        .description("Documentación de la API REST para la plataforma educativa personalizada")
                        .version("1.0")
                        .contact(new Contact()
                                .name("Equipo Educa")
                                .email("soporte@educa.com")));
    }
}
