package model;

public class Wine extends FoodItem{
	private String vintage;
	private String type;
	
	public Wine(String name, String sku, double price, String vintage, String type) {
		super(name, sku, price);
		this.vintage = vintage;
		this.type = type;
	}
	
	public void setVintage(String vintage){
		this.vintage = vintage;
	}
	
	public String getVintage(){
		return vintage;
	}
	
	public void setType(String type){
		this.type = type;
	}
	
	public String getType(){
		return type;
	}

}
