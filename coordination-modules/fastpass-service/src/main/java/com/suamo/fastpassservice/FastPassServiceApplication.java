package com.suamo.fastpassservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class FastPassServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(FastPassServiceApplication.class, args);
    }

}
