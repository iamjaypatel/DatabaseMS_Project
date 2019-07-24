/**
 * BDBenchmark.java
 * Phase 3 of Database Management Systems[CS 1555]
 * Please run on empty database, with the schema and any trigger(s) set up.
 * Make sure to change the username and password in Line No 16 to connect to database.
 *
 * @author Jay Patel and Kevin Zinn
 */

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class BCBenchmark {
    private static BoutiqueCoffee db;

    public static void main(String[] args) {
        long startTime, endTime, calcTime;
        try {
            db = new BoutiqueCoffee("postgres", "1");
        } catch (Exception e) {
            System.out.println("Connection Failed");
            System.out.println(e.getMessage());
            System.exit(-1);
        }

        db.setErrorLogger(s -> System.err.println(s));

        // Stress Test Methods and Time them.

        startTime = System.currentTimeMillis();
        stressTest_getCoffees();
        endTime = System.currentTimeMillis();
        calcTime = endTime - startTime;
        System.out.println("Execution time for getCoffees(): " + calcTime + " ms.");

        startTime = System.currentTimeMillis();
        stressTest_getCoffeesByKeyword();
        endTime = System.currentTimeMillis();
        calcTime = endTime - startTime;
        System.out.println("Execution time for getCoffeesByKeyword(): " + calcTime + " ms.");

        startTime = System.currentTimeMillis();
        stressTest_getPointsByCustomerId();
        endTime = System.currentTimeMillis();
        calcTime = endTime - startTime;
        System.out.println("Execution time for getPointsByCustomerId(): " + calcTime + " ms.");

        startTime = System.currentTimeMillis();
        stressTest_addCoffee();
        endTime = System.currentTimeMillis();
        calcTime = endTime - startTime;
        System.out.println("Execution time for addCoffee(): " + calcTime + " ms.");

        startTime = System.currentTimeMillis();
        stressTest_addMemberLevel();
        endTime = System.currentTimeMillis();
        calcTime = endTime - startTime;
        System.out.println("Execution time for addMemberLevel(): " + calcTime + " ms.");

        startTime = System.currentTimeMillis();
        stressTest_addStore();
        endTime = System.currentTimeMillis();
        calcTime = endTime - startTime;
        System.out.println("Execution time for addStore(): " + calcTime + " ms.");

        startTime = System.currentTimeMillis();
        stressTest_offerCoffee();
        endTime = System.currentTimeMillis();
        calcTime = endTime - startTime;
        System.out.println("Execution time for offerCoffee(): " + calcTime + " ms.");

        startTime = System.currentTimeMillis();
        stressTest_addCustomer();
        endTime = System.currentTimeMillis();
        calcTime = endTime - startTime;
        System.out.println("Execution time for addCustomer(): " + calcTime + " ms.");

        startTime = System.currentTimeMillis();
        stressTest_addPromotion();
        endTime = System.currentTimeMillis();
        calcTime = endTime - startTime;
        System.out.println("Execution time for addPromotion(): " + calcTime + " ms.");

        startTime = System.currentTimeMillis();
        stressTest_promoteFor();
        endTime = System.currentTimeMillis();
        calcTime = endTime - startTime;
        System.out.println("Execution time for promoteFor(): " + calcTime + " ms.");

        startTime = System.currentTimeMillis();
        stressTest_hasPromotion();
        endTime = System.currentTimeMillis();
        calcTime = endTime - startTime;
        System.out.println("Execution time for hasPromotion(): " + calcTime + " ms.");

        startTime = System.currentTimeMillis();
        stressTest_addPurchase();
        endTime = System.currentTimeMillis();
        calcTime = endTime - startTime;
        System.out.println("Execution time for addPurchase(): " + calcTime + " ms.");

        startTime = System.currentTimeMillis();
        stressTest_topStores();
        endTime = System.currentTimeMillis();
        calcTime = endTime - startTime;
        System.out.println("Execution time for topStores(): " + calcTime + " ms.");

        startTime = System.currentTimeMillis();
        stressTest_topCustomers();
        endTime = System.currentTimeMillis();
        calcTime = endTime - startTime;
        System.out.println("Execution time for topCustomers(): " + calcTime + " ms.");


    }

    private static void stressTest_getCoffees() {
        System.out.println("\n--- GET COFFEES 1000 INSERTS ---");
        //TODO

    }

    private static void stressTest_getCoffeesByKeyword() {
        System.out.println("\n--- GET COFFEES BY KEYWORD ---");
        //TODO

    }

    private static void stressTest_getPointsByCustomerId() {
        System.out.println("\n--- GET POINTS BY CUSTOMER ID ---");
        //TODO
        for (int i = 1; i < 1001; i++) {
            db.getPointsByCustomerId(i);
        }
    }

    private static void stressTest_addCoffee() {
        System.out.println("\n--- ADD COFFEE 1000 Inserts ---");
        for (int i = 0; i < 1000; i++) {
            db.addCoffee("Coffee Name", "Description", 11, 7.79, 80, 100);
        }
    }

    private static void stressTest_addCustomer() {
        System.out.println("\n--- ADD CUSTOMER 1000 Inserts ---");
        int[] ml = new int[1001];
        double[] pts = new double[1001];
        for (int i = 1; i < 1001; i++) {
            ml[i] = i;
        }
        for (int j = 1; j < 1001; j++) {
            pts[j] = j + 99;
        }
        for (int k = 1; k < 1001; k++) {
            db.addCustomer("FN " + k, "LN " + k, "FN.LN" + k + "@gmail.com", ml[k], pts[k]);
        }

    }

    private static void stressTest_addMemberLevel() {
        System.out.println("\n--- ADD MEMBER LEVEL 1000 Inserts ---");
        for (int i = 1; i < 1001; i++) {
            db.addMemberLevel("MemberLevel " + i, i * 2);
        }
    }

    private static void stressTest_addStore() {
        System.out.println("\n--- ADD STORE 1000 Inserts ---");
        for (int i = 0; i < 1000; i++) {
            db.addStore("Store " + i, "Address Store " + i, "Store Type", i * 4.12, i * 2.25);
        }
    }

    private static void stressTest_hasPromotion() {
        System.out.println("\n--- HAS PROMOTION 1000 INSERTS ---");
        for (int i = 1; i < 1001; i++) {
            db.hasPromotion(i, i);
        }

    }

    private static void stressTest_promoteFor() {
        System.out.println("\n--- PROMOTE FOR 1000 INSERTS ---");
        for (int i = 1; i < 1001; i++) {
            db.promoteFor(i, i);
        }
    }

    private static void stressTest_addPromotion() {
        System.out.println("\n--- ADD PROMOTION 1000 INSERTS ---");
        Date start = Date.valueOf("2019-07-01");
        Date end = Date.valueOf("2019-07-28");
        for (int i = 1; i < 1001; i++) {
            db.addPromotion("Promotion " + i, start, end);
        }

    }

    private static void stressTest_offerCoffee() {
        System.out.println("\n--- OFFER COFFEE 1000 INSERTS ---");
        for (int i = 1; i < 1001; i++) {
            db.offerCoffee(i, i);
        }

    }

    private static void stressTest_addPurchase() {
        System.out.println("\n--- ADD PURCHASE 1000 INSERTS ---");

        Date d = Date.valueOf("2019-07-20");

        for (int j = 1; j < 1001; j++) {
            List<Integer> coffees = new ArrayList<Integer>(1);
            List<Integer> purchased = new ArrayList<Integer>(1);
            List<Integer> redeemed = new ArrayList<Integer>(1);

            purchased.add(j);
            coffees.add(j);
            redeemed.add(j / 100);
            db.addPurchase(j, j, d, coffees, purchased, redeemed);
        }

    }

    private static void stressTest_topStores() {
        System.out.println("\n--- TOP SCORES ---");
        //TODO

    }

    private static void stressTest_topCustomers() {
        System.out.println("\n--- TOP CUSTOMERS ---");
        //TODO

    }
}
