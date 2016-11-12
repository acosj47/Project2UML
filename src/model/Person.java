package model;

public class Person {
	private String firstName;
	private String lastName;
	private static int idNumber;
	private String id;
	private String username;
	private String password;
	private String phoneNumber;
	private Address address;
	
	public Person(String firstName, String lastName, String username, String password, Address address){
		idNumber++;
		id = String.valueOf(idNumber);
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.address = address;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getId(){
		return id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setPhoneNumber(String phoneNumber){
		this.phoneNumber = phoneNumber;
	}
	
	public String getPhoneNumber(){
		return phoneNumber;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	public String toString(){
		return "Name: " + firstName + " " + lastName +  System.lineSeparator() +
				"Username: " + username + System.lineSeparator() + 
				"Address: " + address;
	}
}
