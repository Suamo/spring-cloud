package com.suamo.dataservice1;

import brave.sampler.Sampler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomSampler {

    @Bean
    public Sampler smartSampler() {
        return new Sampler() {
            @Override
            public boolean isSampled(long traceId) {
                System.out.println("custom sampler used!");
                return true;
            }
        };
    }

}
