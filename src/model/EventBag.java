package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class EventBag implements Serializable {
	private ArrayList<Event> arr;
	private String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "June", "July", "Aug", "Sept", "Oct", "Nov", "Dec"};
	
	public EventBag(){
		arr = new ArrayList<>();
	}
	
	public void add(Event event){
		arr.add(event);
	}
	
	public void delete(String id){  // I fixed this method on 11/24
		int i;
		for(i = 0; i < arr.size(); i++){
			
			
			if(arr.get(i).getEventNumber().equals(id)){
				arr.remove(arr.get(i));
				System.out.println("Event " + id + " deleted");
				break;
			}
		}
		
		if(i > arr.size()){
			System.out.println("Cannot delete Event '" + id + "', because it does not exists");

		}
		
	}
	
	public Event findEvent(String id ){  // I fixed this method on 11/20
		String AMPM  = "";
		boolean found = false;
		
		for(Event e : arr){
			if(e.getEventNumber().equals(id)){
				found = true;
				
				return e;
			}
		}
		
		if(found == false){
			System.out.println("could not find event " + id);
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Item not Found");
			alert.setContentText("Cannot find Event " + id);
			alert.showAndWait();
		}
		return null;
	
	}
	
	public StringBuilder toStringBuilder(){
		StringBuilder sb = new StringBuilder();
		for(Event e: arr){
			sb.append(e.getTitle() + " / Event ID:  " + e.getEventNumber() + System.lineSeparator());
		}
		return sb;
	}
	
	public void save() throws IOException, ClassNotFoundException {
		FileOutputStream fos = new FileOutputStream("events.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(arr);
		oos.close();
	}
	
	public void load() throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream("events.dat");
		ObjectInputStream ois = new ObjectInputStream(fis);
		arr = (ArrayList<Event>) ois.readObject();
		ois.close();
	}
}
