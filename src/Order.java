import java.util.ArrayList;


public class Order {
	int orderNumber;
	int tableNumber;
	// list of ordered items
	ArrayList<Food> listOfItems;

	public Order(int orderNumber, int tableNumber, ArrayList<Food> currentOrder) {
		listOfItems = new ArrayList<>();
		this.orderNumber = orderNumber;
		this.tableNumber = tableNumber;
		listOfItems = currentOrder;
	}

	public String toString() {
		return "OrderNo:" + this.orderNumber + " Table:" + this.tableNumber + " Total Cost:" + sumPrices();
	}

	public ArrayList<Food> getSentOrder() {
		return this.listOfItems;
	}

	public double sumPrices() {
		double sum = 0;
		for (Food item : listOfItems) {
			sum += 100 * item.getPrice();
		}
		return sum/100;
		//this way I'm making sure there will be no problems with summing double variables
	}

//	public String toString(int orderNumber) {
//		return "OrderNo:" + orderNumber + " table:" + this.tableNumber + "Sum:" + this.listOfItems;
//	}

//	void addExtrasToDrink(String extras) {
//		listOfItems.get(listOfItems.lastIndexOf(listOfItems)).name += "extras";
//	}
}
