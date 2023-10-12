package com.lonkabangla.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@SpringBootApplication
@EnableScheduling
@Transactional
public class SchedulerApplication {

    @Value("${scheduled.time}")
    private static String scheduledTime;

    public static void main(String[] args) {
        System.out.println(" Dashboard SchedulerApplication.main");
        System.out.println("scheduledTime = " + scheduledTime);
        SpringApplication.run(SchedulerApplication.class, args);
    }

}
