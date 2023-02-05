package com.academiacx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class AcademiacxApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(AcademiacxApplication.class, args);
    }

}
