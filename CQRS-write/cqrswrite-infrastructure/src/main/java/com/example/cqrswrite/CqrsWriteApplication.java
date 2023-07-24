package com.example.cqrswrite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication
public class CqrsWriteApplication {

    public static void main(String[] args) {
        SpringApplication.run(CqrsWriteApplication.class, args);
    }

}
