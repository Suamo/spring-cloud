package com.suamo.fastpassconsole;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.integration.support.MessageBuilder;

import java.util.Random;

//@EnableBinding(Source.class)
@EnableBinding(TollSource.class)
public class TollPublisher {

    Random r = new Random();


    @Bean
//    @InboundChannelAdapter(channel = Source.OUTPUT)
    @InboundChannelAdapter(channel = "fastpassTollChannel", poller = @Poller(fixedDelay = "2000"))
    public MessageSource<Toll> sendTollCharge() {
//        return "{station:\"20\", customerid:\"100\", timestamp:\"2017-07-12T03:15:00\"}";

        Toll payload = new Toll("20", "100", "2017-07-12T03:15:00");
        return () -> MessageBuilder.withPayload(payload).setHeader("speed", r.nextInt(8) * 10).build();
    }

    static class Toll {
        public String stationId;
        public String customerId;
        public String timestamp;

        public Toll(String stationId, String customerId, String timestamp) {
            this.stationId = stationId;
            this.customerId = customerId;
            this.timestamp = timestamp;
        }
    }
}
