package com.cdt.usermanager;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AppApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppApplication.class, args);
    }

    @Bean
    public OpenAPI customizeOpenApi() {
        return new OpenAPI().info(new Info()
                .title("User Manager")
                .version("1.0.0")
                .description("Basic API for registering and obtaining users in Spring Boot with MySQL"));
    }

}
