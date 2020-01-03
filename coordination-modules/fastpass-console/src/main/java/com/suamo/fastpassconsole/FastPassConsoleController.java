package com.suamo.fastpassconsole;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class FastPassConsoleController {

    private final RestTemplate rest;

    public FastPassConsoleController(RestTemplate rest) {
        this.rest = rest;
    }

    @GetMapping(value = "/customerdetails", params = {"fastpassid"})
    @HystrixCommand(fallbackMethod = "getFastPassCustomerDetailsBackup")
    public String getFastPassById(@RequestParam String fastpassid, Model model) {
        String url = "http://fastpass-service/fastpass?fastpassid=" + fastpassid;
        FastPassCustomer c = rest.getForObject(url, FastPassCustomer.class);
        System.out.println("received customer details");
        model.addAttribute("customer", c);
        return "console";
    }

    public String getFastPassCustomerDetailsBackup(@RequestParam String fastpassid, Model model) {
        FastPassCustomer c = new FastPassCustomer();
        c.setFastPassId(fastpassid);
        System.out.println("fallback operation called");

        model.addAttribute("customer", c);
        return "console";
    }

}
