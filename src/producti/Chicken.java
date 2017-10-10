package producti;

import java.util.ArrayList;

import producti.Meal.KindMeal;

public class Chicken extends Meal {
	
	private String description;
	
	public Chicken(ITypeMeal typeMeal, String name, int gramaj, double price, ArrayList<IIngredients> list, String description) {
		super(typeMeal, name, gramaj, price, list);
		this.description=description;
		this.kindMeal=KindMeal.CHICKEN;
		
	}

	

	@Override
	public String toString() {
		return "Chicken Meal  [name=" + name + ", gramaj=" + gramaj + ", description=" + description + ",price=" + price + "]";
	}

}

