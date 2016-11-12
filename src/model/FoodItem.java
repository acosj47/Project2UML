package model;

public class FoodItem {
	private double price;
	private String name;
	private String sku;
	private String orderNumber;
	private int orderCounter;
	
	public FoodItem(String name, String sku, double price){
		this.name = name;
		this.price = price;
		this.sku = sku;
		orderCounter++;
		orderNumber = String.valueOf(orderCounter);
	}
	
	public double getPrice(){
		return price;
	}
	
	public String getName(){
		return name;
	}
	
	public String getSku(){
		return sku;
	}
	
	public void setSku(String sku){
		this.sku = sku;
	}
}
