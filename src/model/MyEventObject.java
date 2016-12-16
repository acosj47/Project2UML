package model;
import java.util.EventObject;

public class MyEventObject extends EventObject {

	private String eventTitle;
	private String year;
	private String month;
	private String day;
	private String hour;
	private String minute;
	private String ampm;
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private String streetNumber;
	private String streetName;
	private String city;
	private String state;
	private String zip;
	private String title;
	private double wage;
	private String id;
	private int indexOfDay;
	private String startTime;
	private String endTime;
	private String name;
	private String sku;
	private double price;

	public MyEventObject(Object source) {
		super(source);
	}
	
	// constructor for person id's
	public MyEventObject(Object source, String id){
		super(source);
		this.id = id;
	}
	
	// constructor for shifts
	public MyEventObject(Object source, String id, int indexOfDay, String startTime, String endTime){
		super(source);
		this.id = id;
		this.indexOfDay = indexOfDay;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	// constuctor for food item
	public MyEventObject(Object source, String name, String sku, double price){
		super(source);
		this.name = name;
		this.sku = sku;
		this.price = price;
	}
	
	// constructor for shifts
	public MyEventObject(Object source, String eventTitle, String year, String month, String day, String hour, String minute, String ampm){
		super(source);
		this.eventTitle = eventTitle;
		this.year = year;
		this.month = month;
		this.day = day;
		this.hour = hour;
		this.minute = minute;
		this.ampm = ampm;
	}

	// constructor for employee
	public MyEventObject(Object source, String firstName, String lastName, String username, String password , String title, double wage, String streetNumber, 
			String streetName, String city, String state, String zip  ){
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
		this.title = title;
		this.wage = wage;
	}


	public String getFirstName() {
		return firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public String getUsername() {
		return username;
	}


	public String getPassword() {
		return password;
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


	public String getTitle() {
		return title;
	}


	public double getWage() {
		return wage;
	}
	
	public String getId(){
		return id;
	}

	public String getEventTitle() {
		return eventTitle;
	}

	public String getYear() {
		return year;
	}

	public String getMonth() {
		return month;
	}

	public String getDay() {
		return day;
	}

	public String getHour() {
		return hour;
	}

	public String getMinute() {
		return minute;
	}

	public String getAmpm() {
		return ampm;
	}

	public int getIndexOfDay() {
		return indexOfDay;
	}

	public String getStartTime() {
		return startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public String getName() {
		return name;
	}

	public String getSku() {
		return sku;
	}

	public double getPrice() {
		return price;
	}
	
	
	
	

	


}
