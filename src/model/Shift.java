package model;

public class Shift {
	private static final String[] daysOfWeek = { "MON", "TUES", "WENS", "THURS", "FRI", "SAT", "SUN" };
	private String[][] shift;
	
	
	public Shift(){
		shift = new String[7][3];
		for(int i = 0; i < shift.length; i++){
			shift[i][0] = daysOfWeek[i];
		}
	}
	
	public void setDayTime(int i, String startShift, String endShift){
		shift[i][1] = startShift;
		shift[i][2] = endShift;
	}
	
	public String[][] getArray(){
		return shift;
	}
}
