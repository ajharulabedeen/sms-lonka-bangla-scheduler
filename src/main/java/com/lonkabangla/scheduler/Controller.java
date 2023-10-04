package com.lonkabangla.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    FetchDataFromCBS fetchDataFromCBS;

    @GetMapping(value = "tdr")
    public String tdr() {
        fetchDataFromCBS.fetchTDR();
        return "TDR";
    }

    @GetMapping(value = "dps")
    public String dps() {
        fetchDataFromCBS.fetchDPS();
        return "DPS";
    }

    @GetMapping(value = "collection")
    public String collection() {
        fetchDataFromCBS.fetchCollectionData();
        return "COLLECTION";
    }

}
