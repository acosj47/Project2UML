package model;

import java.io.Serializable;

public class Table implements Serializable {
	private String tableNumber;
	private int seats;
	private boolean reserved = false;
	
	public Table(String tableNumber, int seats) {
		super();
		this.tableNumber = tableNumber;
		this.seats = seats;
		reserved = false;
		
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
	
	public void setReservedTable(){
		reserved = true;
	}
	
	public void setOpenTable(){
		reserved = false;
	}
	
	public boolean isReserved(){
		return reserved;
	}
	
	
}
