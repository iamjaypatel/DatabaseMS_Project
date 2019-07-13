import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

class BoutiqueCoffee implements ITransactionManager
{
	private Connection conn;
	
	public BoutiqueCoffee(String url, String username, String password) throws SQLException, ClassNotFoundException {
		// verify that postgresql driver is available
		Class.forName("org.postgresql.Driver");
		
		// create connection to the database
		Properties props = new Properties();
		props.setProperty("user", username);
		props.setProperty("password", password);
		conn = DriverManager.getConnection(url, props);
	}
	
	public BoutiqueCoffee(String username, String password) throws SQLException, ClassNotFoundException {
		this("jdbc:postgresql://localhost/postgres", username, password);
	}
	
	// TRANSACTIONS

	@Override
	public int addStore(String name, String address, String storeType, double gpsLong, double gpsLat) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int addCoffee(String name, String description, int intensity, double price, double rewardPoints,
			double redeemPoints) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int offerCoffee(int storeId, int cofeeId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int addPromotion(String name, Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int promoteFor(int promotionId, int coffeeId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int hasPromotion(int storeId, int promotionId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int addMemberLevel(String name, double boosterFactor) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int addCustomer(String firstName, String lastName, String email, int memberLevelId, double totalPoints) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int addPurchase(int customerId, int storeId, Date purchaseTime, List<Integer> coffeeIds,
			List<Integer> purchaseQuantities, List<Integer> redeemQuantities) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Integer> getCoffees() {
		LinkedList<Integer> results = new LinkedList<Integer>();
		String queryString = "SELECT coffee_id FROM boutique_coffee.coffee";
		try {
			PreparedStatement stmt = conn.prepareStatement(queryString);
			ResultSet values = stmt.executeQuery();
			
			while(values.next()) {
				int id = values.getInt("coffee_id");
				results.add(id);
			}
		} catch(Exception e) {
			return new LinkedList<Integer>();
		}
		
		return results;
	}

	@Override
	public List<Integer> getCoffeesByKeywords(String keyword1, String keyword2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getPointsByCustomerId(int customerId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Integer> getTopKStoresInPastXMonth(int k, int x) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Integer> getTopKCustomersInPastXMonth(int k, int x) {
		// TODO Auto-generated method stub
		return null;
	}
	
}