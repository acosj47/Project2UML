package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class FoodItemBag implements Serializable {
	ArrayList<FoodItem> arr;
	
	public FoodItemBag() {
		arr = new ArrayList<>();
	}
	
	public void add(FoodItem item){
		arr.add(item);
	}
	
	public FoodItem findBySku(String sku){
		int i;
		for(i = 0; i < arr.size(); i++){
			if(arr.get(i).getSku().equals(sku)){
				return arr.get(i);
			}
		}
		
		if(i > arr.size()){
			System.out.println("could not find event " + sku);
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Item not Found");
			alert.setContentText("Cannot find Event " + sku);
			alert.showAndWait();
		}
		return null;
	}
	
	public void deleteBySku(String sku){
		int i;
		for(i = 0; i < arr.size(); i++){
			if(arr.get(i).getSku().equals(sku)){
				arr.remove(i);
			}
		}
		
		if(i > arr.size()){
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Item not Found");
			alert.setContentText("Cannot find Item with SKU number " + sku);
			alert.showAndWait();
		}
	}
	
	public StringBuilder getFoodItemArray(){
		StringBuilder sb = new StringBuilder();
		for(FoodItem f: arr){
			sb.append(f.getName() + " $" + f.getPrice() + "   SKU: " + f.getSku() +  System.lineSeparator());
		}
		return sb;
	}
	
	public double getTotalPrice(){
		double total = 0;
		
		for(FoodItem f: arr){
			total = f.getPrice() + total;
		}
		return total;
	}
	
	public void removeAll(){
		for(int i = 0; i < arr.size(); i++){
			arr.remove(arr.get(i));
		}
	}
	
	public void save() throws IOException, ClassNotFoundException {
		FileOutputStream fos = new FileOutputStream("food.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(arr);
		oos.close();
	}
	
	public void load() throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream("food.dat");
		ObjectInputStream ois = new ObjectInputStream(fis);
		arr = (ArrayList<FoodItem>) ois.readObject();
		ois.close();
	}
}
