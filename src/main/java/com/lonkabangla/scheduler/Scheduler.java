package com.lonkabangla.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class Scheduler {


    @Autowired
    FetchDataFromCBS fetchDataFromCBS;

//    every day 10:30 am
    @Scheduled(cron = "0 30 10 * * ?")
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