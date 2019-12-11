package com.suamo.taskintake;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {

    @Autowired
    private TaskProcessor processor;

    @PostMapping("/tasks")
    public String launchTask(@RequestBody String payload) {
        processor.publishRequest(payload);
        System.out.println("request made");
        return "success";
    }

}
