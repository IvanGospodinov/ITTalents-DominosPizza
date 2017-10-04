package producti;

import java.util.ArrayList;

public class Pizza extends Meal {

	public enum Size {
		JUMBO, BIG, MIDDLE,
	};

	public enum Dough {
		TRADITTIONAL, ITALIAN_STYLE, THIN_CRUNCHY, WITH_PHILADELPHIA_CHEESE
	};

	protected Dough dough;
	protected Size size;

	public Pizza(ITypeMeal typeMeal, String name, int gramaj, double price, ArrayList<IIngredients> list) {
		super(typeMeal, name, gramaj, price, list);
		this.kindMeal = KindMeal.PIZZA;
		this.dough = Dough.TRADITTIONAL;
		this.size = Size.BIG;
	}

	@Override
	public String toString() {
		return "Pizza [name=" + name + ", gramaj=" + gramaj + ", dough=" + dough + ", size" + size + ",price=" + price
				+ ", listIngredients=" + listIngredients + "]";
	}

	public void setSize(Size s) {
		this.size = s;
	}

	

	public void changePrice(Meal m, Meal meal1) {
		
		Size sizeOld=((Pizza)m).getSize();
		Size sizeNew=((Pizza)meal1).getSize();
		
		double razlikaPr=0;
		double razlikaTeglo=0;
		int razlika=sizeOld.ordinal()-sizeNew.ordinal();
		if(Math.abs(razlika)==1) {
			 razlikaPr=2;
			 razlikaTeglo=200;
		}else if(Math.abs(razlika)==2){
			 razlikaPr=3;
			 razlikaTeglo=300;

		}
		if(razlika>0) {
			this.price+=razlikaPr;
			this.gramaj+=razlikaTeglo;
		}else if(razlika<0) {
			this.price-=razlikaPr;
			this.gramaj-=razlikaTeglo;
		}

		
		
				
	}

	
	private Size getSize() {
		return size;
	}

	// @Override
	// public String toString() {
	// return "Pizza [name=" + name + ", gramaj=" + gramaj + ", price=" +price+ "]";
	// }

}
