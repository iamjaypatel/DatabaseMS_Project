/**
 * BDBenchmark.java
 * Phase 3 of Database Management Systems[CS 1555]
 * Please run on empty database, with the schema and any trigger(s) set up.
 * Make sure to change the username and password in Line No 16 to connect to database.
 *
 * @author Jay Patel and Kevin Zinn
 */

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class BCBenchmark {
    private static BoutiqueCoffee db;
    private static PrintWriter totals;
    private static PrintWriter avgs;

    public static void main(String[] args) {
        String password = "";
    	if (args.length > 0) {
    		password = args[0];
    	}
    	else
    	{
    		System.out.println("No Password Specified");
    	}        
        try {
            db = new BoutiqueCoffee("postgres", password);
        } catch (Exception e) {
            System.out.println("Connection Failed");
            System.out.println(e.getMessage());
            System.exit(-1);
        }
        
        try{
        	totals = new PrintWriter("totals.dat");
        	avgs = new PrintWriter("averages.dat");
        }catch(Exception e) {
        	System.out.println("Could not create file");
        	System.out.println(e.getMessage());
        	System.exit(-1);
        }
        
        db.setErrorLogger(s -> System.err.println(s));
        
        executeBenchmarks(100);
        executeBenchmarks(1000);
        executeBenchmarks(10000);
        

    	if(totals != null) {
    		totals.flush();
    		totals.close();
    	}
    	if(avgs != null) {
    		avgs.flush();
    		avgs.close();
    	}
    }
    
    public static void executeBenchmarks(int iters) {        
        db.runSqlScript("schema.sql");
        db.runSqlScript("trigger.sql");
        db.runSqlScript("jdbc_procedures.sql");

        // Stress Test Methods and Time them.
        
        totals.write(iters);
        avgs.write(iters);

        benchmark(BCBenchmark::stressTest_addCoffee, iters, "\n--- Benchmarking Add Coffees ---");
        benchmark(BCBenchmark::stressTest_addMemberLevel, iters, "\n--- Benchmarking Add Member Levels ---");
        benchmark(BCBenchmark::stressTest_addStore, iters, "\n--- Benchmarking Add Stores ---");
        benchmark(BCBenchmark::stressTest_offerCoffee, iters, "\n--- Benchmarking Offer Coffees--- ");
        benchmark(BCBenchmark::stressTest_addCustomer, iters, "\n--- Benchmarking Add Customers ---");
        benchmark(BCBenchmark::stressTest_addPromotion, iters, "\n--- Benchmarking Add Promotions ---");
        benchmark(BCBenchmark::stressTest_promoteFor, iters, "\n--- Benchmarking Promote For ---");
        benchmark(BCBenchmark::stressTest_hasPromotion, iters, "\n--- Benchmarking Has Promotion ---");
        benchmark(BCBenchmark::stressTest_addPurchase, iters, "\n--- Benchmarking Add Purchase ---");
        benchmark(BCBenchmark::stressTest_getCoffees, iters, "\n--- Benchmarking Get Coffees ---");
        benchmark(BCBenchmark::stressTest_getCoffeesByKeyword, iters, "\n--- Benchmarking Get Coffees By Keyword ---");
        benchmark(BCBenchmark::stressTest_getPointsByCustomerId, iters, "\n--- Benchmarking Get Points By Customer ID ---");
        benchmark(BCBenchmark::stressTest_topStores, iters, "\n--- Benchmarking Get Top K Stores In Past X Months ---");
        benchmark(BCBenchmark::stressTest_topCustomers, iters, "\n--- Benchmarking Get Top K Customers In Past X Months ---");
        
        totals.write("\n");
        avgs.write("\n");
    }
    
    private static void benchmark(Consumer<Integer> function, int iterations, String message) {
    	System.out.println(message);
        double startTime = System.currentTimeMillis();
        function.accept(iterations);
        double endTime = System.currentTimeMillis();
        double calcTime = endTime - startTime;
        System.out.println("total execution time: " + calcTime + " ms.");
        totals.print("," + calcTime);
        double average = calcTime/iterations;
        avgs.print("," + average);
        System.out.println("average execution time: " + average + " ms.");
    }

    private static void stressTest_getCoffees(int iter) {
        for (int i=0; i < iter; i++) {
        	db.getCoffees();
        }
    }

    private static void stressTest_getCoffeesByKeyword(int iter) {
        for (int i=0; i < iter; i++) {
        	db.getCoffeesByKeywords("Coffee", ""+i);
        }
    }

    private static void stressTest_getPointsByCustomerId(int iter) {
        for (int i = 1; i <= iter; i++) {
            db.getPointsByCustomerId(i);
        }
    }

    private static void stressTest_addCoffee(int iter) {
        for (int i = 0; i < iter; i++) {
            db.addCoffee("Coffee " + i, "Description", 11, 7.79, 80, 100);
        }
    }

    private static void stressTest_addCustomer(int iter) {
        int[] ml = new int[iter + 1];
        double[] pts = new double[iter + 1];
        for (int i = 1; i <= iter; i++) {
            ml[i] = i;
        }
        for (int j = 1; j <= iter; j++) {
            pts[j] = j + 99;
        }
        for (int k = 1; k <= iter; k++) {
            db.addCustomer("FN " + k, "LN " + k, "FN.LN" + k + "@gmail.com", ml[k], pts[k]);
        }

    }

    private static void stressTest_addMemberLevel(int iter) {
        for (int i = 1; i <= iter; i++) {
            db.addMemberLevel("MemberLevel " + i, i * 2);
        }
    }

    private static void stressTest_addStore(int iter) {
        for (int i = 0; i < iter; i++) {
            db.addStore("Store " + i, "Address Store " + i, "Store Type", i * 4.12, i * 2.25);
        }
    }

    private static void stressTest_hasPromotion(int iter) {
        for (int i = 1; i <= iter; i++) {
            db.hasPromotion(i, i);
        }

    }

    private static void stressTest_promoteFor(int iter) {
        for (int i = 1; i <= iter; i++) {
            db.promoteFor(i, i);
        }
    }

    private static void stressTest_addPromotion(int iter) {
        Date start = Date.valueOf("2019-07-01");
        Date end = Date.valueOf("2019-07-28");
        for (int i = 1; i <= iter; i++) {
            db.addPromotion("Promotion " + i, start, end);
        }

    }

    private static void stressTest_offerCoffee(int iter) {
        for (int i = 1; i <= iter; i++) {
            db.offerCoffee(i, i);
        }

    }

    private static void stressTest_addPurchase(int iter) {

        Date d = Date.valueOf("2019-01-20");

        for (int j = 1; j <= iter; j++) {
            List<Integer> coffees = new ArrayList<Integer>(1);
            List<Integer> purchased = new ArrayList<Integer>(1);
            List<Integer> redeemed = new ArrayList<Integer>(1);

            purchased.add(j);
            coffees.add(j);
            redeemed.add(j / 100);
            d.setMonth((j % 12) + 1);
            db.addPurchase(j, j, d, coffees, purchased, redeemed);
        }

    }

    private static void stressTest_topStores(int iter) {
        for(int i = 1; i <= iter; i++) {
        	db.getTopKStoresInPastXMonth(i, (i % 12) + 1);
        }

    }

    private static void stressTest_topCustomers(int iter) {
        for(int i = 1; i <= iter; i++) {
        	db.getTopKCustomersInPastXMonth(i, (i % 12) + 1);
        }
    }
}
