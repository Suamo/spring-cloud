package com.suamo.fastpassconsole;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class FastPassRestController {

    @Autowired
    TollSource mySource;

    @PostMapping("/toll")
    public String publishMessage(@RequestBody String payload) {
        System.out.println(payload);
        Random r = new Random();
        Message<String> msg = MessageBuilder.withPayload(payload).setHeader("speed", r.nextInt(8) * 10).build();
        mySource.fastpassToll().send(msg);
        return "success";
    }
}
