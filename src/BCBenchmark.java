public class BCBenchmark {
    private static BoutiqueCoffee db;

    public static void main(String[] args) {
        try { // Please change the Username and Password to access your Database.
            db = new BoutiqueCoffee("postgres", "1");
        } catch (Exception e) {
            System.out.println("Connection Failed");
            System.out.println(e.getMessage());
            System.exit(-1);
        }

        db.setErrorLogger(s -> System.err.println(s));

        // Stress Test Methods
        stressTest_getCoffees();
        stressTest_getCoffeesByKeyword();
        stressTest_getPointsByCustomerId();

        stressTest_addCoffee();
        stressTest_addPromotion();
        stressTest_addPurchase();
        stressTest_addMemberLevel();
        stressTest_addCustomer();
        stressTest_addStore();

        stressTest_promoteFor();
        stressTest_hasPromotion();
        stressTest_offerCoffee();

        stressTest_topStores();
        stressTest_topCustomers();

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
