public class BCBenchmark {
    private static BoutiqueCoffee db;

    public static void main(String[] args) {
        long startTime, endTime, calcTime;
        try { // Please change the Username and Password to access your Database.
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
        stressTest_addPromotion();
        endTime = System.currentTimeMillis();
        calcTime = endTime - startTime;
        System.out.println("Execution time for addPromotion(): " + calcTime + " ms.");

        startTime = System.currentTimeMillis();
        stressTest_addPurchase();
        endTime = System.currentTimeMillis();
        calcTime = endTime - startTime;
        System.out.println("Execution time for addPurchase(): " + calcTime + " ms.");

        startTime = System.currentTimeMillis();
        stressTest_addMemberLevel();
        endTime = System.currentTimeMillis();
        calcTime = endTime - startTime;
        System.out.println("Execution time for addMemberLevel(): " + calcTime + " ms.");

        startTime = System.currentTimeMillis();
        stressTest_addCustomer();
        endTime = System.currentTimeMillis();
        calcTime = endTime - startTime;
        System.out.println("Execution time for addCustomer(): " + calcTime + " ms.");

        startTime = System.currentTimeMillis();
        stressTest_addStore();
        endTime = System.currentTimeMillis();
        calcTime = endTime - startTime;
        System.out.println("Execution time for addStore(): " + calcTime + " ms.");

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
        stressTest_offerCoffee();
        endTime = System.currentTimeMillis();
        calcTime = endTime - startTime;
        System.out.println("Execution time for offerCoffee(): " + calcTime + " ms.");

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

    }

    private static void stressTest_getCoffeesByKeyword() {

    }

    private static void stressTest_getPointsByCustomerId() {

    }

    private static void stressTest_addCoffee() {

    }

    private static void stressTest_addCustomer() {

    }

    private static void stressTest_addMemberLevel() {

    }

    private static void stressTest_addStore() {

    }

    private static void stressTest_hasPromotion() {

    }

    private static void stressTest_promoteFor() {

    }

    private static void stressTest_addPromotion() {

    }

    private static void stressTest_offerCoffee() {

    }

    private static void stressTest_addPurchase() {

    }

    private static void stressTest_topStores() {

    }

    private static void stressTest_topCustomers() {

    }
}
