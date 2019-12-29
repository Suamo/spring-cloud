package com.suamo.tollrateservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class TollrateServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TollrateServiceApplication.class, args);
    }

}
