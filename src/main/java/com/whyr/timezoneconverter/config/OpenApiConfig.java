package com.whyr.timezoneconverter.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {

        return new OpenAPI()
                .info(apiInfo())
                .addServersItem(new Server().url("/"));
    }

    private Info apiInfo() {

        return new Info()
                .title("OAG Client REST API")
                .description("API to get flights information from OAG")
                .version("1.0.0")
                .contact(apiContact());
    }

    private Contact apiContact() {

        return new Contact()
                .name("Pere David Porquer")
                .email("pd@whyr.com")
                .url("https://www.whyr.com");
    }

}
