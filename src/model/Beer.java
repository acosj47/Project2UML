package model;

public class Beer extends FoodItem {
	
	private String brand;
	private String type;
	
	public Beer(String name, String sku, double price, String brand, String type) {
		super(name, sku, price);
		this.brand = brand;
		this.type = type;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
	
	

}
