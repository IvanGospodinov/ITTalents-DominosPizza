package demo;

import java.util.EnumSet;

import restorant.Restorant;
import user.User;

public class Demo {
	public static void main(String[] args) {
	
		//User ivan = new User("Ivan", "Gospodinov", "a@abv.bg");
		
		//ivan.changeAddress();
		//ivan.changePassword();
		//ivan.logIn();
		Restorant dominos = new Restorant("Dominos", "Kr poliyna", "10:00 - 23:00");
		dominos.createCustomPizza();
		
		
	}

}
