package menu.pizzas;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import menu.enums_with_ingredients.*;

public class VegeterianPizza extends Pizza {	
	
	
	public VegeterianPizza(String name, double price, int deliveryTime, byte size, Topping topping) {
		super(name, price, deliveryTime, size, topping);
	}
	
	public VegeterianPizza(String name, double price, int deliveryTime, Dough dough, Topping toping, byte size) {
		super(name, price, deliveryTime, dough, toping, size);
	}
		
	public void addExtraVegetable() {
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
			extraIgredient.add(vegetable);
				break;
			case "2": vegetable = Vegetable.BABY_SPINACH.toString();
			extraIgredient.add(vegetable);
			break;
			case "3": vegetable = Vegetable.PICKLES.toString();
			extraIgredient.add(vegetable);
			break;
			case "4": vegetable = Vegetable.BLACK_OLIVES.toString();
			extraIgredient.add(vegetable);
			break;
			case "5": vegetable = Vegetable.MUSHROOMS.toString();
			extraIgredient.add(vegetable);
			break;
			case "6": vegetable = Vegetable.PESTO.toString();
			extraIgredient.add(vegetable);
			break;
			case "7": vegetable = Vegetable.ONION.toString();
			extraIgredient.add(vegetable);
			break;
			case "8": vegetable = Vegetable.JALAPENO.toString();
			extraIgredient.add(vegetable);
			break;
			case "9": vegetable = Vegetable.ARUGULA.toString();
			extraIgredient.add(vegetable);
			break;
			case "10": vegetable = Vegetable.TOMATOES.toString();
			extraIgredient.add(vegetable);
			break;
			case "11": vegetable = Vegetable.GREEN_PEPPERS.toString();
			extraIgredient.add(vegetable);
			break;
			case "12": vegetable = Vegetable.PINEAPPLE.toString();
			extraIgredient.add(vegetable);
			break;
			case "0": vegetable = null;
			System.out.println("We are adding no extra vegetables!");
			break;
			}
		}
		sc.close();
	}
	@Override
	public void addExtraCheese() {
		String cheese = null;
		Scanner sc = new Scanner(System.in);
		int count = 1;
		System.out.println("Please choose the cheese you would like to add"
				+ "(press the number for the cheese type):");
		for (Cheese cheeses : EnumSet.allOf(Cheese.class)) {
		    System.out.println(count + ": " + cheeses);
		    count++;
		}
		String selection = sc.nextLine();
		
		if(selection != null && !selection.equals("")) {
			switch (selection) {
			case "1": cheese = Cheese.PARMESAN.toString();
			extraIgredient.add(cheese);
				break;
			case "2": cheese = Cheese.COW_MILK_CHEESE.toString();
			extraIgredient.add(cheese);
			break;
			case "3": cheese = Cheese.CHEDDAR.toString();
			extraIgredient.add(cheese);
			break;
			case "4": cheese = Cheese.MELTED_CHEESE.toString();
			extraIgredient.add(cheese);
			break;
			case "5": cheese = Cheese.EMMENTAL.toString();
			extraIgredient.add(cheese);
			break;
			case "6": cheese = Cheese.MOZZARELLA.toString();
			extraIgredient.add(cheese);
			break;
			case "0": cheese = null;
			System.out.println("We are adding no extra cheese!");
			break;
			}
		}
		sc.close();
	}
	@Override
	public void addExtraTopping() {
		String spice = null;
		Scanner sc = new Scanner(System.in);
		int count = 1;
		System.out.println("Please choose the spice you would like to add"
				+ "(press the number for the spice type):");
		for (Spice spices : EnumSet.allOf(Spice.class)) {
		    System.out.println(count + ": " + spices);
		    count++;
		}
		String selection = sc.nextLine();
		
		if(selection != null && !selection.equals("")) {
			switch (selection) {
			case "1": spice = Spice.OREGANO.toString();
			extraIgredient.add(spice);
				break;
			case "2": spice = Spice.BASIL.toString();
			extraIgredient.add(spice);
			break;
			case "3": spice = Spice.PARMESAN_FLAKES.toString();
			extraIgredient.add(spice);
			break;
			case "0": spice = null;
			System.out.println("We are adding no extra spices!");
			break;
			}
		}
		sc.close();
	}
	@Override
	public void addExtraSpice() {
		String topping = null;
		Scanner sc = new Scanner(System.in);
		int count = 1;
		System.out.println("Please choose the topping you would like to add"
				+ "(press the number for the topping type):");
		for (Topping toppings : EnumSet.allOf(Topping.class)) {
		    System.out.println(count + ": " + toppings);
		    count++;
		}
		String selection = sc.nextLine();
		
		if(selection != null && !selection.equals("")) {
			switch (selection) {
			case "1": topping = Topping.BBQ.toString();
			extraIgredient.add(topping);
				break;
			case "2": topping = Topping.CREME.toString();
			extraIgredient.add(topping);
			break;
			case "3": topping = Topping.TOMATO.toString();
			extraIgredient.add(topping);
			break;
			
			case "0": topping = null;
			System.out.println("We are adding no extra topping!");
			break;
			}
		}
		sc.close();
	}

	//when the customer orders
	private void extraIngredients() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Do you want to add any extra ingredients: y or n?");
		String answer = sc.nextLine();
		if(answer != null && !answer.equals("")) {
			if(answer.equalsIgnoreCase("n")) {
				System.out.println("You like the old classics!");
				sc.close();
			}
			if(answer.equalsIgnoreCase("y")) {
				System.out.println("For extra meat press - 1;");
				System.out.println("For extra vegetables press - 2;");
				System.out.println("For extra cheese press - 3;");
				System.out.println("For extra topping press - 4;");
				System.out.println("For extra spice press - 5;");
				answer = sc.nextLine();
				if(answer != null && !answer.equals("")) {
					switch (answer) {
					case "1": addExtraMeat();	
						break;
					case "2": addExtraVegetable();
						break;
					case "3":addExtraCheese();
						break;
					case "4":addExtraTopping();	
						break;
					case "5":addExtraSpice();
						break;
					default:
						break;
					}
				}
			}
		}
		sc.close();
	}
}
