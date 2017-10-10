package producti;

import java.util.ArrayList;

import producti.Meal.KindMeal;

public class Salad extends Meal{
	
	

	public Salad (ITypeMeal typeMeal, String name, int gramaj, double price, ArrayList<IIngredients>list) {
		super(typeMeal, name, gramaj, price, list);
		this.kindMeal=KindMeal.SALAD;
	}

	@Override
	public String toString() {
		return "Salad [name=" + name + ", gramaj=" + gramaj +  ", price=" +price+ " listIngredients="
				+ listIngredients + "]";
	}
}