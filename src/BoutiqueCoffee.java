import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.function.Consumer;

class BoutiqueCoffee implements ITransactionManager
{
	private Connection conn;
	private Consumer<String> error_logger;
	
	public BoutiqueCoffee(String url, String username, String password) throws SQLException, ClassNotFoundException {
		// verify that postgresql driver is available
		Class.forName("org.postgresql.Driver");
		
		// create connection to the database
		Properties props = new Properties();
		props.setProperty("user", username);
		props.setProperty("password", password);
		conn = DriverManager.getConnection(url, props);
		
		// no error logging by default
		setErrorLogger(s -> {});
	}
	
	public BoutiqueCoffee(String username, String password) throws SQLException, ClassNotFoundException {
		this("jdbc:postgresql://localhost/postgres", username, password);
	}
	
	public void setErrorLogger(Consumer<String> error_logger) {
		this.error_logger = error_logger;
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
		String fieldName = "coffee_id";
		try {
			PreparedStatement stmt = conn.prepareStatement(queryString);
			ResultSet values = stmt.executeQuery();
			
			while(values.next()) {
				int id = values.getInt(fieldName);
				results.add(id);
			}
		} catch(SQLException e) {
			return new LinkedList<Integer>();
		}
		
		return results;
	}

	@Override
	public List<Integer> getCoffeesByKeywords(String keyword1, String keyword2) {
		LinkedList<Integer> results = new LinkedList<Integer>();
		String queryString = "SELECT coffee_id FROM boutique_coffee.coffee";
		String fieldName = "coffee_id";
		try {
			PreparedStatement stmt = conn.prepareStatement(queryString);
			ResultSet values = stmt.executeQuery();
			
			while(values.next()) {
				int id = values.getInt(fieldName);
				results.add(id);
			}
		} catch(SQLException e) {
			logException(e);
			results = new LinkedList<Integer>();
		} catch(Exception e) {
			results = new LinkedList<Integer>();
		}
		
		return results;
	}

	@Override
	public double getPointsByCustomerId(int customerId) {
		double pts;
		String queryString = "SELECT total_points FROM boutique_coffee.customer WHERE customer_id = ?";
		String fieldName = "total_points";
		try {
			PreparedStatement stmt = conn.prepareStatement(queryString);
			stmt.setInt(1, customerId);
			ResultSet values = stmt.executeQuery();
			
			if(values.next()) {
				pts = values.getDouble(fieldName);
			}
			else {
				pts = -1;
			}
		} catch(SQLException e) {
			logException(e);
			pts = -1;
		} catch(Exception e) {
			pts = -1;
		}
		return pts;
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
	
	private void logException(SQLException e) {
		error_logger.accept("SQL ERROR");
		while(e != null) {
			error_logger.accept(e.getMessage());
			error_logger.accept(e.getSQLState());
			error_logger.accept("" + e.getErrorCode());
			e = e.getNextException();
		}
	}
}