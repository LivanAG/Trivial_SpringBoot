package com.example.pruebaspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class PruebaSpringApplication {

    public static void main(String[] args) {

        SpringApplication.run(PruebaSpringApplication.class, args);

    }

}
