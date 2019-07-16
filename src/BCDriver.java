import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class BCDriver {
	// Phase 2 complete

    private static BoutiqueCoffee db;

    public static void main(String[] args) {
        try {
            db = new BoutiqueCoffee("postgres", "1");
        } catch (Exception e) {
            System.out.println("Connection Failed");
            System.out.println(e.getMessage());
            System.exit(-1);
        }

        db.setErrorLogger(s -> System.err.println(s));

        test_getCoffees();
        test_getCoffeesByKeyword();
        test_getPointsByCustomerId();

        test_addCoffee();
        test_addPromotion();
        test_addPurchase();
        test_addMemberLevel();
        test_addCustomer();
        test_addStore();

        test_promoteFor();
        test_hasPromotion();
        test_offerCoffee();

        test_topStores();
        test_topCustomers();
    }

    private static void test_getCoffees() {
        System.out.println("\n--- GET COFFEES ---");
        List<Integer> coffees = db.getCoffees();
        for (int coffee : coffees) {
            System.out.println(coffee);
        }
    }

    private static void test_getCoffeesByKeyword() {
        for (String[] k : new String[][]{{"ice", "coffee"}, {"Ice", "Coffee"}}) {
            System.out.printf("\n--- GET COFFEES CONTAINING '%s' AND '%s'\n", k[0], k[1]);
            List<Integer> coffees = db.getCoffeesByKeywords(k[0], k[1]);
            for (int coffee : coffees) {
                System.out.println(coffee);
            }
        }
    }

    private static void test_getPointsByCustomerId() {
        for (int i : new int[]{1, -15}) {
            System.out.printf("\n--- GET POINTS FOR CUSTOMER %s ---\n", i);
            double pts = db.getPointsByCustomerId(i);
            System.out.println(pts);
        }
    }

    private static void test_addCoffee() {
        System.out.println("\n--- ADD COFFEE 'Ultra Dark Roast'");
        int id = db.addCoffee("Ultra Dark Roast", "Extra Black", 11, 7.79, 80, 100);
        System.out.println(id);
    }

    private static void test_addCustomer() {
        System.out.println("\n--- ADD CUSTOMER Joe Schmoe ---");
        int id = db.addCustomer("Joe", "Schmoe", "joe.schmoe@gmail.com", 1, 0);
        System.out.println(id);
    }

    private static void test_addMemberLevel() {
        System.out.println("\n--- ADD MEMBER LEVEL PLutonium Plus ---");
        int id = db.addMemberLevel("Plutonium Plus", 9000);
        System.out.println(id);
    }

    private static void test_addStore() {
        System.out.println("\n--- ADD STORE ---");
        int id = db.addStore("Craig's Coffee", "100 Washington Ave.", "Standalone", -80.236287, 40.187162);
        System.out.println(id);
    }

    private static void test_hasPromotion() {
        System.out.println("\n--- HAS PROMOTION ---");
        int id = db.hasPromotion(3, 1);
        System.out.println(id);
    }

    private static void test_promoteFor() {
        System.out.println("\n--- PROMOTE FOR ---");
        int id = db.promoteFor(1, 6);
        System.out.println(id);
    }

    private static void test_addPromotion() {
        System.out.println("\n--- ADD PROMOTION 'Double Points'");
        Date start = Date.valueOf("2019-07-01");
        Date end = Date.valueOf("2019-07-28");
        int id = db.addPromotion("Darker is Better", start, end);
        System.out.println(id);
    }

    private static void test_offerCoffee() {
        System.out.println("\n--- OFFER COFFEE ---");
        int id = db.offerCoffee(3, 1);
        System.out.println(id);
    }

    private static void test_addPurchase() {
        System.out.println("\n--- ADD PURCHASE ---");
        Date d = Date.valueOf("2019-05-15");
        List<Integer> coffees = new ArrayList<Integer>(2);
        List<Integer> purchased = new ArrayList<Integer>(2);
        List<Integer> redeemed = new ArrayList<Integer>(2);

        coffees.add(1);
        purchased.add(5);
        redeemed.add(0);

        coffees.add(2);
        purchased.add(25);
        redeemed.add(0);

        int id = db.addPurchase(1, 1, d, coffees, purchased, redeemed);
        System.out.println(id);
    }

    private static void test_topStores() {
        for (int[] args : new int[][]{{1, 1}, {3, 1}, {3, 3}}) {
            System.out.printf("\n--- TOP %d STORES IN PAST %d MONTHS (%d DAYS) ---\n", args[0], args[1], args[1] * 30);
            List<Integer> stores = db.getTopKStoresInPastXMonth(args[0], args[1]);
            for (int store : stores) {
                System.out.println(store);
            }
        }
    }

    private static void test_topCustomers() {
        for (int[] args : new int[][]{{1, 5}, {1, 1}, {10, 1}}) {
            System.out.printf("\n--- TOP %d CUSTOMERS IN PAST %d MONTHS (%d DAYS) ---\n", args[0], args[1], args[1] * 30);
            List<Integer> customers = db.getTopKCustomersInPastXMonth(args[0], args[1]);
            for (int customer : customers) {
                System.out.println(customer);
            }
        }
    }
}
