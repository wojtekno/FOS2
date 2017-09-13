import java.util.ArrayList;

public class Order {
	int orderNumber;
	int tableNumber;
	boolean tableStatus;
	
	//ArrayList<Food> orderSent;
	ArrayList<ArrayList<Food>> orderList;
	
	public Order(int tableNumber, ArrayList<Food> currentOrder) {
		this.orderNumber =+1;
		this.tableNumber = tableNumber;
		//this.orderSent = currentOrder;
		orderList.add(currentOrder);
	}
	// jak wypisac liste z numerem zamowienia oraz numerem stoliku?
	public String toString(int orderNumber) {
		return "OrderNo: " + orderNumber + "at table: " +this.tableNumber +" "  ;
	}
}
