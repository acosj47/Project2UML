package model;

public class DemoBag {

	public static void main(String[] args) {
		MasterEventBag bag = new MasterEventBag();
		Event event = new Event("TGIF", 2016, 3, 10, 3, 50 );
		
		bag.add(event);
		bag.findEvent("TGIF");
	}

}
