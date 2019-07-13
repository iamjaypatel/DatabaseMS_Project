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
}
