package com.academiacx.projetofinal.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTampleteConfig {

    @Bean
    public RestTemplate  restTamplate() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate;
    }
}
