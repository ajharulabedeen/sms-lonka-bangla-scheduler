package com.lonkabangla.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.persistence.EntityManager;

@SpringBootApplication
@EnableScheduling
public class SchedulerApplication {

    @Autowired
    private EntityManager entityManager;

    public static void main(String[] args) {
        System.out.println("SchedulerApplication.main");
        SpringApplication.run(SchedulerApplication.class, args);
    }

}
