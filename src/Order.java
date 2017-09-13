import java.util.ArrayList;

public class Order {
	int orderNumber;
	int tableNumber;
	boolean tableStatus;
	
	ArrayList<Food> sentOrder = new ArrayList<>(); //czy nie musze inicijalizowac?
	//ArrayList<ArrayList<Food>> orderList = new ArrayList<ArrayList<Food>>();
	
	public Order(int orderNumber, int tableNumber, ArrayList<Food> currentOrder) {
		this.orderNumber = orderNumber;
		this.tableNumber = tableNumber;
		//this.orderSent = currentOrder;
		sentOrder = currentOrder;
	}
	public String toString() {
		return "OrderNo:" + this.orderNumber + " Table:" +this.tableNumber + " Total Cost:" + sumPrices() ;
	}
	
	public ArrayList<Food> getSentOrder() {
		return sentOrder;
	}
	
	public double sumPrices() {
		double sum = 0;
		for (Food item: sentOrder) {
			sum += item.getPrice();
		}
		return sum;
	}
	
	// jak wypisac liste z numerem zamowienia oraz numerem stoliku?
	public String toString(int orderNumber) {
		return "OrderNo:" + orderNumber + " table:" +this.tableNumber + "Sum:" + this.sentOrder ;
	}
	
	
}
