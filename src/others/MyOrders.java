package others;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Map.Entry;

import producti.ITypeMeal;
import producti.Meal;
import producti.Pizza;
import producti.Meal.KindMeal;
import producti.Pizza.Dough;
import producti.Pizza.Size;

public class MyOrders {

	private HashMap<KindMeal, HashMap<ITypeMeal, ArrayList<Meal>>> myOrders;
	private Menu menu;
	private int countProdukts;
	private double priceOrder;

	public MyOrders(Menu menu) {
		super();
		this.myOrders = new HashMap<>();
		this.menu = menu;
	}

	
	public void addMyMeal(Meal meal1) {

		KindMeal kind = meal1.getKind();
		ITypeMeal type = meal1.getType();

		if (!this.myOrders.containsKey(kind)) {
			this.myOrders.put(kind, new HashMap<>());
		}
		if (!this.myOrders.get(kind).containsKey(type)) {
			this.myOrders.get(kind).put(type, new ArrayList<>());
		}
		this.myOrders.get(kind).get(type).add(meal1);
		this.addCountProdukts();
		this.increasePriceOrder(meal1.price);
	}
	
	
	

	public Meal modifySizeMeal(Meal mOriginal, Size size) {

		Meal meal1 = menu.takeMeal(mOriginal);

		if (meal1 instanceof Pizza) {
			System.out.println("Pica e");
			((Pizza) meal1).setSize(size);
			System.out.println(((Pizza) meal1).getSize() + " za check");
			((Pizza) meal1).changePriceSize(mOriginal, meal1);
		}
		return meal1;
	}

	public void changePriceSize(Meal mOriginal, Meal meal1) {

		Size sizeOld = ((Pizza) mOriginal).getSize();
		Size sizeNew = ((Pizza) meal1).getSize();
		double razlikaPr = 0;
		double razlikaTeglo = 0;
		int razlika = sizeOld.ordinal() - sizeNew.ordinal();
		if (Math.abs(razlika) == 1) {
			razlikaPr = 2;
			razlikaTeglo = 200;
		} else if (Math.abs(razlika) == 2) {
			razlikaPr = 3;
			razlikaTeglo = 300;
		}
		if (razlika > 0) {
			meal1.price += razlikaPr;
			meal1.gramaj += razlikaTeglo;
		} else if (razlika < 0) {
			meal1.price -= razlikaPr;
			meal1.gramaj -= razlikaTeglo;
		}
	}

	public void addMyMeal(Meal oiginalMeal, Dough newDough) {
		Meal myMeal = modifyDoughMeal(oiginalMeal, newDough);
		addMyMeal(myMeal);
	}

	private Meal modifyDoughMeal(Meal oiginalMeal, Dough newDough) {
		Meal myMeal = menu.takeMeal(oiginalMeal);
		if (myMeal instanceof Pizza) {
			((Pizza) myMeal).setDough(newDough);
			changePriceDough(oiginalMeal, myMeal);
		}
		return myMeal;
	}

	public void changePriceDough(Meal oiginalMeal, Meal myMeal) {

		Dough dougheOld = ((Pizza) oiginalMeal).getDough();
		Dough doughNew = ((Pizza) myMeal).getDough();

		double razlikaPr = 0;
		double razlikaTeglo = 0;
		int razlika = dougheOld.ordinal() - doughNew.ordinal();
		if (Math.abs(razlika) == 1) {
			razlikaPr = 1;
			razlikaTeglo = 100;
		} else if (Math.abs(razlika) == 2) {
			razlikaPr = 1;
			razlikaTeglo = 100;

		}
		if (razlika > 0) {
			myMeal.price += razlikaPr;
			myMeal.gramaj += razlikaTeglo;
		} else if (razlika < 0) {
			myMeal.price -= razlikaPr;
			myMeal.gramaj -= razlikaTeglo;
		}
	}

	public void addMyMeal(Meal oiginalMeal, Size newSize) {
		Meal myMeal = modifySizeMeal(oiginalMeal, newSize);
		//myMeal.setName
		addMyMeal(myMeal);
	}

	public void printMyOrders() {
		for (Entry<KindMeal, HashMap<ITypeMeal, ArrayList<Meal>>> entry : this.myOrders.entrySet()) {
			System.out.println(entry.getKey());

			HashMap<ITypeMeal, ArrayList<Meal>> map = entry.getValue();

			for (Entry<ITypeMeal, ArrayList<Meal>> entry2 : map.entrySet()) {
				System.out.println("  " + entry2.getKey());

				for (Meal m : entry2.getValue()) {
					System.out.println("    " + m);
				}
			}
		}
		System.out.println("Broj produkti: " + countProdukts);
		System.out.println("Obshta cena do tuk: " + priceOrder);
	}
	
	
	
	
	public void removeMyMeal(Meal myMeal) {

		KindMeal kind = myMeal.getKind();
		ITypeMeal type = myMeal.getType();
		
		HashMap<ITypeMeal, ArrayList<Meal>> entry  = this.myOrders.get(kind);
		ArrayList<Meal> entryList=entry.get(type);
		
		if(entryList.contains(myMeal)){
			
			
			entryList.remove(myMeal);
		}else{
			
			this.reduseCountProdukts();
			this.redusePriceOrder(myMeal.price);
			
			System.out.println("Nqma takova v menuto");
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	

	public int getCountProdukts() {
		return countProdukts;
	}

	public void addCountProdukts() {
		this.countProdukts++;
	}

	public void reduseCountProdukts() {
		this.countProdukts--;
	}

	public double getPriceOrder() {
		return priceOrder;
	}

	public void redusePriceOrder(double price) {
		this.priceOrder -= price;
	}

	public void increasePriceOrder(double price) {
		this.priceOrder += price;
	}

}
