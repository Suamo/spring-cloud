package com.suamo.tollratebillboardservice;

import com.suamo.tollrateservice.TollRate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class BillboardController {

    @Autowired
    private RestTemplate rest;

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @GetMapping("/dashboard")
    public String getTollRate(@RequestParam int stationId, Model model) {

        // important - no exact hostname or port
        String url = "http://toll-service/tollrate/" + stationId;

        TollRate tr = rest.getForObject(url, TollRate.class);
        System.out.println("stationId: " + stationId);
        model.addAttribute("rate", tr.getCurrentRate());

        return "console";
    }

}
