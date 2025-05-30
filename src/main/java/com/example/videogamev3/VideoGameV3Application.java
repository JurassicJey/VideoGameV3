package com.example.videogamev3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication

public class VideoGameV3Application {
    @Bean
    RestTemplate restTemplate() { return new RestTemplate();}
    public static void main(String[] args) {
        SpringApplication.run(VideoGameV3Application.class, args);
    }
}
