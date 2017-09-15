package demo;

import user.User;

public class Demo {
	public static void main(String[] args) {
	
		User ivan = new User("Ivan", "Gospodinov", "a@abv.bg");
		
		//ivan.changeAddress();
		//ivan.changePassword();
		ivan.logIn();
		
	}

}
