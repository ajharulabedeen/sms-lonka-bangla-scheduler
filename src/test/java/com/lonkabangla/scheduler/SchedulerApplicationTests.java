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

//    @Test
    @Transactional
    void contextLoads() {
        System.out.println("entityManager = " + entityManager);
        deleteEmp();
    }


    public void deleteEmp() {
        String nativeSqlQuery = "DROP TABLE C##LBF_DASHBOARD.EMP107_";

        int updatedRows = entityManager.createNativeQuery(nativeSqlQuery)
                .executeUpdate();
    }

}
