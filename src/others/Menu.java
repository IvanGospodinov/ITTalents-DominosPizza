package others;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Map.Entry;

import producti.ITypeMeal;
import producti.Meal;
import producti.Meal.KindMeal;
import producti.Pizza;
import producti.Pizza.Size;
import producti.TypeMeal;

public class Menu implements Cloneable {

	private HashMap<KindMeal, HashMap<ITypeMeal, ArrayList<Meal>>> catalog;

	public Menu() {
		super();
		this.catalog = new HashMap<>();
	}

	public void addMeal(Meal m) {

		KindMeal kind = m.getKind();
		ITypeMeal type = m.getType();

		if (!this.catalog.containsKey(kind)) {
			this.catalog.put(kind, new HashMap<>());
		}
		if (!this.catalog.get(kind).containsKey(type)) {
			this.catalog.get(kind).put(type, new ArrayList<>());
		}
		this.catalog.get(kind).get(type).add(m);
	}

	public void printCatalog() {
		for (Entry<KindMeal, HashMap<ITypeMeal, ArrayList<Meal>>> entry : this.catalog.entrySet()) {
			System.out.println(entry.getKey());

			HashMap<ITypeMeal, ArrayList<Meal>> map = entry.getValue();

			for (Entry<ITypeMeal, ArrayList<Meal>> entry2 : map.entrySet()) {
				System.out.println("  " + entry2.getKey());

				for (Meal m : entry2.getValue()) {
					System.out.println("    " + m);
				}
			}

		}

	}
	
	
	
	
	public Meal takeMeal(Meal m) {

		KindMeal kind = m.getKind();
		ITypeMeal type = m.getType();
		String name = m.getName();
		Meal m2 = null;

		HashMap<ITypeMeal, ArrayList<Meal>> table = this.catalog.get(kind);
		ArrayList<Meal> list = table.get(type);

		for (Meal meal : list) {
			if (meal.getName().equals(m.getName())) {
				try {
					m2 = (Meal) meal.clone();
				} catch (CloneNotSupportedException e) {
					System.out.println("Ne moga da q kloniram");
					e.printStackTrace();
				}
			}

		}

		return m2;
	}

	
}
