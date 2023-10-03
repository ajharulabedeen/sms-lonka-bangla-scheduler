package com.lonkabangla.scheduler;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class EachMinuteScheduledTask {

    // This method will be executed every minute
    @Scheduled(cron = "0 * * * * ?")
    public void runTask() {
        // Define the task you want to perform here
        System.out.println("Scheduled task is Every Minute: ");
    }
}
