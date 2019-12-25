package com.suamo.securecli;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.security.oauth2.common.AuthenticationScheme;
import org.springframework.security.oauth2.common.OAuth2AccessToken;

import java.util.Collections;

@SpringBootApplication
public class SecureCliApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SecureCliApplication.class, args);
    }

    @Override
    public void run(String... args) {

        System.out.println("starting cron job");

        ResourceOwnerPasswordResourceDetails resourceDetails = new ResourceOwnerPasswordResourceDetails();
        resourceDetails.setClientAuthenticationScheme(AuthenticationScheme.header);
        resourceDetails.setAccessTokenUri("http://localhost:9000/services/oauth/token");

        resourceDetails.setScope(Collections.singletonList("toll_read"));

        resourceDetails.setClientId("pluralsight");
        resourceDetails.setClientSecret("pluralsight");

        // will not work because of the roles
        // resourceDetails.setUsername("agoldberg");
        // resourceDetails.setPassword("pass1");
        resourceDetails.setUsername("bgoldberg");
        resourceDetails.setPassword("pass2");

        OAuth2RestTemplate template = new OAuth2RestTemplate(resourceDetails);
        OAuth2AccessToken token = template.getAccessToken();
        System.out.println("Token: " + token);

        String s = template.getForObject("http://localhost:9001/services/tolldata", String.class);
        System.out.println("Result: " + s);

    }
}
