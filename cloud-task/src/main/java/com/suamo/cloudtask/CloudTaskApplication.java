package com.suamo.cloudtask;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableTask
public class CloudTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudTaskApplication.class, args);
    }

    @Bean
    public TollProcessingTask tollProcessingTask() {
        return new TollProcessingTask();
    }

    public static class TollProcessingTask implements CommandLineRunner {
        @Override
        public void run(String... args) throws Exception {
            if (null != args) {
                System.out.println("Parameter length is " + args.length);

                String stationId = args[0];
                String licensePlate = args[1];
                String timestamp = args[2];

                System.out.println(String.format("Station ID is %s, plate is %s, timestamp is %s", stationId, licensePlate, timestamp));
            }
        }
    }

}
