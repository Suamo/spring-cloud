package com.suamo.fastpassservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@RestController
public class FastPassController {

    private List<FastPassCustomer> customerList = new ArrayList<>();

    public FastPassController() {
        customerList.add(new FastPassCustomer("100", "Richard", "555-123-4567", BigDecimal.valueOf(0.2)));
        customerList.add(new FastPassCustomer("101", "Jason", "555-321-7654", BigDecimal.valueOf(0.3)));
        customerList.add(new FastPassCustomer("102", "Lisa", "555-987-6543", BigDecimal.valueOf(0.4)));
    }

    @GetMapping(value = "/fastpass", params = {"fastpassid"})
    public FastPassCustomer getFastPassById(@RequestParam String fastpassid) {
        Predicate<FastPassCustomer> p = c -> c.getFastPassId().equals(fastpassid);
        return customerList.stream().filter(p).findFirst().get();
    }

    @GetMapping(value = "/fastpass", params = {"fastpassphone"})
    public FastPassCustomer getFastPassByPhone(@RequestParam String fastpassphone) {
        Predicate<FastPassCustomer> p = c -> c.getFastPassPhone().equals(fastpassphone);
        return customerList.stream().filter(p).findFirst().get();
    }

}
