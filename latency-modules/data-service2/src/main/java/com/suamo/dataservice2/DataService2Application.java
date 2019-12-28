package com.suamo.dataservice2;

import brave.Span;
import brave.Tracer;
import brave.propagation.ExtraFieldPropagation;
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
    private Tracer tracer;

    public DataService2Application(Tracer tracer) {
        this.tracer = tracer;
    }

    public static void main(String[] args) {
        SpringApplication.run(DataService2Application.class, args);
    }

    @GetMapping("/customer/{cid}/vehicledetails")
    public String getCustomerContactDetails(@PathVariable int cid) throws InterruptedException {


        Span parent = tracer.currentSpan();
        Tracer.SpanInScope ws = tracer.withSpanInScope(parent);
        Span span = tracer.nextSpan().name("lookupvehicle").start();
        span.tag("customerid", String.valueOf(cid));
        span.annotate("Database query started"); // logging an event!

        try {
            Thread.sleep(500);

            ExtraFieldPropagation.set(span.context(), "foo", "bar");
            ExtraFieldPropagation.set(span.context(), "UPPER_CASE", "someValue");

            Map<Integer, String> customers = new HashMap<>();
            customers.put(100, "Lincoln Continental; PLATE AAAA");
            customers.put(101, "Chevrolet Camaro; Plate BBBB");
            customers.put(102, "Volkswagen Beetle; Plate CCC");

            span.annotate("Database query started"); // logging an event!
            return customers.get(cid);
        } finally {
            span.finish();
        }
    }

}
