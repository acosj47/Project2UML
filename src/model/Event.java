package model;

import java.io.Serializable;
import java.util.GregorianCalendar;

public class Event implements Serializable {
	private GregorianCalendar date;
	private String title;
	private String year;
	private String month;
	private String day;
	private String hour;
	private String minute;
	private String ampm;
	private String eventNumber;
	private static int eventCounter;
	
	public Event(String title, String year, String month, String day, String hour, String minute, String ampm){
		this.title = title;
		this.year = year;
		this.month = month;
		this.day = day;
		this.hour = hour;
		this.minute = minute;
		this.ampm = ampm;
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

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

	public String getMinute() {
		return minute;
	}

	public void setMinute(String minute) {
		this.minute = minute;
	}

	public String getAmpm() {
		return ampm;
	}

	public void setAmpm(String ampm) {
		this.ampm = ampm;
	}
	
	
	
}
