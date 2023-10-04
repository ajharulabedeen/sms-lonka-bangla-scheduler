package com.lonkabangla.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
@Slf4j
public class FetchDataFromCBS {

    private final Logger logger = LoggerFactory.getLogger(FetchDataFromCBS.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void fetchCollectionData() {
        String fetchCollection_test = " INSERT INTO DBLINK_LOAN_OVERDUE_COLLECTIONS_ SELECT * FROM ultimus.VW_Dashboard_Loan_Overdue_Collections@dashboardDBLINK1 t WHERE t.lon_dept_id = 4 ";
        String fetchCollection = " INSERT INTO DBLINK_LOAN_OVERDUE_COLLECTIONS SELECT * FROM ultimus.VW_Dashboard_Loan_Overdue_Collections@dashboardDBLINK1 t WHERE t.lon_dept_id = 4 ";
        logger.info("\nCollection");
        try {
            int executeUpdate = entityManager.createNativeQuery(fetchCollection)
                    .executeUpdate();
            if (executeUpdate > 0) {
                logger.info(" Colelction Data Fetch Success!");
            } else {
                logger.error(" Colelction Data Fetch Failed!");
            }
        } catch (Exception e) {
            logger.error("Error: Fetching Collection Date, please the stack trace below.");
            e.printStackTrace();
        }
    }

    @Transactional
    public void fetchDPS() {
        String fetchDPS_test = "INSERT INTO DBLINK_DPS_ select * from ultimus.VW_DASHBOARD_DPS_AC@dashboardDBLINK1 t where t.RO_ID = '1180101525' or t.RM_ID = '1180101525'";
        String fetchDPS = "INSERT INTO DBLINK_DPS select * from ultimus.VW_DASHBOARD_DPS_AC@dashboardDBLINK1 t where t.RO_ID = '1180101525' or t.RM_ID = '1180101525'";
        logger.info("\nDPS");
        try {
            int executeUpdate = entityManager.createNativeQuery(fetchDPS)
                    .executeUpdate();
            if (executeUpdate > 0) {
                logger.info(" DPS Data Fetch Success!");
            } else {
                logger.error(" DPS Data Fetch Failed!");
            }
        } catch (Exception e) {
            logger.error("Error: Fetching DPS Date, please the stack trace below.");
            e.printStackTrace();
        }
    }


    @Transactional
    public void fetchTDR() {
        String fetchDPS_test = "INSERT INTO DBLINK_TDR_ select * from ultimus.VW_DASHBOARD_TDR_AC@dashboardDBLINK1 t where t.RO_ID = '1180101525' or t.RM_ID = '1180101525'";
        String fetchDPS = "INSERT INTO DBLINK_TDR select * from ultimus.VW_DASHBOARD_TDR_AC@dashboardDBLINK1 t where t.RO_ID = '1180101525' or t.RM_ID = '1180101525'";
        logger.info("\nTDR");
        try {
            int executeUpdate = entityManager.createNativeQuery(fetchDPS)
                    .executeUpdate();
            System.out.println("executeUpdate = " + executeUpdate);
            if (executeUpdate > 0) {
                logger.info(" TDR Data Fetch Success!");
            } else {
                logger.error(" TDR Data Fetch Failed!");
            }
        } catch (Exception e) {
            logger.error("Error: Fetching TDR Date, please the stack trace below.");
            e.printStackTrace();
        }
    }
}




