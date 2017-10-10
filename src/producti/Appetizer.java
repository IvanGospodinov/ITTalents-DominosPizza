package producti;

import java.util.ArrayList;

import producti.Meal.KindMeal;
import producti.Pizza.Dough;
import producti.Pizza.Size;

public class Appetizer extends Meal {
	
	private String description;
	
	public Appetizer(ITypeMeal typeMeal, String name, int gramaj, double price, ArrayList<IIngredients> list, String description) {
		super(typeMeal, name, gramaj, price, list);
		this.description=description;
		this.kindMeal=KindMeal.APPETIZER;
		
	}

	

	@Override
	public String toString() {
		return "Appetizer [name=" + name + ", gramaj=" + gramaj + ", description=" + description + ",price=" + price + "]";
	}

}
