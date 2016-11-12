package model;

public class Table {
	private String tableNumber;
	private int seats;
	
	public Table(String tableNumber, int seats) {
		super();
		this.tableNumber = tableNumber;
		this.seats = seats;
	}

	public String getTableNumber() {
		return tableNumber;
	}

	public void setTableNumber(String tableNumber) {
		this.tableNumber = tableNumber;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}
	
	
	
	
}
