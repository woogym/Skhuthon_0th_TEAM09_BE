package com.skhuthon.skhuthon_0th_team9.global.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {

        Info info = new Info()
                .title("SKHUTHON_TEAM9 API")
                .description("SKHUTHON_TEAM9 API 명세서")
                .version("0.0.1");

        String authName = "JWT 토큰";

        SecurityRequirement securityRequirement = new SecurityRequirement();

        Components components = new Components()
                .addSecuritySchemes(authName,
                        new SecurityScheme()
                                .name(authName)
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("Bearer")
                                .bearerFormat("JWT")
                                .description("accessToken 입력하세요."));

        return new OpenAPI()
                .info(info)
                .addSecurityItem(securityRequirement)
                .components(components);
    }
}
