import java.util.ArrayList;
import java.util.List;

public class Food {
	double price;
	String name;
	ArrayList<Food> mexicanM;
	ArrayList<Food> italianM;
	ArrayList<Food> polishM;
	ArrayList<Food> drinkM;
	ArrayList<Food> dessertM;
	
	public Food() {
		mexicanM = new ArrayList<>();
		italianM = new ArrayList<>();
		polishM = new ArrayList<>();
		drinkM = new ArrayList<>();
		dessertM = new ArrayList<>();
		

//		mexicanM.add(new Guacamole());
//		mexicanM.add(new Tortillas());
//		mexicanM.add(new ChilliConCarne());
//		
//		dessertM.add(new Tiramisu());
//		dessertM.add(new Galletas());	
	}
	
	
	double getPrice() {
		return this.price;
	}

	String getname() {
		return this.name;
	}

	public String toString() {
		return name + " " + price;
	}
	
	

}
