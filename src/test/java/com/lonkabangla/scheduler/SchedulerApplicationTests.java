package com.lonkabangla.scheduler;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@SpringBootTest
class SchedulerApplicationTests {


    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    FetchDataFromCBS fetchDataFromCBS;

    //    @Test
    @Transactional
    void contextLoads() {
        System.out.println("entityManager = " + entityManager);
        deleteEmp();
    }

    @Test
    @Transactional
    public void testCollectionDate() {
        System.out.println("SchedulerApplicationTests.tesFetchTDR");
        fetchDataFromCBS.fetchCollectionData();
    }


    @Test
    @Transactional
    public void tesFetchTDR() {
        System.out.println("SchedulerApplicationTests.tesFetchTDR");
        fetchDataFromCBS.fetchTDR();
    }

    @Test
    @Transactional
    public void tesFetchDPS() {
        System.out.println("SchedulerApplicationTests.tesFetchDPS");
        fetchDataFromCBS.fetchDPS();
    }

    public void deleteEmp() {
        String nativeSqlQuery = "DROP TABLE C##LBF_DASHBOARD.EMP107_";

        int updatedRows = entityManager.createNativeQuery(nativeSqlQuery)
                .executeUpdate();
    }

}
