package com.suamo.customerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    /**
     * https://cloud.spring.io/spring-cloud-sleuth/reference/html/#synchronous-rest-template:
     * "You have to register RestTemplate as a bean so that the interceptors get injected.
     * If you create a RestTemplate instance with a new keyword, the instrumentation does NOT work."
     */
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
