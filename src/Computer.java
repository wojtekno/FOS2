import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

import javax.annotation.processing.RoundEnvironment;

public class Computer {
	Food food = new Food();
	Order sentOrder;
	// List<ArrayList<Food>> menu = new ArrayList<ArrayList<Food>>();
	ArrayList<Food> currentOrder; // = new ArrayList<Food>();
	boolean orderFlag = false;
	Scanner scan = new Scanner(System.in);
	String choiceS;
	int choiceInt;
	int tableNumber;
	boolean tableFlag = false;

	public Computer() {
		// menu.add(food.mexicanM);
		// menu.add(food.drinkM);
		// System.out.println("Choose\n(L)unch or (D)rink");

		food.mexicanM.add(new Guacamole());
		food.mexicanM.add(new Tortillas());
		food.mexicanM.add(new ChilliConCarne());

		food.dessertM.add(new Tiramisu());
		food.dessertM.add(new Galletas());
	}

	void show1stPage() {
		if (!tableFlag) {
			System.out.println("Put number of the table");
			tableNumber = scan.nextInt();
			tableFlag = true;
		}
		System.out.println("Choose:\n1) Lunch\n2) Drink\n" + "3) Show your order\n4) Send to the kitchen\n5) Exit");
		choiceInt = scan.nextInt();
		if (choiceInt == 1) {
			showCuisines();

		} else if (choiceInt == 2) {
			showDrinks();
		} else if (choiceInt == 3) {
			// print current order
			if (!orderFlag) {
				System.out.println("Nothing here yet");
			} else {
				for (Food element : currentOrder) {
					System.out.println(element);
				}
			}
			show1stPage();
		} else if (choiceInt == 4) {
			// send it to the kitchen, change
			sentOrder = new Order(tableNumber, currentOrder);
			
		} else if (choiceInt == 5) {
			System.exit(0);
		} else {
			System.out.println("wrong number, try again");
			show1stPage();
		}
	}

	void showDrinks() {
		System.out.println("Choose\n");

	}

	void showCuisines() {
		System.out.println("(M)exican\n(I)talian\n(P)olish");
		showDishes();

	}

	void showDishes() {
		choiceS = scan.next();
		if (choiceS.toUpperCase().equals("M")) {

			for (Food element : food.mexicanM) {
				System.out.println(food.mexicanM.indexOf(element) + 1 + ") " + element);
			}
			order(food.mexicanM);

		} else if (choiceS.toUpperCase().equals("I")) {
			for (Food element : food.italianM) {
				System.out.println(food.italianM.indexOf(element) + 1 + ") " + element);
			}
			order(food.italianM);

		} else if (choiceS.toUpperCase().equals("P")) {
			for (Food element : food.polishM) {
				System.out.println(food.polishM.indexOf(element) + 1 + ") " + element);
			}
			order(food.polishM);

		}

	}

	void order(ArrayList<Food> menuX) {
		System.out.println("What are you ordering?");
		choiceInt = scan.nextInt();
		if (orderFlag == false) {
			currentOrder = new ArrayList<Food>();
			orderFlag = true;
		}
		currentOrder.add(menuX.get(choiceInt - 1));
		// for (Food element : order) {
		// System.out.println(element);
		// }
		if (menuX != food.dessertM) {
			System.out.println("Choose dessert");
			showDesserts();
		} else {
			System.out.println("anything else?");
			show1stPage();
		}
		// System.out.println("Would you like anything else?");
		// showMenu();
	}

	void showDesserts() {
		for (Food element : food.dessertM) {
			System.out.println(food.dessertM.indexOf(element) + 1 + ") " + element);
		}
		order(food.dessertM);

	}

}
