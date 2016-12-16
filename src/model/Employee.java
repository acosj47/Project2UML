package model;

public class Employee extends Person {
	private String title;
	private double wage;
	private Shift shift;
	
	public Employee(String firstName, String lastName, String username, String password, 
					Address address, String title, double wage){
		super(firstName, lastName, username, password, address);
		this.title = title;
		this.wage = wage;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getWage() {
		return wage;
	}

	public void setWage(double wage) {
		this.wage = wage;
	}

	public Shift getShift() {
		return shift;
	}

	public void setShift(Shift shift) {
		this.shift = shift;
	}
	
	
}
