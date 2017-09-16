package menu.pizzas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import menu.Food;
import menu.enums_with_ingredients.*;

public abstract class Pizza extends Food{

	private int deliveryTime; // in minutes
	private Dough dough;
	private Topping topping;
	private byte size;
	protected ArrayList<String> extraIgredient;
	public ArrayList<String> customPizza;
	
	public Pizza() {	}
	
	public Pizza(String name, double price, int deliveryTime, Dough dough, Topping topping, byte size) {
		super(name, price);
		setDeliveryTime(deliveryTime);
		this.dough = dough;
		this.topping = topping;
		setSize(size);
		extraIgredient = new ArrayList<String>();
		customPizza = new ArrayList<String>();	
		
	}

	public Pizza(String name, double price, int deliveryTime, byte size, Topping toping) {
		setName(name);
		setPrice(price);
		setDeliveryTime(deliveryTime);
		setSize(size);
	}

	public int getDeliveryTime() {
		return deliveryTime;
	}
	public void setDeliveryTime(int deliveryTime) {
		if(deliveryTime > 15 && deliveryTime < 60) {
			this.deliveryTime = deliveryTime;
		}
	}

	public byte getSize() {
		return size;
	}
	public void setSize(byte size) {
		if(size >= 6 && size <= 12) {
			this.size = size;
		}
	}
}
