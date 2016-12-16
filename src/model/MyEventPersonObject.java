package model;

import java.util.EventObject;

public class MyEventPersonObject extends EventObject {
	
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private String streetNumber;
	private String streetName;
	private String city;
	private String state;
	private String zip;
	private String id;
	
	public MyEventPersonObject(Object source){
		super(source);
	}
	
	// constructor for searching by id
	public MyEventPersonObject(Object source, String id){
		super(source);
		this.id = id;
	}
	
	// constructor for username and password
	public MyEventPersonObject(Object source, String username, String password){
		super(source);
		this.username = username;
		this.password = password;
	}
	
	// constructor for guest objects
	public MyEventPersonObject(Object source, String firstName, String lastName, String username, String password, String streetNumber, 
								String streetName, String city, String state, String zip){
		super(source);
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.streetNumber = streetNumber;
		this.streetName = streetName;
		this.city = city;
		this.state = state;
		this.zip = zip;
		
	}
	
	public String getUsername(){
		return username;
	}
	
	public String getPassword(){
		return password;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getStreetNumber() {
		return streetNumber;
	}

	public String getStreetName() {
		return streetName;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getZip() {
		return zip;
	}
	
	

}
