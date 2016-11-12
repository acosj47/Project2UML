package model;

public class Guest extends Person{
	private double bill;
	private Event[] eventHistory;
	private FoodItem[] order;
	
	public Guest(String firstName, String lastName, String username, String password, Address address) {
		super(firstName, lastName, username, password, address);
		order = new FoodItem[100];
		eventHistory = new Event[100];
	}

	public double getBill() {
		return bill;
	}

	public void setBill(double bill) {
		this.bill = bill;
	}
	
	public void joinEvent(Event event){
		int nElems = 0;
		eventHistory[nElems++] = event;
	}
	
	public void orderFood(FoodItem foodItem){
		int nElems = 0;
		order[nElems++] = foodItem;
	}
	
	public Event[] getEventHistory(){
		return eventHistory;
	}
	
	public FoodItem[] getOrder(){
		return order;
	}
	
	public String toString(){
		return super.toString() + System.lineSeparator() +
				"Bill: " + bill + System.lineSeparator() +
				"Food Ordered: " + getOrder()[0].getName();
	}
	

}
