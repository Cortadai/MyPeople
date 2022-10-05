
package com.example.springboot.configuration.swagger;

import java.util.Collections;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


@Configuration
public class SwaggerConfig {

	private ApiInfo apiInfo() {
	    return new ApiInfo(
	            "Spring Boot - HypeApp - REST API",
	            "Spring boot - HypeApp - REST API - Documentation",
	            "1",
	            "Terms of service",
	            new Contact("David Palanca",
	                    "https://github.com/Cortadai",
	                    "david.cortabarria@gmail.com"),
	            "License of API",
	            "API license URL",
	            Collections.emptyList()
	    );
	}
	@Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
//                .securityContexts(Collections.singletonList(securityContext()))
//                .securitySchemes(List.of(apiKey()))
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.springboot.controller"))
                .paths(PathSelectors.any())
                .build();
    }
}

