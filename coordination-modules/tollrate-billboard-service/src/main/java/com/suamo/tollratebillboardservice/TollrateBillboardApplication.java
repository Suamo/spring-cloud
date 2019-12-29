package com.suamo.tollratebillboardservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class TollrateBillboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(TollrateBillboardApplication.class, args);
    }

}
