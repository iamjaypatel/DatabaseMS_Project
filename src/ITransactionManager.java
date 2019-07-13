import java.util.Date;
import java.util.List;

public interface ITransactionManager {
	/*
	 * @return the auto-generated ID of this store or -1 if the operation is not possible or failed
	 */
	public int addStore(String name, String address, String storeType, double gpsLong, double gpsLat);
	
	/*
	 * @return the auto-generated ID of this coffee or -1 if the operation is not possible
	 */
	public int addCoffee(String name, String description, int intensity, double price, double rewardPoints, double redeemPoints);
	
	/*
	 * @return 1 if the operation succeeded or -1 if the operation is not possible or failed
	 */
	public int offerCoffee(int storeId, int cofeeId);
	
	/*
	 * @return the auto-generated ID of this promotion or -1 if the operation is not possible or failed
	 */
	public int addPromotion(String name, Date startDate, Date endDate);
	
	/*
	 * @return 1 if the operation succeeded or -1 if the operation is not possible or failed
	 */
	public int promoteFor(int promotionId, int coffeeId);
	
	/*
	 * @return 1 if the operation succeeded or -1 if the operation is not possible or failed
	 */
	public int hasPromotion(int storeId, int promotionId);
	
	/*
	 * @return the auto-generated ID of this member level or -1 if the operation is not possible or failed
	 */
	public int addMemberLevel(String name, double boosterFactor);
	
	/*
	 * @return the auto-generated ID of this customer or -1 if the operation is not possible or failed
	 */
	public int addCustomer(String firstName, String lastName, String email, int memberLevelId, double totalPoints);
	
	/*
	 * @param coffeeIds - ID's of the coffees being bought by this purchase
	 * @param purchaseQuantities - Mapping 1-to-1 to coffeeIds, indicating the purchase quantity of each coffee in this purchase
	 * @param redeemQuantities - Mapping 1-to-1 to coffeeIds, indicating the redeem quantity of each coffee in this purchase
	 * @return the auto generated ID of this purchase or -1 if the operation is not possible or failed
	 * Notes:
	 * - Examples of failures: not having enough points to redeem coffees, certain coffee not being sold in the store, etc.
	 */
	public int addPurchase(int customerId, int storeId, Date purchaseTime, List<Integer> coffeeIds, List<Integer> purchaseQuantities, List<Integer> redeemQuantities);

	/*
	 * @return a list of ID's of all cofees in the database. It returns an empty list if no coffee is in the database
	 */
	public List<Integer> getCoffees();
	
	/*
	 * @return a list of ID's of all coffees, each of which has both keywords in its name, in the database. It returns an empty list if no coffee satisfying the conditions is in the database or the operation failed
	 */
	public List<Integer> getCoffeesByKeywords(String keyword1, String keyword2);
	
	/*
	 * @return the total points of the customer identified by the customerId or -1 if the operation is not possible or failed
	 */
	public double getPointsByCustomerId(int customerId);
	
	/*
	 * @param k - the size of the rankings
	 * @param x - the timespan in months
	 * @return a list of ID's of the top k stores having spend the most money in the past x months
	 * Notes:
	 * - Revenue is defined as the sum of money that the customers pay for the coffees
	 * - 1 month is defined as 30 days counting back starting from the current date time
	 * - The returned list should be sorted, with the ID of the store with the highest revenue at its head
	 * - If multiple stores have the same revenue in the kth highest revenue position, their ID's should all be returned.
	 * - It returns an empty list if no store is in the database or the operation failed
	 */
	public List<Integer> getTopKStoresInPastXMonth(int k, int x);

	/*
	 * @param k - the size of the rankings
	 * @param x - the timespan in months
	 * @return a list of ID's of the top k customers having the highest revenue in the past x months
	 * Notes:
	 * - 1 month is defined as 30 days counting back starting from the current date time
	 * - The returned list should be sorted, with the ID of the customer with the highest spending at its head
	 * - If multiple customers have the same spending in the kth highest revenue position, their ID's should all be returned.
	 * - It returns an empty list if no customer is in the database or the operation failed
	 */
	public List<Integer> getTopKCustomersInPastXMonth(int k, int x);
}
