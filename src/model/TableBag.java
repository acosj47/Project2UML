package model;

import java.io.Serializable;
import java.util.ArrayList;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class TableBag implements Serializable {
	private ArrayList<Table> arr;
	
	public TableBag(){
		arr = new ArrayList<>();
	}
	
	public void addTable(Table table){
		table.setReservedTable();
		arr.add(table);
	}
	
	public void deleteTable(String tableNumber){
		int i;
		for(i = 0; i < arr.size(); i++){
			if(arr.get(i).getTableNumber().equals(tableNumber)){
				arr.remove(arr.get(i));
			}else{
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Item not Found");
				alert.setContentText("Cannot find Table " + tableNumber);
				alert.showAndWait();
			}
		}
	}
	
	public Table findTable(String tableNumber){
		for(Table t: arr){
			if(t.getTableNumber().equals(tableNumber)){
				return t;
			}
		}
		return null;
	}
	
	public StringBuilder printAvailableTables(){
		StringBuilder sb = new StringBuilder();
		int openTableCount = 0;
		int reservedTableCount = 0;
		int i;
		for(i = 0; i < arr.size(); i++){
			if(arr.get(i).isReserved()){
			sb.append("Open Table Number: " + arr.get(i).getTableNumber() + "  Number of Seats: " + arr.get(i).getSeats() + System.lineSeparator());
			openTableCount++;
			}
		}
		
		if(openTableCount == 0){
			sb.append("No open tables");
		}
		
		return sb;
	}
}
