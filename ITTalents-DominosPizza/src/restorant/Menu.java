package restorant;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import menu.antipasti.Antipasto;
import menu.desserts.Dessert;
import menu.drinks.Drinks;
import menu.pastas.Pasta;
import menu.pizzas.MeatPizza;
import menu.pizzas.Pizza;
import menu.pizzas.VegeterianPizza;
import menu.salads.Salad;
import menu.sandwich.Sandwich;
import menu.sauces.Sauce;
import menu.enums_with_ingredients.*;

public class Menu implements ICreatePizza{

	Map<String, MeatPizza> meatPizzas;
	Map<String, VegeterianPizza> vegeterianPizzas;
	Map<String, Antipasto> antipasti;
	Map<String, Pasta> pastas;
	Map<String, Salad> salads;
	Map<String, Sandwich> sandwiches;
	Map<String, Sauce> sauces;
	Map<String, Dessert> desserts;
	Map<String, Drinks> drinks;
	
	public Menu() {
		meatPizzas = new HashMap<String, MeatPizza>();
		vegeterianPizzas = new HashMap<String, VegeterianPizza>();
		antipasti = new HashMap<String, Antipasto>();
		pastas = new HashMap<String, Pasta>();
		salads = new HashMap<String, Salad>();
		sandwiches = new HashMap<String, Sandwich>();
		sauces = new HashMap<String, Sauce>();
		desserts = new HashMap<String, Dessert>();
		drinks = new HashMap<String, Drinks>();
	}

	
	//I have to re-write the code here because it throws an Exception for the scanner
	@Override
	public Pizza createPizza() {
		boolean hasDough = false;
		Scanner sc = new Scanner(System.in);
		Pizza custom = null;
		String choice = null, dough = null, meat = null, 
				vegetables = null, cheese = null, topping = null, spice = null;
		while(!hasDough) {
			try {
				dough = chooseDough();
				if(dough != null) {
					hasDough = true;
				}
			} catch (NullPointerException e) {
				System.out.println(e.getMessage());
				System.out.println(e.getStackTrace());
			}
		}
		byte size = chooseSize();
		System.out.println("Would you like a vegeterian or a meat pizza?");
		System.out.println("1 for Vegeterian");
		System.out.println("2 for Meat");
		choice = sc.nextLine();
		if(choice != null && !choice.equals("")) {
			if(choice.equals("2")) {
				try {
					meat = chooseMeat();
					//set the prices for the different product and have a calculate method for the custom pizza
					custom = new MeatPizza("Custom", 1, 60, size, Topping.TOMATO);
				} catch (NullPointerException e) {
					System.out.println(e.getMessage());
					System.out.println(e.getStackTrace());
				}
			} else {
				custom = new VegeterianPizza("Custom", 1, 60, size, Topping.TOMATO);
			}
			try {
				vegetables = chooseVegetable();
			} catch (NullPointerException e) {
				System.out.println(e.getMessage());
				System.out.println(e.getStackTrace());
			}
			custom.customPizza.add(vegetables);
			try {
				cheese = chooseCheese();
			} catch (NullPointerException e) {
				System.out.println(e.getMessage());
				System.out.println(e.getStackTrace());
			}
			custom.customPizza.add(cheese);
			try {
				topping = chooseTopping();
			} catch (NullPointerException e) {
				System.out.println(e.getMessage());
				System.out.println(e.getStackTrace());
			}
			custom.customPizza.add(topping);
			try {
				spice = chooseSpice();
			} catch (NullPointerException e) {
				System.out.println(e.getMessage());
				System.out.println(e.getStackTrace());
			}
			custom.customPizza.add(spice);
		}
		return custom;
	}
	
	private byte chooseSize() {
		Scanner sc = new Scanner(System.in);
		byte size = 0;
		while(size != 6 || size != 8 || size != 10 || size != 12) {
			System.out.println("Please choose a size:");
			System.out.println("6 - for 6 slices;");
			System.out.println("8 - for 8 slices;");
			System.out.println("10 - for 10 slices;");
			System.out.println("12 - for 12 slices;");
			size = sc.nextByte();
		}
		sc.close();
		return size;
	}
 	private String chooseDough() {
		String food = null;
		Scanner sc = new Scanner(System.in);
		String selection = null;
		int count = 1;
		System.out.println("Please choose what type of dough would you like:");
		for (Dough meats : EnumSet.allOf(Dough.class)) {
		    System.out.println(count + ": " + meats);
		    count++;
		}
		selection = sc.nextLine();
		if(selection != null && !selection.equals("")) {
			switch (selection) {
			case "1": food = Dough.TRADITTIONAL.toString();
				break;
			case "2": food = Dough.ITALIAN_STYLE.toString();
			break;
			case "3": food = Dough.THIN_CRUNCHY.toString();
			break;
			case "4": food = Dough.WITH_PHILADELPHIA_CHEESE.toString();
			break;
			default:food = null;
				break;
			}
		}
		sc.close();
		return food;
	}
	private String chooseMeat() {
		String meat = null;
		Scanner sc = new Scanner(System.in);
		int count = 1;
		System.out.println("Please choose the meat you would like to add"
				+ "(press the number for the meat type):");
		for (Meat meats : EnumSet.allOf(Meat.class)) {
		    System.out.println(count + ": " + meats);
		    count++;
		}
		String selection = sc.nextLine();
		
		if(selection != null && !selection.equals("")) {
			switch (selection) {
			case "1": meat = Meat.SMOKED_BACON.toString();
			break;
			case "2": meat = Meat.CHORIZO.toString();
			break;
			case "3": meat = Meat.SMOKED_HAM.toString();
			break;
			case "4": meat = Meat.PEPPERONI.toString();
			break;
			case "5": meat = Meat.CHICKEN.toString();
			break;
			case "6": meat = Meat.SPICY_BEEF.toString();
			break;
			case "7": meat = Meat.TUNA_FISH.toString();
			break;
			default: meat = null;
			break;
			}
		}
		sc.close();
		return meat;
 	}
	private String chooseVegetable() {
		String vegetable = null;
		Scanner sc = new Scanner(System.in);
		int count = 1;
		System.out.println("Please choose the vegetable you would like to add"
				+ "(press the number for the vegetable type):");
		for (Vegetable vegetables : EnumSet.allOf(Vegetable.class)) {
		    System.out.println(count + ": " + vegetables);
		    count++;
		}
		String selection = sc.nextLine();
		
		if(selection != null && !selection.equals("")) {
			switch (selection) {
			case "1": vegetable = Vegetable.CORN.toString();
				break;
			case "2": vegetable = Vegetable.BABY_SPINACH.toString();
			break;
			case "3": vegetable = Vegetable.PICKLES.toString();
			break;
			case "4": vegetable = Vegetable.BLACK_OLIVES.toString();
			break;
			case "5": vegetable = Vegetable.MUSHROOMS.toString();
			break;
			case "6": vegetable = Vegetable.PESTO.toString();
			break;
			case "7": vegetable = Vegetable.ONION.toString();
			break;
			case "8": vegetable = Vegetable.JALAPENO.toString();
			break;
			case "9": vegetable = Vegetable.ARUGULA.toString();
			break;
			case "10": vegetable = Vegetable.TOMATOES.toString();
			break;
			case "11": vegetable = Vegetable.GREEN_PEPPERS.toString();
			break;
			case "12": vegetable = Vegetable.PINEAPPLE.toString();
			break;
			default: vegetable = null;
			break;
			}
		}
		sc.close();
		return vegetable;
	}
	private String chooseCheese() {
		String cheese = null;
		Scanner sc = new Scanner(System.in);
		int count = 1;
		System.out.println("Please choose the cheese you would like to add"
				+ "(press the number for the cheese type):");
		System.out.println("0: " + "no extra cheese");
		for (Cheese cheeses : EnumSet.allOf(Cheese.class)) {
		    System.out.println(count + ": " + cheeses);
		    count++;
		}
		String selection = sc.nextLine();
		
		if(selection != null && !selection.equals("")) {
			switch (selection) {
			case "1": cheese = Cheese.PARMESAN.toString();
				break;
			case "2": cheese = Cheese.COW_MILK_CHEESE.toString();
			break;
			case "3": cheese = Cheese.CHEDDAR.toString();
			break;
			case "4": cheese = Cheese.MELTED_CHEESE.toString();
			break;
			case "5": cheese = Cheese.EMMENTAL.toString();
			break;
			case "6": cheese = Cheese.MOZZARELLA.toString();
			break;
			case "0": cheese = null;
			System.out.println("We are adding no extra cheese!");
			break;
			}
		}
		sc.close();
		return cheese;
	}
	private String chooseTopping() {
		String topping = null;
		Scanner sc = new Scanner(System.in);
		int count = 1;
		System.out.println("Please choose the topping you would like to add"
				+ "(press the number for the topping type):");
		System.out.println("0: " + "no extra topping");
		for (Topping toppings : EnumSet.allOf(Topping.class)) {
		    System.out.println(count + ": " + toppings);
		    count++;
		}
		String selection = sc.nextLine();
		
		if(selection != null && !selection.equals("")) {
			switch (selection) {
			case "1": topping = Topping.BBQ.toString();
				break;
			case "2": topping = Topping.CREME.toString();
			break;
			case "3": topping = Topping.TOMATO.toString();
			break;
			case "0": topping = null;
			System.out.println("We are adding no extra topping!");
			break;
			}
		}
		sc.close();
		return topping;
	}
	private String chooseSpice() {
		String spice = null;
		Scanner sc = new Scanner(System.in);
		int count = 1;
		System.out.println("Please choose the spice you would like to add"
				+ "(press the number for the spice type):");
		System.out.println("0: " + "no extra spice");
		for (Spice spices : EnumSet.allOf(Spice.class)) {
		    System.out.println(count + ": " + spices);
		    count++;
		}
		String selection = sc.nextLine();
		
		if(selection != null && !selection.equals("")) {
			switch (selection) {
			case "1": spice = Spice.OREGANO.toString();
				break;
			case "2": spice = Spice.BASIL.toString();
			break;
			case "3": spice = Spice.PARMESAN_FLAKES.toString();
			break;
			case "0": spice = null;
			System.out.println("We are adding no extra spices!");
			break;
			}
		}
		sc.close();
		return spice;
	}


}
