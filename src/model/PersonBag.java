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

public class PersonBag implements Serializable {
	private ArrayList<Person> arr;
	
	public PersonBag(){
		arr = new ArrayList<>();
	}
	
	public void add(Person person){
		arr.add(person);
	}
	
	public void delete(String id){
		int i;
		for(i = 0; i < arr.size(); i++){
			
			
			if(arr.get(i).getId().equals(id)){
				arr.remove(arr.get(i));
				System.out.println("Event " + id + " deleted");
				break;
			}
		}
		
		if(i >= arr.size()){
			System.out.println("Cannot delete Event '" + id + "', because it does not exists");
			Alert alert = new Alert(AlertType.WARNING);
			alert.setContentText("Employee with ID# " + id + " does not exisits");
			alert.showAndWait();
		}
	}
	
	public Person findPerson(String id){
		boolean found = false;
		for(Person p: arr){
			if(p.getId().equals(id)){
				found = true;
				return p;
			}
		}
		
		if(found == false){
			System.out.println("Cannot find person with ID number " + id);
		}
		return null;
	}
	
	public Person findPersonByUser(String user, String password){
		boolean found = false;
		for(Person p: arr){
			if(p.getUsername().equals(user) && p.getPassword().equals(password)){
				found = true;
				return p;
			}
		}
		
		if(found == false){
			System.out.println("Username or Password incorrect " + user);
		}
		return null;
	}
	
	public StringBuilder toStringBuilder(){
		StringBuilder sb = new StringBuilder();
		for(Person p: arr){
			sb.append("Name: " + p.getFirstName() + " " + p.getLastName() + " / ID#:  " + p.getId() + System.lineSeparator());
		}
		return sb;
	}
	
	public void save() throws IOException, ClassNotFoundException {
		FileOutputStream fos = new FileOutputStream("people.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(arr);
		oos.close();
	}
	
	public void load() throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream("people.dat");
		ObjectInputStream ois = new ObjectInputStream(fis);
		arr = (ArrayList<Person>) ois.readObject();
		ois.close();
	}
	
	
	
	
}
