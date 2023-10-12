package com.lonkabangla.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.scheduling.annotation.Scheduled;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class Scheduler {

    @Value("${scheduled.time}")
    private String scheduledTime;

    @Autowired
    FetchDataFromCBS fetchDataFromCBS;

    @Scheduled(cron = "${scheduled.time}")
    public void cronJobSch() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date now = new Date();
        String strDate = sdf.format(now);
        System.out.println("Data Fetch Cord Job :: " + strDate);
        fetchDataFromCBS.fetchCollectionData();
        fetchDataFromCBS.fetchDPS();
        fetchDataFromCBS.fetchTDR();
    }
}