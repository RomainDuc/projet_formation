package projetFormation.config;



import java.util.Collections;


import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@EnableWebMvc
public class SwaggerConfig  {

	

	@Bean
    public Docket formationSpringApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("projetFormation.controller"))
                .build();
    }


	private ApiInfo apiInfo() {
        return new ApiInfo(
                "Projet Red Line Spring REST API",
                "Some custom description of API.",
                "1.0",
                "Terms of service",
                new Contact("Mehdi MAAMAR", "Romain", "Christophe"),
                "License of API",
                "API license URL",
                Collections.emptyList());
    }
}
