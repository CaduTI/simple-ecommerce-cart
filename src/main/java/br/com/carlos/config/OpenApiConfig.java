package br.com.carlos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfig {
	
	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				.info(new Info()
				.title("Simple Ecommerce Cart")
				.version("V1")
				.description("A simple API with Java and Spring Boot")
				.termsOfService("https://github.com/CaduTI")
				.license(new License()
						.name("Apache 2.0")
						.url("https://github.com/CaduTI")
				)
				);
				
	}
}
