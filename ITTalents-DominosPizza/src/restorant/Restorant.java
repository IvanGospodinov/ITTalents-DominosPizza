package restorant;

import menu.pizzas.Pizza;

public class Restorant {

	private String name;
	private String address;
	private String openingHours;
	private Menu menu;
	private Pizza customPizza;
	
	
	public Restorant(String name, String address, String openingHours) {
		super();
		setAddress(address);
		setName(name);
		setOpeningHours(openingHours);
		menu = new Menu();
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		if(!address.equals("")) {
			try {
				this.address = address;
			} catch (NullPointerException e) {
				System.out.println(e.getMessage());
				System.out.println(e.getStackTrace());
			}
		}
	}
	public String getOpeningHours() {
		return openingHours;
	}
	public void setOpeningHours(String openingHours) {
		if(!openingHours.equals("")) {
			try {
				this.openingHours = openingHours;
			} catch (NullPointerException e) {
				System.out.println(e.getMessage());
				System.out.println(e.getStackTrace());
			}
		}
	}


	public Menu getMenu() {
		return menu;
	}
	
	public void createCustomPizza() {
		customPizza = menu.createPizza();
	}
	
}
