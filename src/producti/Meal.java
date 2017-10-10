package producti;

import java.util.ArrayList;

import producti.Pizza.Size;

public class Meal implements Cloneable{

	
	
	protected String name;
	public int gramaj;
	public double price;
	protected  KindMeal kindMeal;
	protected ITypeMeal typeMeal;
	protected ArrayList<IIngredients> listIngredients ;
	
	
	
	public enum KindMeal{ PIZZA, PASTA, SALAD, DESERT, DRINK, APPETIZER, CHICKEN, SAUSE}

	public Meal(ITypeMeal typeMeal, String name, int gramaj, double price, ArrayList <IIngredients> list) {
		super();
		this.typeMeal = typeMeal;
		this.name = name;
		this.gramaj = gramaj;
		this.price=price;
		this.listIngredients=list;
	}

	public Meal(ITypeMeal typeMeal2, int gramaj2, double price2) {
		this.typeMeal = typeMeal2;
		this.gramaj = gramaj2;
		this.price=price2;
	}

	public Meal(ITypeMeal typeMeal2, int gramaj2, String name2, double price2) {
		this.typeMeal = typeMeal2;
		this.gramaj = gramaj2;
		this.price=price2;
		this.name=name2;
		
	}

	public ITypeMeal getType() {
		return typeMeal;
	}
	
	public KindMeal getKind() {
		return kindMeal;
	}

	public String getName() {
		return name;
	}
	
	
	 public Object clone() throws CloneNotSupportedException {
	        return super.clone();
	    }



		
	
	
	
	
//	Map<String, MeatPizza> meatPizzas;
//	Map<String, VegeterianPizza> vegeterianPizzas;
//	Map<String, Antipasto> antipasti;
//	Map<String, Pasta> pastas;
//	Map<String, Salad> salads;
//	Map<String, Sandwich> sandwiches;
//	Map<String, Sauce> sauces;
//	Map<String, Dessert> desserts;
	
	
}
