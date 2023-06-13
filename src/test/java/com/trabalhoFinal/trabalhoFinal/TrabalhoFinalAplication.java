package com.trabalhoFinal.trabalhoFinal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.logging.Logger;

@SpringBootApplication
public class TrabalhoFinalAplication {
    private Logger logger = Logger. getLogger (TrabalhoFinalAplication.class.getName());

    public static void main(String[] args) {
        SpringApplication.run(TrabalhoFinalAplication.class, args);
    }
}
