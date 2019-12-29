package com.suamo.fastpassconsole;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class FastPassConsoleApplication {

    public static void main(String[] args) {
        SpringApplication.run(FastPassConsoleApplication.class, args);
    }

}
