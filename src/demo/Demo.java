package demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import database.MySQLConnector;
import restorant.Restorant;
import user.User;

public class Demo {
	
	public static void main(String[] args) {
		User ivan2 = new User("Test1", "Gospodinov2");
		//conn.addUserDetails(ivan.getFirstName(), ivan.getLastName(), ivan.getEmail(), "BratinDol14", ivan.getTelephoneNumber());
		
		
		
		
		//User georgi = new User("Georgi", "Tonev", "b@abv.bg");
		//ivan.changeAddress();
		//ivan.changePassword();
		//ivan.logIn();
		Restorant dominos = new Restorant("Dominos", "Kr poliyna");
		
		
	}

}
