package com.suamo.fastpassconsole;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class FastPassConsoleApplication {

    public static void main(String[] args) {
        SpringApplication.run(FastPassConsoleApplication.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate rest(RestTemplateBuilder builder) {
        return builder.build();
    }

}
