package com.suamo.zuulapiproxy;

import com.suamo.zuulapiproxy.filters.ProxyFilter;
import com.suamo.zuulapiproxy.filters.StartPreFilter;
import com.suamo.zuulapiproxy.filters.StopPostFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy
public class ZuulApiproxyApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulApiproxyApplication.class, args);
    }

    @Bean
    public ProxyFilter proxyFilter() {
        return new ProxyFilter();
    }

    @Bean
    public StartPreFilter startPreFilter() {
        return new StartPreFilter();
    }

    @Bean
    public StopPostFilter stopPostFilter() {
        return new StopPostFilter();
    }
}
