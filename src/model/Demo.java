package model;

public class Demo {

	public static void main(String[] args) {
		Shift s = new Shift();
		Address a = new Address("146",  "hill", "brentwood", "NY", "11717");
		FoodItem f = new FoodItem("Nachos", "1123", 8.95);
		Guest g = new Guest("justin", "acosta", "username", "password", a);
		
		g.orderFood(f);
		g.setBill(f.getPrice());
		
		System.out.println(g);
		
		s.setDayTime(0, "6:00PM", "3:00AM");
		s.setDayTime(1, "9:00PM", "1:00AM");
		s.setDayTime(2, "4:00PM", "10:00PM");
		s.setDayTime(3, "6:00PM", "3:00AM");
		s.setDayTime(4, "6:00PM", "3:00AM");
		s.setDayTime(5, "6:00PM", "3:00AM");
		s.setDayTime(6, "6:00PM", "3:00AM");
		
		

		
		for(int i = 0; i < s.getArray().length; i++ ){
			System.out.println(s.getArray()[i][0] + " " + s.getArray()[i][1] + " - " + s.getArray()[i][2]);
			System.out.println();
		}
	}

}
