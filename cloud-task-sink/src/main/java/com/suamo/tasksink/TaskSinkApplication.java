package com.suamo.tasksink;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.launcher.annotation.EnableTaskLauncher;

// here spring boot will know how to hook this up to Cloud Bus (message bus in RabbitMQ)
// Deployer will be used to pull the right task
@EnableTaskLauncher
@SpringBootApplication
public class TaskSinkApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskSinkApplication.class, args);
	}

}
