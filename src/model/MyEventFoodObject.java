package model;

import java.util.EventObject;

public class MyEventFoodObject extends EventObject {
	private String sku;
	
	public MyEventFoodObject(Object source, String sku) {
		super(source);
		this.sku = sku;
	}
	
	public String getSku(){
		return sku;
	}

}
