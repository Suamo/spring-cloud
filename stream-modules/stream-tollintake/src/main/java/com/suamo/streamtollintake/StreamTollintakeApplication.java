package com.suamo.streamtollintake;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@SpringBootApplication
@EnableBinding(Sink.class)
public class StreamTollintakeApplication {

    public static void main(String[] args) {
        SpringApplication.run(StreamTollintakeApplication.class, args);
    }

    @StreamListener(Sink.INPUT)
    public void log(String msg) {
        System.out.println(msg);
    }
}
