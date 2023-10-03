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

    public void fetchCollectionData() {
        String fetchCollection = "INSERT INTO DBLINK_LOAN_OVERDUE_COLLECTIONS_ SELECT * FROM ultimus.VW_Dashboard_Loan_Overdue_Collections@dashboardDBLINK1 t WHERE t.lon_dept_id = 4;\n";

        try {
            entityManager.getTransaction().begin();
            int executeUpdate = entityManager.createNativeQuery(fetchCollection)
                    .executeUpdate();
            if (executeUpdate > 0) {
                logger.info(" Colelction Data Fetch Success!");
            } else {
                logger.error(" Colelction Data Fetch Failed!");
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            logger.error(e.getStackTrace().toString());
        }
    }

    public void fetchDPS() {
        String fetchDPS = "INSERT INTO DBLINK_DPS_ select * from ultimus.VW_DASHBOARD_DPS_AC@dashboardDBLINK1 t where t.RO_ID = '1180101525' or t.RM_ID = '1180101525'";

        try {
            entityManager.getTransaction().begin();
            int executeUpdate = entityManager.createNativeQuery(fetchDPS)
                    .executeUpdate();
            if (executeUpdate > 0) {
                logger.info(" DPS Data Fetch Success!");
            } else {
                logger.error(" DPS Data Fetch Failed!");
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            logger.error(e.getStackTrace().toString());
        }
    }


    public void fetchTDR() {
        String fetchDPS = "INSERT INTO DBLINK_TDR_ select * from ultimus.VW_DASHBOARD_TDR_AC@dashboardDBLINK1 t where t.RO_ID = '1180101525' or t.RM_ID = '1180101525'";

        try {
            entityManager.getTransaction().begin();
            int executeUpdate = entityManager.createNativeQuery(fetchDPS)
                    .executeUpdate();
            if (executeUpdate > 0) {
                logger.info(" TDR Data Fetch Success!");
            } else {
                logger.error(" TDR Data Fetch Failed!");
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            logger.error(e.getStackTrace().toString());
        }
    }
}




