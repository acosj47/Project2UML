package model;

public class Guest extends Person{
	private double bill;
	private EventBag eventHistory;
	private FoodItemBag order;
	private TableBag tableReserved;
	
	
	public Guest(String firstName, String lastName, String username, String password, Address address) {
		super(firstName, lastName, username, password, address);
		order = new FoodItemBag();
		eventHistory = new EventBag();
		tableReserved = new TableBag();
		//eventHistory = new Event[100];
	}

	public double getBill() {
		return bill;
	}

	public void setBill(double bill) {
		this.bill = bill;
	}
	
	public void joinEvent(Event event){
		/*
		int nElems = 0;
		eventHistory[nElems++] = event;
		*/
		eventHistory.add(event);
	}
	
	public void orderFood(FoodItem foodItem){
		order.add(foodItem);
	}
	
	public void reserveTable(Table table){
		tableReserved.addTable(table);
	}
	
	public TableBag getReservedTables(){
		return tableReserved;
	}
	
	public EventBag getEventHistory(){
		return eventHistory;
	}
	
	public FoodItemBag getOrder(){
		return order;
	}
	
	public String toString(){
		return super.toString() + System.lineSeparator() +
				"Bill: " + bill + System.lineSeparator() +
				"Food Ordered: " + getOrder().getFoodItemArray();
	}
	

}
