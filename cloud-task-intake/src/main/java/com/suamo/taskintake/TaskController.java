package com.suamo.taskintake;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {

    private final TaskProcessor processor;

    public TaskController(TaskProcessor processor) {
        this.processor = processor;
    }

    @PostMapping("/tasks")
    public String launchTask(@RequestBody String payload) {
        processor.publishRequest(payload);
        System.out.println("request made");
        return "success";
    }

}
