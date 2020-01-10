package com.suamo.streamtollintake;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.handler.annotation.SendTo;

@SpringBootApplication
@EnableBinding(Sink.class)
//@EnableBinding(Processor.class)
public class StreamTollintakeApplication {

    public static void main(String[] args) {
        SpringApplication.run(StreamTollintakeApplication.class, args);
    }

    @StreamListener(Sink.INPUT)
//    @ServiceActivator(inputChannel = Sink.INPUT)
//    @StreamListener(Processor.INPUT)
//    @SendTo(Processor.OUTPUT)
    public void log(String msg) {
        System.out.println(msg);
//        return msg;
    }
}
