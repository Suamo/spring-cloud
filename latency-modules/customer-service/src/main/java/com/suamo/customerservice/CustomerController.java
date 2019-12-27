package com.suamo.customerservice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CustomerController {

    private final RestTemplate restTemplate;

    public CustomerController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/customer/{cid}")
    public String getCustomer(@PathVariable int cid) {
        String contactUrl = "http://localhost:8081/fastpass/customer/" + cid + "/contactdetails";
        String vehicleUrl = "http://localhost:8082/fastpass/customer/" + cid + "/vehicledetails";

        ResponseEntity<String> contact = restTemplate.getForEntity(contactUrl, String.class);
        ResponseEntity<String> vehicle = restTemplate.getForEntity(vehicleUrl, String.class);

        return contact.getBody() + " | " + vehicle.getBody();
    }
}
