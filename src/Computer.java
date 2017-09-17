import java.util.ArrayList;
import java.util.Scanner;

public class Computer {
	Menu menu;
	Order sentOrder;
	// list of opened orders
	ArrayList<Order> listOfOrders = new ArrayList<Order>();
	// list of orders which were cashed out
	ArrayList<Order> listOfCashedOutOrders = new ArrayList<Order>();
	// list of things in opened order
	ArrayList<Food> currentOrder;
	boolean orderFlag = false;
	// tells us if the table was assigned to the order
	boolean tableFlag;
	// table's number
	int tableNumber;
	// order's number
	int orderNumber;
	// allows us to choose from the listOfOrders
	int listNumber;
	// listNumber and orderNumber are different things
	Scanner scan = new Scanner(System.in);
	// variable letting user to choose
	int choice;

	public Computer() {
		menu = new Menu();
		tableFlag = false;
		listNumber = 1;
	}

	void show1stPage() {
		System.out.println(
				"Choose:\n1) Lunch\n2) Drink\n" + "3) Show your order\n4) New order" + "\n5) Check orders\n6) Exit");
		intExceptionHandler();
		if (choice == 1) {
			// shows us different cuisines
			showCuisines();
		} else if (choice == 2) {
			showDrinks();
		} else if (choice == 3) {
			// print current order
			if (!orderFlag) {
				System.out.println("Nothing here yet");
			} else {
				System.out.println(listOfOrders.get(listNumber - 1));
				for (Food element : listOfOrders.get(listNumber - 1).listOfItems) {
					System.out.println(element);
				}
			}
			show1stPage();
		} else if (choice == 4) {
			// new order
			if (orderFlag == false && tableFlag == false && listNumber == 1) {
				show1stPage();
			} else {
				listNumber += 1;
				orderFlag = false;
				tableFlag = false;
				show1stPage();
			}
		} else if (choice == 5) {
			printListOfOrders();

		} else if (choice == 6) {
			System.exit(0);
		} else {
			System.out.println("WRONG NUMBER, try again");
			show1stPage();
		}
	}

	void showDrinks() {
		if (!tableFlag) {
			System.out.println("Choose table");
			intExceptionHandler();
			tableNumber = choice;
			tableFlag = true;
		}
		System.out.println("Choose");
		order(menu.drinkMenu);

	}

	void showCuisines() {
		if (!tableFlag) {
			System.out.println("Choose table");
			intExceptionHandler();
			tableNumber = choice;
			tableFlag = true;

		}
		// if you'd added new cuisine, you need to put it's name here and adjust
		// it

		System.out.println("Choose cuisine\n1) Italian\n2) Mexican\n3) Polish");
		intExceptionHandler();
		if (choice == 1) {
			order(menu.italianMenu);
		} else if (choice == 2) {
			order(menu.mexicanMenu);
		} else if (choice == 3) {
			order(menu.polishMenu);
		} else {
			System.out.println("WRONG NUMBER, try agian");
			showCuisines();
		}

	}

	
	void order(ArrayList<Food> menuX) {
		// this method creates actual order or add another items

		if (orderFlag == false) {
			orderNumber += 1;
			currentOrder = new ArrayList<Food>();
			listOfOrders.add(new Order(orderNumber, tableNumber, currentOrder));
			orderFlag = true;
		}
		for (Food element : menuX) {
			System.out.println(menuX.indexOf(element) + 1 + ") " + element);
		}
		System.out.println("What are you ordering?");
		intExceptionHandler();
		menuExceptionHandler(menuX);
		listOfOrders.get(listNumber - 1).listOfItems.add(menuX.get(choice - 1));
		// herre I make sure that lunch consists of main, and dessert
		if (menuX == menu.dessertMenu) {
			System.out.println("anything else?");
			show1stPage();
		} else if (menuX == menu.drinkMenu) {
			// allowing to put extra lemon or ice cubes into the system
			boolean drinkFlag = false;
			do {
				System.out.println("Extras?\n1)Ice 2)Lemon 12) both\n3) nothing");
				intExceptionHandler();

				if (choice == 1 || choice == 12) {
					listOfOrders.get(listNumber - 1).listOfItems.add(menu.drinkExtras.get(0));
					drinkFlag = true;
				}
				if (choice == 2 || choice == 12) {
					listOfOrders.get(listNumber - 1).listOfItems.add(menu.drinkExtras.get(1));
					drinkFlag = true;
				}
				if (choice == 3) {
					drinkFlag = true;
				} else {
					System.out.println("WRONG NUMBER, try again");

				}
			} while (!drinkFlag);

			System.out.println("anything else?");
			show1stPage();

		} else {
			System.out.println("Choose dessert");
			order(menu.dessertMenu);
		}

	}

	void showDesserts() {
		order(menu.dessertMenu);

	}

	void printListOfOrders() {
		// here we print orders which aren't cashed out yet
		if (orderNumber == 0) {
			System.out.println("No orders yet");
			show1stPage();
		} else {
			for (Order order : listOfOrders) {
				System.out.println(listOfOrders.indexOf(order) + 1 + ") " + order);
			}
		}
		System.out.println("what order do you want to see?");
		intExceptionHandler();
		listExceptionHandler(listOfOrders);
		// we use listNumber here to choose from opened orders which are stored
		// in listOfOrders
		listNumber = choice;
		printOrder();
	}

	void printOrder() {
		System.out.println(listOfOrders.get((listNumber - 1)));
		for (Food element : listOfOrders.get(listNumber - 1).getSentOrder()) {
			System.out.println(element);
		}

		System.out.println("1) Add more\n2) Cash out\n3) New order");
		intExceptionHandler();

		if (choice == 1) {
			show1stPage();
		} else if (choice == 2) {
			cashOrderOut();
		} else if (choice == 3) {
			// new order
			listNumber += 1;
			// we assign value false to both flags
			orderFlag = false;
			tableFlag = false;
			show1stPage();
		} else {
			System.out.println("WRONG NUMBER, try again ");
			printOrder();
		}

	}

	void cashOrderOut() {

		listOfCashedOutOrders.add(listOfOrders.get(listNumber - 1));
		listOfOrders.remove(listNumber - 1);
		afterCashOrderOut();
	}

	// check here :)
	void afterCashOrderOut() {
		// this pop up after we cashed out an order
		System.out.println("1) Add new order\n2) Choose order");
		intExceptionHandler();
		if (choice == 1) {
			listNumber = listOfOrders.lastIndexOf(listOfOrders) +1 ;
			orderFlag = false;
			tableFlag = false;
			show1stPage();
		} else if (choice == 2) {
			printListOfOrders();
		} else {
			System.out.println("WRONG NUMBER, try again");
			afterCashOrderOut();
		}
	}

	int intExceptionHandler() {
//		boolean intFlag;
		try {
			choice = 0;
			choice = scan.nextInt();
//			intFlag = true;
		}

		catch (java.util.InputMismatchException e) {
			System.out.println("WRONG CHARACTER!\nEnter a number\n");
//			intFlag = false;
			scan.nextLine();
			intExceptionHandler();
		}

		catch (Exception e) {
			System.out.println("Choose a number\n");
//			intFlag = false;
			scan.nextLine();
			intExceptionHandler();
		}
		return choice;
		
	}
	
	int menuExceptionHandler(ArrayList<Food> menu) {
		boolean listFlag = false;
		do {
			try {
				menu.get(choice - 1);
				listFlag = true;
			}

			catch (java.lang.IndexOutOfBoundsException e) {
				listFlag = false;
				System.out.println("WRONG NUMBER, try again");
				intExceptionHandler();
			}

		} while (!listFlag);
		return choice;
	}

	int listExceptionHandler(ArrayList<Order> list) {
		boolean listFLag = false;
		do {
			try {
				
				list.get(choice - 1);
				listFLag = true;
			}

			catch (java.lang.IndexOutOfBoundsException e) {
				System.out.println("WRONG NUMBER, try again");
				listFLag = false;
				intExceptionHandler();
			}

		} while (!listFLag);
		return choice;
	}

}