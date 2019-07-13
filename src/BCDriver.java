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
		test_getPointsByCustomerId();
		
		
	}
	
	private static void test_getCoffees() {
		System.out.println("\n--- GET COFFEES ---");
		List<Integer> coffees = db.getCoffees();
		for (int coffee : coffees) {
			System.out.println(coffee);
		}
	}
	
	private static void test_getPointsByCustomerId() {
		for(int i : new int[] {1, -15}) {
			System.out.printf("\n--- GET POINTS FOR CUSTOMER %s ---\n", i);
			double pts = db.getPointsByCustomerId(i);
			System.out.println(pts);
		}
	}
}
