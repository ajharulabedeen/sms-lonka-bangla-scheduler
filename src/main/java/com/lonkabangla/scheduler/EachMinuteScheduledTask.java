package com.lonkabangla.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * test purpose this class was created, this has no realtime utilization.
 * two the task in evry minute, every two  three min.
 * two run it active the schedule.
 */

@Component
public class EachMinuteScheduledTask {

    @Autowired
    FetchDataFromCBS fetchDataFromCBS;

    // This method will be executed every minute
//    @Scheduled(cron = "0 * * * * ?")
    // This method will be executed every 2 minute
//    @Scheduled(cron = "0 */2 * * * ?")
    public void runTask() {
        // Define the task you want to perform here
        System.out.println("Scheduled task is Every Minute: ");
        fetchDataFromCBS.fetchCollectionData();
        fetchDataFromCBS.fetchDPS();
        fetchDataFromCBS.fetchTDR();
    }
}
