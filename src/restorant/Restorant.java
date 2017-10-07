package restorant;

import java.util.HashSet;
import java.util.Set;

import others.Menu;
import producti.ITypeMeal;
import producti.Meal;
import user.User;

public class Restorant {

	private String name;
	private String address;
	private Menu menu;
	
	
	
	public Restorant(String name, String address) {
		super();
		setAddress(address);
		setName(name);
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
	
	public Meal orderDelivery(Meal meal) {
		return menu.takeMeal(meal);
	}

	public Menu getMenu() {
		return menu;
	}
	
	public void checkoutCounter(Meal m) {
		System.out.println("The total price is " + m.getPrice());
	}
}
