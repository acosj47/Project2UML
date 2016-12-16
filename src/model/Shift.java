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
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < getArray().length; i++ ){
			sb.append(getArray()[i][0] + " " + getArray()[i][1] + " - " + getArray()[i][2] + System.lineSeparator());
			//System.out.println();
		}
		
		return sb.toString();
	}
}
