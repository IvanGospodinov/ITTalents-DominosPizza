package user;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;


import database.MySQLConnector;
import producti.Meal;
import restorant.Restorant;

public class User implements IPassword, ILogin, IMakeOrder {
	private Scanner sc = new Scanner(System.in);
	private int userID;
	MySQLConnector connector;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private boolean checkPass;
	private boolean checkNumber;
	private boolean checkEmail;;	
	ArrayList<Address> addresses;
	ArrayList<Meal> cart;
	//ArrayList<Meal> previousOrders;
	private String telephoneNumber;
	
	public User(String firstName, String lastName) {
		connector = new MySQLConnector();
		connector.connection();
		
		cart = new ArrayList<Meal>(10);
	//	previousOrders = new ArrayList<Meal>(100);
		addresses = new ArrayList<Address>();
		setEmail();
		setFirstName(firstName);
		setLastName(lastName);
		//this.telephoneNumber = phone;
		//this.email = email;
		//this.password = password;
		phoneSettingWhileMethod();
		passSettingWhileMethod();
		//setUserID(getEmail());
		if(sc!=null) {
			sc.close();
		}
		
		addToDB(getFirstName(),getLastName(),getEmail(),getPassword(),getTelephoneNumber());
		//Address a = new Address(this);
		//addToAddressBook(a);
	}
	
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail() {
		try {
			do {
				checkDBIfEmailExists();
			} while (checkEmail);
		} catch(NullPointerException d) {
			System.out.println(d.getMessage());
			System.out.println(d.getStackTrace());
		}
		
	}
	private void checkDBIfEmailExists() {
		System.out.println("Please enter your email!");
		String e = sc.nextLine();
		String query ="SELECT email from users where email = ?";
		PreparedStatement st = null;
		ResultSet resultSet = null;
		String checker = null;
		try {
			st = MySQLConnector.conn.prepareStatement(query);
			st.setString(1,e);
			resultSet = st.executeQuery();
			if(resultSet.next()) {
				checker =  resultSet.getString("email");
				if(checker.equals(e)) {
					System.out.println("This email is already registered!");
					checkEmail = true;
					return;
					} 
				}
			}catch (SQLException d) {
				d.printStackTrace();
			}
		System.out.println("Your email has been set!");
 	    this.email = e;
 	    checkEmail = false;
	}
	
	private void getUserID() {
		String query ="SELECT user_ID from users where email = ?";
		PreparedStatement st = null;
		ResultSet resultSet = null;
		String checker = null;
		try {
			st = MySQLConnector.conn.prepareStatement(query);
			st.setString(1,this.email);
			resultSet = st.executeQuery();
			if(resultSet.next()) {
				checker =  resultSet.getString("email");
				if(checker.equals(this.email)) {
					//System.out.println("This phone is already registered!");
					query ="SELECT user_ID from users where email = ?";
					checkNumber = true;
					return;
					} 
				}
			}catch (SQLException d) {
				d.printStackTrace();
			}
		System.out.println("Your phone has been set!");
 	    //this.telephoneNumber = t;
 	    checkNumber = false;
	}
	
	public String getTelephoneNumber() {
		return telephoneNumber;
	}
	public void setTelephoneNumber() {
		String temp = null;
		System.out.println("Please enter your telephone number(start with 359 or start without it):");
		String telephoneNumberInput = sc.nextLine();
		if(!telephoneNumberInput.equals("") && telephoneNumberInput.matches("^[0-9]{10,12}$") 
				&& ((telephoneNumberInput.length()==10) || (telephoneNumberInput.length()==12)) 
				&& this.telephoneNumber != telephoneNumberInput) {
			try {
				temp = telephoneNumberInput;
				checkDBForTelephone(temp);
			} catch (NullPointerException e) {
				System.out.println("You have not entered a valid telephone number!");
				System.out.println(e.getMessage());
			}
		} else {
			System.out.println("Please enter a valid telephone number!");
			checkNumber = true;
		}
	}
	private void phoneSettingWhileMethod() {
		do{
			setTelephoneNumber();
		} while(checkNumber);
	}
	private void checkDBForTelephone(String t) {
		String query ="SELECT phone_number from users where phone_number = ?";
		PreparedStatement st = null;
		ResultSet resultSet = null;
		String checker = null;
		try {
			st = MySQLConnector.conn.prepareStatement(query);
			st.setString(1,t);
			resultSet = st.executeQuery();
			if(resultSet.next()) {
				checker =  resultSet.getString("phone_number");
				if(checker.equals(t)) {
					System.out.println("This phone is already registered!");
					checkNumber = true;
					return;
					} 
				}
			}catch (SQLException d) {
				d.printStackTrace();
			}
		System.out.println("Your phone has been set!");
 	    this.telephoneNumber = t;
 	    checkNumber = false;
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
	
	public String getPassword() {
		return password;
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
		String temp = null;
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
						temp = passwordInput;
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
		if(isChanged) {
			String query = ("INSERT into users (password) values (?)");
			System.out.println("Inserting records into the table...");
		      try {
				MySQLConnector.stmt = MySQLConnector.conn.createStatement();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		      try {
				PreparedStatement preparedStmt = MySQLConnector.conn.prepareStatement(query);
				preparedStmt.setString (1, temp);
			} catch (SQLException e2) {
				e2.printStackTrace();
			} finally{
				try{
					if(MySQLConnector.stmt!=null){
						MySQLConnector.conn.close();
					} 
				}catch(SQLException se){
					se.printStackTrace();
				}
				try{
					if(MySQLConnector.conn!=null) {
						MySQLConnector.conn.close();
					}
					}catch(SQLException se){
						se.printStackTrace();
						}
				}
		      }
		}
	private void passSettingWhileMethod(){
		do{
			setPassword();
		} while(!checkPass);
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
		addresses.add(new Address(this));
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
	
	private void addToDB(String f,String l,String e,String pass,String phone) {
		
		String query = ("INSERT into users ( f_name, l_name, email, password, phone_number) values (?,?,?,?,?)");
		System.out.println("Inserting records into the table...");
	      try {
			MySQLConnector.stmt = MySQLConnector.conn.createStatement();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	      try {
			PreparedStatement preparedStmt = MySQLConnector.conn.prepareStatement(query);
			preparedStmt.setString (1, f);
			preparedStmt.setString (2, l);
			preparedStmt.setString (3, e);
			preparedStmt.setString (4, pass);
			preparedStmt.setString (5, phone);
			preparedStmt.execute();
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
	      ResultSet resultSet = null;
	      //STANDARD UPDATE STATEMENT
	   // String sql = "INSERT into users ( f_name, l_name, email, password, phone_number) values ('" + f + "','" + l +  "','" + e +  "','" + pass +  "','" + phone +  "')";
		     //PREPARED STATEMENT
//	      try {
//			MySQLConnector.stmt.executeUpdate(sql);
//		} catch (SQLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//	      finally{
		      try{
		         if(MySQLConnector.stmt!=null)
		        	 MySQLConnector.conn.close();
		      }catch(SQLException se){
		      }
		      try{
		         if(MySQLConnector.conn!=null)
		        	 MySQLConnector.conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }
	      }
	    //  PreparedStatement stmtInsert = MySQLConnector.conn.prepareStatement();
	      //ResultSet rs = stmtInsert.getGeneratedKeys();

//	      if (rs.next()) {
//	          long id = rs.getLong(1);
	        //  System.out.println("Inserted ID -" + id);
		
//	}

	@Override
	public void logIn() {
		
		if(checkEmail()) {
			checkPassword();
		}
	}
	
	@Override
	public void makeOrder(Restorant r, Meal meal) {
		Meal m = r.orderDelivery(meal);
		this.cart.add(m);		
	}
	public void setUserID(String email) { 
		String getUserID = "SELECT Users_ID FROM users WHERE email = '" + email + "'";
		PreparedStatement st = null;
		ResultSet resultSet = null;
		int checker = 0;
		try {
			st = MySQLConnector.conn.prepareStatement(getUserID);
			st.setString(1,email);
			resultSet = st.executeQuery();
			while(resultSet.next()) {
				userID = resultSet.getInt("Users_ID");
			}
			}catch (SQLException d) {
				d.printStackTrace();
			}
	}
	public int getID() {
		return userID;
	}
	
}
