package com.wmrk.demotracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


//@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
@SpringBootApplication
public class DemoTrackerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoTrackerApplication.class, args);
    }

}
