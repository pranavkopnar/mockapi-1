package com.springboot.mockapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.mockapi.entity.converter.HashMapConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MockapiApplication {

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

    @Bean
    public HashMapConverter hashMapConverter() {
        return new HashMapConverter(objectMapper());
    }

    public static void main(String[] args) {
        SpringApplication.run(MockapiApplication.class, args);
    }

}
