package com.suamo.fastpassconsole;

import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.PingUrl;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
//@EnableEurekaClient
//@EnableCircuitBreaker
public class FastPassConsoleApplication {

    public static void main(String[] args) {
        SpringApplication.run(FastPassConsoleApplication.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate rest(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public IPing ribbonPing() {
        return new PingUrl(false, "/actuator/info");
    }

    @Bean
    public IRule ribbonRule() {
        return new RoundRobinRule();
    }
}
