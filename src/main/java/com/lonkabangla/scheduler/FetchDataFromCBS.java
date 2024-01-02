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
        String fetchCollection_test = " INSERT INTO DBLINK_LOAN_OVERDUE_COLLECTIONS_TEMP " +
                " ( " +
                "    collection_id, " +
                "    ACCOUNT_NO, " +
                "    ACCOUNT_TITLE, " +
                "    FACILITY_AMOUNT, " +
                "    INTEREST_RATE, " +
                "    INSTALLMENT_AMOUNT, " +
                "    URPA, " +
                "    TOTAL_EMI_DUE, " +
                "    TOTAL_EMI_PAID, " +
                "    MOD, " +
                "    OVERDUE_AMOUNT, " +
                "    CL_STATUS, " +
                "    PAYMENT_DATE, " +
                "    LAST_COLLECTION_AMOUNT, " +
                "    DISBURSEMENT_DT, " +
                "    DISBURSEMENT_AMOUNT, " +
                "    NEXT_INSTALL_DUE_DT, " +
                "    RO_ID, " +
                "    RO_NAME, " +
                "    RM_ID, " +
                "    RM_NAME, " +
                "    ACC_STATUS, " +
                "    PRODUCT_NM, " +
                "    PRODUCT_ID, " +
                "    LON_DEPT_ID, " +
                "    BR_TXN_DT, " +
                "    FETCH_DATE " +
                ") " +
                " SELECT " +
                "    dblink_seq.NEXTVAL, " +
                "    ACCOUNT_NO, " +
                "    ACCOUNT_TITLE, " +
                "    FACILITY_AMOUNT, " +
                "    INTEREST_RATE, " +
                "    INSTALLMENT_AMOUNT, " +
                "    URPA, " +
                "    TOTAL_EMI_DUE, " +
                "    TOTAL_EMI_PAID, " +
                "    MOD, " +
                "    OVERDUE_AMOUNT, " +
                "    CL_STATUS, " +
                "    PAYMENT_DATE, " +
                "    LAST_COLLECTION_AMOUNT, " +
                "    DISBURSEMENT_DT, " +
                "    DISBURSEMENT_AMOUNT, " +
                "    NEXT_INSTALL_DUE_DT, " +
                "    RO_ID, " +
                "    RO_NAME, " +
                "    RM_ID, " +
                "    RM_NAME, " +
                "    ACC_STATUS, " +
                "    PRODUCT_NM, " +
                "    PRODUCT_ID, " +
                "    LON_DEPT_ID, " +
                "    BR_TXN_DT, " +
                "    SYSDATE AS FETCH_DATE " +
                "FROM ultimus.VW_Dashboard_Loan_Overdue_Collections@dashboardDBLINK1 t " +
                "WHERE t.lon_dept_id = 4 ";

        String fetchCollection = "INSERT INTO DBLINK_LOAN_OVERDUE_COLLECTIONS " +
                "( " +
                "    collection_id, " +
                "    ACCOUNT_NO, " +
                "    ACCOUNT_TITLE, " +
                "    FACILITY_AMOUNT, " +
                "    INTEREST_RATE, " +
                "    INSTALLMENT_AMOUNT, " +
                "    URPA, " +
                "    TOTAL_EMI_DUE, " +
                "    TOTAL_EMI_PAID, " +
                "    MOD, " +
                "    OVERDUE_AMOUNT, " +
                "    CL_STATUS, " +
                "    PAYMENT_DATE, " +
                "    LAST_COLLECTION_AMOUNT, " +
                "    DISBURSEMENT_DT, " +
                "    DISBURSEMENT_AMOUNT, " +
                "    NEXT_INSTALL_DUE_DT, " +
                "    RO_ID, " +
                "    RO_NAME, " +
                "    RM_ID, " +
                "    RM_NAME, " +
                "    ACC_STATUS, " +
                "    PRODUCT_NM, " +
                "    PRODUCT_ID, " +
                "    LON_DEPT_ID, " +
                "    BR_TXN_DT, " +
                "    FETCH_DATE, " +
                "    PERIOD, " +
                "    INSTALL_FIRST_DUE_DT, " +
                "    EXPIRY_DT " +
                ")SELECT " +
                "    dblink_seq.NEXTVAL, " +
                "    ACCOUNT_NO, " +
                "    ACCOUNT_TITLE, " +
                "    FACILITY_AMOUNT, " +
                "    INTEREST_RATE, " +
                "    INSTALLMENT_AMOUNT, " +
                "    URPA, " +
                "    TOTAL_EMI_DUE, " +
                "    TOTAL_EMI_PAID, " +
                "    MOD, " +
                "    OVERDUE_AMOUNT, " +
                "    CL_STATUS, " +
                "    PAYMENT_DATE, " +
                "    LAST_COLLECTION_AMOUNT, " +
                "    DISBURSEMENT_DT, " +
                "    DISBURSEMENT_AMOUNT, " +
                "    NEXT_INSTALL_DUE_DT, " +
                "    RO_ID, " +
                "    RO_NAME, " +
                "    RM_ID, " +
                "    RM_NAME, " +
                "    ACC_STATUS, " +
                "    PRODUCT_NM, " +
                "    PRODUCT_ID, " +
                "    LON_DEPT_ID, " +
                "    BR_TXN_DT, " +
                "    SYSDATE AS FETCH_DATE, " +
                "    PERIOD, " +
                "    INSTALL_FIRST_DUE_DT, " +
                "    EXPIRY_DT " +
                "FROM ultimus.VW_Dashboard_Loan_Overdue_Collections@dashboardDBLINK1 t " +
                "WHERE t.lon_dept_id = 4 ";


        logger.info("\nCollection:");
        try {
            int executeUpdate = entityManager.createNativeQuery(fetchCollection)
                    .executeUpdate();
            if (executeUpdate > 0) {
                logger.info(" Colelction Data Fetch Success! Total Fetched: {}", executeUpdate);
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
        String fetchDPS_test = " INSERT INTO DBLINK_DPS_TEMP (AC_NO, " +
                "                        ACC_TITLE, " +
                "                        MONTHLY_DPS_AMOUNT, " +
                "                        INTEREST_RATE, " +
                "                        PERIOD, " +
                "                        ACC_OPEN_DT, " +
                "                        ACC_RENEWAL_DT, " +
                "                        ACC_MATURITY_DT, " +
                "                        RENEWAL_REMAIN, " +
                "                        COLLECTION_DATE, " +
                "                        RO_ID, " +
                "                        RO_NAME, " +
                "                        RM_ID, " +
                "                        RM_NAME, " +
                "                        PMO_ID, " +
                "                        PMO_NAME, " +
                "                        PRINCIPAL_AMT, " +
                "                        MATURED_AMOUNT, " +
                "                        ACC_STATUS_NM, " +
                "                        PRODUCT_ID, " +
                "                        PRODUCTNAME, " +
                "                        BR_TXN_DT, " +
                "                        FETCH_DATE, " +
                "                        DPS_ID) " +
                "SELECT AC_NO, " +
                "       ACC_TITLE, " +
                "       MONTHLY_DPS_AMOUNT, " +
                "       INTEREST_RATE, " +
                "       PERIOD, " +
                "       ACC_OPEN_DT, " +
                "       ACC_RENEWAL_DT, " +
                "       ACC_MATURITY_DT, " +
                "       RENEWAL_REMAIN, " +
                "       COLLECTION_DATE, " +
                "       RO_ID, " +
                "       RO_NAME, " +
                "       RM_ID, " +
                "       RM_NAME, " +
                "       PMO_ID, " +
                "       PMO_NAME, " +
                "       PRINCIPAL_AMT, " +
                "       MATURED_AMOUNT, " +
                "       ACC_STATUS_NM, " +
                "       PRODUCT_ID, " +
                "       PRODUCTNAME, " +
                "       BR_TXN_DT, " +
                "       SYSDATE AS FETCH_DATE, " +
                "       dblink_seq.NEXTVAL ";

        String fetchDPS = " INSERT INTO DBLINK_DPS (AC_NO, " +
                "                        ACC_TITLE, " +
                "                        MONTHLY_DPS_AMOUNT, " +
                "                        INTEREST_RATE, " +
                "                        PERIOD, " +
                "                        ACC_OPEN_DT, " +
                "                        ACC_RENEWAL_DT, " +
                "                        ACC_MATURITY_DT, " +
                "                        RENEWAL_REMAIN, " +
                "                        COLLECTION_DATE, " +
                "                        RO_ID, " +
                "                        RO_NAME, " +
                "                        RM_ID, " +
                "                        RM_NAME, " +
                "                        PMO_ID, " +
                "                        PMO_NAME, " +
                "                        PRINCIPAL_AMT, " +
                "                        MATURED_AMOUNT, " +
                "                        ACC_STATUS_NM, " +
                "                        PRODUCT_ID, " +
                "                        PRODUCTNAME, " +
                "                        BR_TXN_DT, " +
                "                        FETCH_DATE, " +
                "                        DPS_ID) " +
                "SELECT AC_NO, " +
                "       ACC_TITLE, " +
                "       MONTHLY_DPS_AMOUNT, " +
                "       INTEREST_RATE, " +
                "       PERIOD, " +
                "       ACC_OPEN_DT, " +
                "       ACC_RENEWAL_DT, " +
                "       ACC_MATURITY_DT, " +
                "       RENEWAL_REMAIN, " +
                "       COLLECTION_DATE, " +
                "       RO_ID, " +
                "       RO_NAME, " +
                "       RM_ID, " +
                "       RM_NAME, " +
                "       PMO_ID, " +
                "       PMO_NAME, " +
                "       PRINCIPAL_AMT, " +
                "       MATURED_AMOUNT, " +
                "       ACC_STATUS_NM, " +
                "       PRODUCT_ID, " +
                "       PRODUCTNAME, " +
                "       BR_TXN_DT, " +
                "       SYSDATE AS FETCH_DATE, " +
                "       dblink_seq.NEXTVAL " +
                "FROM ultimus.VW_DASHBOARD_DPS_AC@dashboardDBLINK1 t ";

        logger.info("\nDPS:");
        try {
            int executeUpdate = entityManager.createNativeQuery(fetchDPS)
                    .executeUpdate();
            if (executeUpdate > 0) {
                logger.info(" DPS Data Fetch Success! Number of Row Fetched: {}", executeUpdate);
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
        String fetchTDR_test = " INSERT INTO DBLINK_TDR_TEMP ( " +
                "    AC_NO, " +
                "    ACC_TITLE, " +
                "    INTEREST_RATE, " +
                "    PERIOD, " +
                "    TDR_AMOUNT, " +
                "    MATURED_AMOUNT, " +
                "    ACC_OPEN_DT, " +
                "    ACC_RENEWAL_DT, " +
                "    MATURITY_DT, " +
                "    RENEWAL_REMAIN, " +
                "    RO_ID, " +
                "    RO_NAME, " +
                "    RM_ID, " +
                "    RM_NAME, " +
                "    PMO_ID, " +
                "    PMO_NAME, " +
                "    ACC_STATUS_NM, " +
                "    PRODUCT_ID, " +
                "    PRODUCTNAME, " +
                "    BR_TXN_DT, " +
                "    FETCH_DATE, " +
                "    TDR_ID " +
                ") " +
                "SELECT " +
                "    AC_NO, " +
                "    ACC_TITLE, " +
                "    INTEREST_RATE, " +
                "    PERIOD, " +
                "    TDR_AMOUNT, " +
                "    MATURED_AMOUNT, " +
                "    ACC_OPEN_DT, " +
                "    ACC_RENEWAL_DT, " +
                "    MATURITY_DT, " +
                "    RENEWAL_REMAIN, " +
                "    RO_ID, " +
                "    RO_NAME, " +
                "    RM_ID, " +
                "    RM_NAME, " +
                "    PMO_ID, " +
                "    PMO_NAME, " +
                "    ACC_STATUS_NM, " +
                "    PRODUCT_ID, " +
                "    PRODUCTNAME, " +
                "    BR_TXN_DT, " +
                "    SYSDATE, " +
                "    dblink_seq.NEXTVAL " +
                "FROM ultimus.VW_DASHBOARD_TDR_AC@dashboardDBLINK1 t ";


        String fetchTDR = " INSERT INTO DBLINK_TDR ( " +
                "    AC_NO, " +
                "    ACC_TITLE, " +
                "    INTEREST_RATE, " +
                "    PERIOD, " +
                "    TDR_AMOUNT, " +
                "    MATURED_AMOUNT, " +
                "    ACC_OPEN_DT, " +
                "    ACC_RENEWAL_DT, " +
                "    MATURITY_DT, " +
                "    RENEWAL_REMAIN, " +
                "    RO_ID, " +
                "    RO_NAME, " +
                "    RM_ID, " +
                "    RM_NAME, " +
                "    PMO_ID, " +
                "    PMO_NAME, " +
                "    ACC_STATUS_NM, " +
                "    PRODUCT_ID, " +
                "    PRODUCTNAME, " +
                "    BR_TXN_DT, " +
                "    FETCH_DATE, " +
                "    TDR_ID " +
                ") " +
                "SELECT " +
                "    AC_NO, " +
                "    ACC_TITLE, " +
                "    INTEREST_RATE, " +
                "    PERIOD, " +
                "    TDR_AMOUNT, " +
                "    MATURED_AMOUNT, " +
                "    ACC_OPEN_DT, " +
                "    ACC_RENEWAL_DT, " +
                "    MATURITY_DT, " +
                "    RENEWAL_REMAIN, " +
                "    RO_ID, " +
                "    RO_NAME, " +
                "    RM_ID, " +
                "    RM_NAME, " +
                "    PMO_ID, " +
                "    PMO_NAME, " +
                "    ACC_STATUS_NM, " +
                "    PRODUCT_ID, " +
                "    PRODUCTNAME, " +
                "    BR_TXN_DT, " +
                "    SYSDATE, " +
                "    dblink_seq.NEXTVAL " +
                "FROM ultimus.VW_DASHBOARD_TDR_AC@dashboardDBLINK1 t ";


        logger.info("\nTDR");
        try {
            int executeUpdate = entityManager.createNativeQuery(fetchTDR)
                    .executeUpdate();
            System.out.println("executeUpdate = " + executeUpdate);
            if (executeUpdate > 0) {
                logger.info(" TDR Data Fetch Success! Number of Rows Fetched: {} ", executeUpdate );
            } else {
                logger.error(" TDR Data Fetch Failed!");
            }
        } catch (Exception e) {
            logger.error("Error: Fetching TDR Date, please the stack trace below.");
            e.printStackTrace();
        }
    }
}




