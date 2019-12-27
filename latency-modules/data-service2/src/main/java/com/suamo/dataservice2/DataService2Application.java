package com.suamo.dataservice2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@SpringBootApplication
@RestController
public class DataService2Application {

    public static void main(String[] args) {
        SpringApplication.run(DataService2Application.class, args);
    }

    @GetMapping("/customer/{cid}/vehicledetails")
    public String getCustomerContactDetails(@PathVariable int cid) throws InterruptedException {

        Map<Integer, String> customers = new HashMap<>();
        customers.put(100, "Lincoln Continental; PLATE AAAA");
        customers.put(101, "Chevrolet Camaro; Plate BBBB");
        customers.put(102, "Volkswagen Beetle; Plate CCC");

        return customers.get(cid);
    }

}
