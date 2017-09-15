package user;

import java.util.ArrayList;
import java.util.Scanner;

public class User implements IPassword, ILogin {
	private Scanner sc = new Scanner(System.in);

	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private boolean checkPass;
	ArrayList<Address> addresses;
	ArrayList cart;
	ArrayList previousOrders;
	
	
	public User(String firstName, String lastName, String email) {
		cart = new ArrayList<>(10);
		previousOrders = new ArrayList<>(100);
		addresses = new ArrayList<Address>();
		setFirstName(firstName);
		setLastName(lastName);
		setEmail(email);
		do{
			setPassword();
		} while(!checkPass);
		Address a = new Address();
		addToAddressBook(a);
		
	}
	
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		if(!email.equals("")) {
			try {
				this.email = email;
			} catch(NullPointerException e) {
				System.out.println(e.getMessage());
				System.out.println(e.getStackTrace());
			}
		}
	}



	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		if(!firstName.equals("")) {
			try {
				this.firstName = firstName;
			} catch (NullPointerException e) {
				System.out.println(e.getMessage());
				System.out.println(e.getStackTrace());
			}
		} else {
			System.out.println("Your name needs to have at least one character!");
		}
	}
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		if(!lastName.equals("")) {
			try {
				this.lastName = lastName;
			} catch (NullPointerException e) {
				System.out.println(e.getMessage());
				System.out.println(e.getStackTrace());
			}
		} else {
			System.out.println("Your last name needs to have at least one character!");
		}
	}
	
	public void setPassword() {
		System.out.println("Please enter a password.\nThe password must be at "
				+ "least 5 letters long, contain at least one number, lower case and upper case letter!");
		String passwordInput;
		passwordInput = sc.nextLine();
		if(this.password == null || this.password.equals("")) {
			if(passwordInput!= null && !(passwordInput.equals(""))) {
				if(passwordInput.length() >= 5 && passwordInput.length() < 20) {
					if((passwordInput.matches("^(?=.*[A-Z])(?=.*\\d)(?!.*(AND|NOT)).*[a-z].*"))) {
						System.out.println("You have succesfuly set your password!");
						this.password = passwordInput;
						setCheckPass(true);
					} else {
						System.out.println("Missing character!");
					} 
				} else {
						System.out.println("Shorter or longer than the specified length!");
				}
			} else {
				System.out.println("Incorrect input!");
				setCheckPass(false);
			}
		}
	}
	public void changePassword() {
		int counter = 1;
		boolean isChanged = false;
		while (!isChanged || counter < 4){
			String passwordInput;
			if(this.password != null || !(this.password.equals(""))) {
				System.out.println("If you want to change your password, please enter your current password: ");
				passwordInput = sc.nextLine();
				if(this.password.equals(passwordInput) && !passwordInput.equals("")) {
					System.out.println("Correct! Please enter your new password:");
					passwordInput = sc.nextLine();
					if(!passwordInput.equals(this.password) && !passwordInput.equals("")) {
						this.password = passwordInput;
						counter = 1;
						System.out.println("Your password has been changed!");
						isChanged = true;
					} else {
						System.out.println("You must enter a different password than your current one!");
						isChanged = false;
					}
				} else {
					System.out.println("That is inccorect!");
					counter++;
					isChanged = false;
					if(counter > 3) {
						System.out.println("You have entered the password incorrectly three times!");
						System.out.println("You cannot change the password!");
						break;
					}
				}
			} else {
				System.out.println("You do not have a password yet!");
				break;
			}
		}
	}

	private boolean isCheckPass() {
		return checkPass;
	}
	private void setCheckPass(boolean checkPass) {
		this.checkPass = checkPass;
	}
		
	private void addToAddressBook(Address a) {
		try {
			addresses.add(a);
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
		}
	}
	public void addNewAddress() {
		addresses.add(new Address());
	}
	public void changeAddress() {
		addresses.get(0).changeAddress();
	}

	private boolean checkPassword() {
		int counter = 1;
		boolean isChanged = false;
		while (!isChanged || counter < 4){
			String passwordInput;
			if(this.password != null || !(this.password.equals(""))) {
				System.out.println("Please enter your current password: ");
				passwordInput = sc.nextLine();
				if(this.password.equals(passwordInput) && !passwordInput.equals("")) {
					System.out.println("Correct!");
					System.out.println("Logging you in!");
					isChanged = true;
					break;
				} else {
					System.out.println("Password is incorrect!");
					isChanged = false;
					counter++;
					if(counter > 3) {
						System.out.println("You have entered the password incorrectly three times!");
						System.out.println("You cannot log in to your account!");
						break;
					}
				}
			} else {
				System.out.println("You do not have a password yet!");
				isChanged = false;
				break;
			}
		}
		return isChanged;
	}
	private boolean checkEmail() {
		int counter = 1;
		boolean isChanged = false;
		while (!isChanged || counter < 4){
			String emailInput;
			if(this.email != null || !(this.email.equals(""))) {
				System.out.println("Please enter your current email address: ");
				emailInput = sc.nextLine();
				if(this.email.equals(emailInput) && !emailInput.equals("")) {
					System.out.println("Correct!");
					isChanged = true;
					break;
				} else {
					System.out.println("The email address you have entered is incorrect!");
					isChanged = false;
					counter++;
					if(counter > 3) {
						System.out.println("You have entered the email address incorrectly three times!");
						System.out.println("You cannot log in to your account!");
						break;
					}
				}
			} else {
				System.out.println("You do not have a password yet!");
				isChanged = false;
				break;
			}
		}
		return isChanged;
	}

	@Override
	public void logIn() {
		
		if(checkEmail()) {
			checkPassword();
		}
	}
}
