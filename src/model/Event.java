package model;

import java.util.GregorianCalendar;

public class Event {
	private GregorianCalendar date;
	private String title;
	private String eventNumber;
	private static int eventCounter;
	
	public Event(String title, int year, int month, int day, int hour, int minute){
		date = new GregorianCalendar(year, month, day, hour, minute);
		this.title = title;
		eventCounter++;
		eventNumber = String.valueOf(eventCounter);
	}

	public GregorianCalendar getDate() {
		return date;
	}

	public void setDate(GregorianCalendar date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getEventNumber() {
		return eventNumber;
	}
	
}
