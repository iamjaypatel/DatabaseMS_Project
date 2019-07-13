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
		
		test_getCoffees();
		
	}
	
	private static void test_getCoffees() {
		System.out.println("\n--- GET COFFEES ---");
		List<Integer> coffees = db.getCoffees();
		for (int coffee : coffees) {
			System.out.println(coffee);
		}
	}
}
