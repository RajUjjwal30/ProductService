package com.example.productservice.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration

public class ApplicationConfig {
    //making an object for configurations (this) class using @Configuration (making class special by the annotation)...... not constructors
    //@Configuration --> means this special class is going to have @Bean methods :
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
