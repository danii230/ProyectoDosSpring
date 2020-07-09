package com.solutions.proyecto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableJpaRepositories("com.solutions.repository")
@SpringBootApplication @ComponentScan({ "com.solutions.controller","com.solutions.repository", "com.solutions.service", "com.solutions.dto", "com.solutions.converter" } )
public class ProyectoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProyectoApplication.class, args);
    }

}
