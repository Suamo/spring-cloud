package com.suamo.secureservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@RestController
@EnableResourceServer
public class SecureServiceApplication {

    @Autowired
    private ResourceServerProperties sso;

    public static void main(String[] args) {
        SpringApplication.run(SecureServiceApplication.class, args);
    }

    @GetMapping("/tolldata")
    @PreAuthorize("#oauth2.hasScope('toll_read') and hasAuthority('ROLE_OPERATOR')")
    public List<TollUsage> getTollData() {
        TollUsage instance1 = new TollUsage("100", "station150", "AAAAA", "2019-12-29T06:31:22");
        TollUsage instance2 = new TollUsage("101", "station119", "BBBBB", "2019-12-29T06:32:50");
        TollUsage instance3 = new TollUsage("102", "station150", "CCCCC", "2019-12-29T06:37:01");

        return Arrays.asList(instance1, instance2, instance3);
    }

    @Bean
    public ResourceServerTokenServices myResourceServerTokenServices() {
        return new CustomUserInfoTokenServices(sso.getUserInfoUri(), sso.getClientId());
    }

    @SuppressWarnings("WeakerAccess")
    public static class TollUsage {
        public String id;
        public String stationId;
        public String licensePlate;
        public String timestamp;

        public TollUsage() {

        }

        TollUsage(String id, String stationId, String licensePlate, String timestamp) {
            this.id = id;
            this.stationId = stationId;
            this.licensePlate = licensePlate;
            this.timestamp = timestamp;
        }
    }

}
