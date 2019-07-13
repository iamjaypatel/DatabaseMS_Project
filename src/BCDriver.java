import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class BCDriver {

	private static BoutiqueCoffee db;
	
	public static void main(String[] args) {		
		try {
			db = new BoutiqueCoffee("postgres", "postgres");
		} catch (Exception e) {
			System.out.println("Connection Failed");
			System.out.println(e.getMessage());
		}
		
		db.setErrorLogger(s -> System.err.println(s));
		
		test_getCoffees();
		test_getCoffeesByKeyword();
		test_getPointsByCustomerId();
		
		test_addCoffee();
		test_addPromotion();
		test_addPurchase();
		
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
		for(String[] k : new String[][] {{"ice", "coffee"}, {"Ice", "Coffee"}}) {
			System.out.printf("\n--- GET COFFEES CONTAINING '%s' AND '%s'\n", k[0], k[1]);
			List<Integer> coffees = db.getCoffeesByKeywords(k[0], k[1]);
			for(int coffee : coffees) {
				System.out.println(coffee);
			}
		}
	}
	
	private static void test_getPointsByCustomerId() {
		for(int i : new int[] {1, -15}) {
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
	
	private static void test_addPromotion() {
		System.out.println("\n--- ADD PROMOTION 'Double Points'");
		Date start = Date.valueOf("2019-07-01");
		Date end = Date.valueOf("2019-07-28");
		int id = db.addPromotion("Darker is Better", start, end);
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
		for(int[] args : new int[][] {{1, 1}, {3, 1}, {3, 3}}) {
			System.out.printf("\n--- TOP %d STORES IN PAST %d MONTHS (%d DAYS) ---\n", args[0], args[1], args[1] * 30);
			List<Integer> stores = db.getTopKStoresInPastXMonth(args[0], args[1]);
			for(int store : stores) {
				System.out.println(store);
			}
		}
	}
	
	private static void test_topCustomers() {
		for(int[] args : new int[][] {{1, 5}, {1, 1}, {10, 1}}) {
			System.out.printf("\n--- TOP %d CUSTOMERS IN PAST %d MONTHS (%d DAYS) ---\n", args[0], args[1], args[1] * 30);
			List<Integer> customers = db.getTopKCustomersInPastXMonth(args[0], args[1]);
			for(int customer : customers) {
				System.out.println(customer);
			}
		}
	}
}
