package com.suamo.dataservice1;

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
public class DataService1Application {

    public static void main(String[] args) {
        SpringApplication.run(DataService1Application.class, args);
    }

    @GetMapping("/customer/{cid}/contactdetails")
    public String getCustomerContactDetails(@PathVariable int cid) throws InterruptedException {

        //add arbitrary latency
        Random r = new Random();
        int multiplier = r.nextInt(10) * 500;
        System.out.println("multiplier: " + multiplier);
        Thread.sleep(multiplier);

        Map<Integer, String> customers = new HashMap<>();
        customers.put(100, "Reverly Goldberg");
        customers.put(101, "Dave Kim");
        customers.put(102, "Lainey Kewis");

        return customers.get(cid);
    }

}
