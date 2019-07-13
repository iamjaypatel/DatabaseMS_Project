import java.util.Date;
import java.util.List;

class PostgresTransactionManager implements ITransactionManager
{

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
		// TODO Auto-generated method stub
		return null;
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