package producti;

import java.util.ArrayList;

public class Sause extends Meal{
	
	public Sause(ITypeMeal typeMeal, String name,  int gramaj, double price) {
		super(typeMeal, gramaj,name,  price);
		this.kindMeal=KindMeal.SAUSE;
		
	}
	

	public Sause(ITypeMeal typeMeal, String name, int gramaj, double price, ArrayList<IIngredients> list) {
		super(typeMeal, name, gramaj, price, list);
		
	}

	
	@Override
	public String toString() {
		return "Dip [name=" + name + ", gramaj=" + gramaj +  ", price=" +price+  "]";
	}
	
	
}
