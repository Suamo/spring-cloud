package com.suamo.tollrateservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.Instant;

@RestController
public class TollRateController {

    @GetMapping("/tollrate/{stationid}")
    public TollRate getTollRate(@PathVariable int stationid) {
        System.out.println("Station requested: " + stationid);
        switch (stationid) {
            case 1:
                return new TollRate(stationid, new BigDecimal("0.55"), Instant.now().toString());
            case 2:
                return new TollRate(stationid, new BigDecimal("1.05"), Instant.now().toString());
            case 3:
                return new TollRate(stationid, new BigDecimal("0.60"), Instant.now().toString());
            default:
                return new TollRate(stationid, new BigDecimal("1.00"), Instant.now().toString());
        }
    }

}
