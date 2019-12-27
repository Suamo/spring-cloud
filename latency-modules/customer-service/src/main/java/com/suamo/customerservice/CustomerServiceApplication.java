package com.suamo.customerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @GetMapping("/customer/{cid}")
    public String getCustomer(RestTemplate restTemplate, @PathVariable int cid) {
        String contactUrl = "http://localhost:8081/fastpass/customer/" + cid + "/contactdetails";
        String vehicleUrl = "http://localhost:8082/fastpass/customer/" + cid + "/vehicledetails";

        ResponseEntity<String> contact = restTemplate.getForEntity(contactUrl, String.class);
        ResponseEntity<String> vehicle = restTemplate.getForEntity(vehicleUrl, String.class);

        return contact + " | " + vehicle;
    }
}
