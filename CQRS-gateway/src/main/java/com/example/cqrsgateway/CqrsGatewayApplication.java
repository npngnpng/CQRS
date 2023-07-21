package com.example.cqrsgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication
public class CqrsGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(CqrsGatewayApplication.class, args);
    }

}
