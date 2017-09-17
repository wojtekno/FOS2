import java.util.ArrayList;

public class Menu {
	ArrayList<ArrayList<Food>> menu;
	ArrayList<Food> mexicanMenu;
	ArrayList<Food> italianMenu;
	ArrayList<Food> polishMenu;
	ArrayList<Food> dessertMenu;
	ArrayList<Food> drinkMenu;
	ArrayList<Food> drinkExtras;
	
	public Menu() {
		menu = new ArrayList<ArrayList<Food>>();
		
		// if you want to add another cuisine, you need to create ArrayList here 
		// add proper dishes to the list
		// and adjust Computer.showCuisine 
		mexicanMenu = new ArrayList<>();
		italianMenu = new ArrayList<>();
		polishMenu = new ArrayList<>();
		drinkMenu = new ArrayList<>();
		dessertMenu = new ArrayList<>();
		drinkExtras = new ArrayList<>();

		mexicanMenu.add(new Guacamole());
		mexicanMenu.add(new Tortillas());
		mexicanMenu.add(new ChilliConCarne());
		
		italianMenu.add(new Pizza());
		italianMenu.add(new Pasta());
		
		polishMenu.add(new ChickenSoup());
		polishMenu.add(new Dumplings());
				
		dessertMenu.add(new Tiramisu());
		dessertMenu.add(new Galletas());
		dessertMenu.add(new ApplePie());
		
		drinkMenu.add(new Water());
		drinkMenu.add(new Wine());
		
		drinkExtras.add(new Lemon());
		drinkExtras.add(new IceCubes());
	}
}
