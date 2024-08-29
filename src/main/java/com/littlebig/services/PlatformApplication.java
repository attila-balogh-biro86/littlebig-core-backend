package com.littlebig.services;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PlatformApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(PlatformApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}