package menu;

public abstract class Food implements IExtraIngredient {

	protected String name;
	protected double price;
	
	public Food() {};
	
	public Food(String name, double price) {
		super();
		setName(name);
		setPrice(price);
	
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		if(!name.equals("")) {
			try {
				this.name = name;
			} catch (NullPointerException e) {
				System.out.println(e.getMessage());
				System.out.println(e.getStackTrace());
			}
		}
	}

	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		if(price > 0 && price < 50) {
			try {
				this.price = price;
			} catch (NullPointerException e) {
				System.out.println(e.getMessage());
				System.out.println(e.getStackTrace());
			}
		}
	}

	@Override
	public void addExtraMeat() {
	}
	@Override
	public void addExtraVegetable() {
	}
	@Override
	public void addExtraCheese() {
	}
	@Override
	public void addExtraTopping() {
	}
	@Override
	public void addExtraSpice() {
	}
	
}
