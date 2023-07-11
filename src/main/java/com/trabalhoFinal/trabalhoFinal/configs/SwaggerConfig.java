package com.trabalhoFinal.trabalhoFinal.configs;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Documentação da API sobre o Sistema de atendimentos de solicitações HelpFlow")
                        .version("Version 1 (v1)")
                        .description("""
                                Esta documentação apresenta os endpoints
                                responsáveis pelas funcionalidades de Atendente, Atendimento,
                                Cliente, dispositivo e solicitiação
                                """)
                        .termsOfService("http://mytersm.com")
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://mylicences.com")));
    }

}