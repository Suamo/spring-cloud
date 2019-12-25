package com.suamo.secureauthserver;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;

@Configuration
public class ServiceContig extends GlobalAuthenticationConfigurerAdapter {

    @Override
    public void init(AuthenticationManagerBuilder auth) throws Exception {

        // https://spring.io/blog/2017/11/01/spring-security-5-0-0-rc1-released#password-storage-format
        // https://docs.spring.io/spring-security/site/docs/current/reference/htmlsingle/#pe-dpe
        auth.inMemoryAuthentication()
                .withUser("agoldberg").password("{noop}pass1").roles("USER").and()
                .withUser("bgoldberg").password("{noop}pass2").roles("USER", "OPERATOR");
    }
}
