package user;

import java.util.Scanner;

public class Address implements IAddress{
	Scanner sc = new Scanner(System.in);

	private String city;
	private String neighbourhood;
	private String street;
	private String streetNumber;
	private String building;
	private String entrance;
	private String floor;
	private String apartmentNumber;
	private String postalCode;
	
	public Address() {
		
		addAddress();
	}

	
	
	public String getCity() {
		return city;
	}
	public boolean setCity() {
		boolean isCorrect = false;
		System.out.println("Please enter your city:");
		String cityInput = sc.nextLine();
		if(!cityInput.equals("")) {
			try {
				this.city = cityInput;
				isCorrect = true;
			} catch (NullPointerException e) {
				System.out.println("You have not entered a city!");
				System.out.println(e.getMessage());
			}
		} else {
			System.out.println("Please enter a city!");
			isCorrect = false;
		}
		return isCorrect;
	}
	
	public String getNeighbourhood() {
		return neighbourhood;
	}
	public boolean setNeighbourhood() {
		boolean isCorrect = false;
		System.out.println("Please enter your neighbourhood:");
		String neighbourhoodInput = sc.nextLine();
		if(!neighbourhoodInput.equals("")) {
			try {
				this.neighbourhood = neighbourhoodInput;
				isCorrect = true;
			} catch (NullPointerException e) {
				System.out.println("You have not entered a valid neighbourhood!");
				System.out.println(e.getMessage());
			}
		} else {
			System.out.println("Please enter a valid neighbourhood!");
			isCorrect = false;
		}
		return isCorrect;
	}
	
	public String getStreet() {
		return street;
	}
	public boolean setStreet() {
		boolean isCorrect = false;
		System.out.println("Please enter your street:");
		String streetInput = sc.nextLine();
		if(!streetInput.equals("")) {
			try {
				this.street = streetInput;
				isCorrect = true;
			} catch (NullPointerException e) {
				System.out.println("You have not entered a valid street name!");
				System.out.println(e.getMessage());
			}
		} else {
			System.out.println("Please enter a valid street name!");
			isCorrect = false;
		}
		return isCorrect;
	}
	
	public String getstreetNumber() {
		return streetNumber;
	}
	public boolean setstreetNumber(String streetNumber) {
		boolean isCorrect = false;
		if(!streetNumber.equals("") && streetNumber.matches("^[0-9]{1,7}$")) {
			try {
				this.streetNumber = streetNumber;
				isCorrect = true;
			} catch (NullPointerException e) {
				System.out.println("You have not entered a valid street number!");
				System.out.println(e.getMessage());
			}
		} else {
			System.out.println("Please enter a valid street number!");
			isCorrect = false;
		}
		return isCorrect;
	}
	
	public String getBuilding() {
		return building;
	}
	public boolean setBuilding() {
		boolean isCorrect = false;
		System.out.println("Please enter the number of your building:");
		String buildingInput = sc.nextLine();
		if(!buildingInput.equals("") && buildingInput.matches("^[0-9]{1,7}$")) {
			try {
				this.building = buildingInput;
				isCorrect = true;
			} catch (NullPointerException e) {
				System.out.println("You have not entered a valid building number!");
				System.out.println(e.getMessage());
			}
		} else {
			System.out.println("Please enter a valid building number!");
			isCorrect = false;
		}
		return isCorrect;
	}
	
	public String getEntrance() {
		return entrance;
	}
	public boolean setEntrance() {
		boolean isCorrect = false;
		System.out.println("Please enter the entrance of your building:");
		String entranceInput = sc.nextLine();
		if(!entranceInput.equals("") && entranceInput.matches("[a-zA-Z],^[0-9]{1,7}$")) {
			try {
				this.entrance = entranceInput;
				isCorrect = true;
			} catch (NullPointerException e) {
				System.out.println("You have not entered a valid entrance information!");
				System.out.println(e.getMessage());
			}
		} else {
			System.out.println("Please enter a valid entrance information!");
			isCorrect = false;
		}
		return isCorrect;
	}
	
	public String getFloor() {
		return floor;
	}
	public boolean setFloor() {
		boolean isCorrect = false;
		System.out.println("Please enter the floor:");
		String floorInput = sc.nextLine();
		if(!floorInput.equals("") && floorInput.matches("^[0-9]{1,7}$")) {
			try {
				this.floor = floorInput;
				isCorrect = true;
			} catch (NullPointerException e) {
				System.out.println("You have not entered a valid floor number!");
				System.out.println(e.getMessage());
			}
		} else {
			System.out.println("Please enter a valid floor number!");
			isCorrect = false;
		}
		return isCorrect;
	}
	
	public String getApartmentNumber() {
		return apartmentNumber;
	}
	public boolean setApartmentNumber() {
		boolean isCorrect = false;
		System.out.println("Please enter the apartment number:");
		String apartmentNumberInput = sc.nextLine();
		if(!apartmentNumberInput.equals("") && apartmentNumberInput.matches("^[0-9]{1,7}$") 
				&& this.apartmentNumber != apartmentNumberInput) {
			try {
				this.apartmentNumber = apartmentNumberInput;
				isCorrect = true;
			} catch (NullPointerException e) {
				System.out.println("You have not entered a valid apartment number!");
				System.out.println(e.getMessage());
			}
		} else {
			System.out.println("Please enter a valid apartment number!");
			isCorrect = false;
		}
		return isCorrect;
	}
	
	public String getPostalCode() {
		return postalCode;
	}
	public boolean setPostalCode() {
		boolean isCorrect = false;
		System.out.println("Please enter the post code:");
		String postalCodeInput = sc.nextLine();
		if(!postalCodeInput.equals("") && postalCodeInput.matches("^[0-9]{3,7}$")) {
			try {
				this.postalCode = postalCodeInput;
				isCorrect = true;
			} catch (NullPointerException e) {
				System.out.println("You have not entered a valid post code!");
				System.out.println(e.getMessage());
			}
		} else {
			System.out.println("Please enter a valid post code!");
			isCorrect = false;
		}
		return isCorrect;
	}

	//adding only the required information the rest can be done i the user decides to
	@Override
	public void addAddress() {

		while(!setCity());
		while(!setNeighbourhood());
		while(!setStreet());
		while(!setBuilding());
		while(!setFloor());
		//while(!setEntrance());
		while(!setPostalCode());
		//while(!setTelephoneNumber());
		
	}
	
	public void changeAddress(){
		String currentCity = this.city;
		String currentNeighbourhood = this.neighbourhood;
		String currentStreet = this.street;
		String currentStreetNumber = this.streetNumber;
		String currentBuilding = this.building;
		String currentEntrance = this.entrance;
		String currentFloor = this.floor;
		String currentApartmentNumber = this.apartmentNumber;
		String currentPostalCode = this.postalCode;
		//String currentTelephoneNumber = this.telephoneNumber;
		
		
		while(!setCity());
		while(!setNeighbourhood());
		while(!setStreet());
		while(!setBuilding());
		while(!setFloor());
		if(currentCity.equals(this.city) && currentNeighbourhood.equals(this.neighbourhood)
				&& currentStreet.equals(this.street) && currentBuilding.equals(this.building)
				&& currentFloor.equals(this.floor)) {
			System.out.println("This address is the same as the one that you currently have!");
			while(!setApartmentNumber());
		} else {
			System.out.println("This address is the same as the one that you currently have!");
		}
//		while(!setPostalCode());
//		while(!setTelephoneNumber());
		
		
	}
	
	
}
