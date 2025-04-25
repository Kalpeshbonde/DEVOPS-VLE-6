package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner run() {
        return args -> {
		// in DemoApplication.java or any controller
		System.out.println("New build triggered at: " + System.currentTimeMillis());
		System.out.println("hello world");

            System.out.println("The application has started successfully! (Custom Message)");
        };
    }
}
