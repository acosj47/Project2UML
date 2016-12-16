package controllers;

import java.io.IOException;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import model.Address;
import model.Employee;
import model.Event;
import model.EventBag;
import model.FoodItem;
import model.FoodItemBag;
import model.MyEventFoodListener;
import model.MyEventFoodObject;
import model.MyEventObject;
import model.MyManagerEventListener;
import model.PersonBag;
import model.Shift;
import view.ManagerView;

public class EmployeeController {
	// handles all Manager view events
	public EmployeeController(PersonBag employeeBag, PersonBag guestBag, EventBag eventBag , FoodItemBag foodBag, ManagerView view){
		
		// add employee handler
		view.getAddEmployeePane().setOkBtnListener( new MyManagerEventListener(){

			@Override
			public void okBtnClicked(MyEventObject ev) {
				try {
					Address address = new Address(ev.getStreetName(), ev.getStreetNumber(), ev.getCity(), ev.getState(), ev.getZip());
					Employee employee = new Employee(ev.getFirstName(), ev.getLastName(), ev.getUsername(), ev.getPassword(), address, ev.getTitle(), ev.getWage());
					employeeBag.add(employee);
					view.getDeleteEmployeePane().getTextArea().setText(employeeBag.toStringBuilder().toString());
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("New Employee Account Created");
					alert.setHeaderText("New Employee Added");
					alert.setContentText( "Name: " + ev.getFirstName() + " " + ev.getLastName() + System.lineSeparator() + 
										  "Username: " + ev.getUsername() + System.lineSeparator() + 
										  address.toString());
					alert.showAndWait();
				} catch (NullPointerException | NumberFormatException ex) {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Sign up Error");
					alert.setContentText("Please do not leave any field blank");
					alert.showAndWait();
					ex.printStackTrace();
				}
			}
			
		});
		
		//  updates list of employee when clicking on the "remove employee" menu item
		view.getDeleteEmployeePane().getTextArea().setText(employeeBag.toStringBuilder().toString());
		
		//  delete employee handler
		view.getDeleteEmployeePane().setDeleteBtnListener( new MyManagerEventListener(){

			@Override
			public void okBtnClicked(MyEventObject ev) {
				employeeBag.delete(ev.getId());
				view.getDeleteEmployeePane().getTextArea().setText(employeeBag.toStringBuilder().toString());
			}
			
		});
		
		// remove employee menu-item event handle
		view.setRemoveListener( new MyManagerEventListener(){

			@Override
			public void okBtnClicked(MyEventObject ev) {
				view.getDeleteEmployeePane().getTextArea().setText(employeeBag.toStringBuilder().toString());

			}
			
		});
		
		//  updates list of guests in the Manager view when clicking guest menu item
		view.setViewGuestListener( new MyManagerEventListener(){

			@Override
			public void okBtnClicked(MyEventObject ev) {
				view.getViewGuestPane().getTextArea().setText(guestBag.toStringBuilder().toString());
			}
			
		});
		
		//  delete guest handler for manager view
		view.getViewGuestPane().setDeleteGuestListener( new MyManagerEventListener(){

			@Override
			public void okBtnClicked(MyEventObject ev) {
				guestBag.delete(ev.getId());
				view.getViewGuestPane().getTextArea().setText(guestBag.toStringBuilder().toString());

			}
			
		});
		
		//  add event handler for manager view
		view.getAddEventPane().setOkBtnEvent( new MyManagerEventListener(){

			@Override
			public void okBtnClicked(MyEventObject ev) {
				Event e1 = new Event(ev.getEventTitle(), ev.getYear(), ev.getMonth(), ev.getDay(), ev.getHour(), ev.getMinute(), ev.getAmpm());
				eventBag.add(e1);
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("New Event Created");
				alert.setHeaderText("New Event Added");
				alert.setContentText( "Title: " + ev.getEventTitle() + System.lineSeparator() + 
									  "Date: " + ev.getMonth() + "/" + ev.getDay() + "/" + ev.getYear() + System.lineSeparator() + 
									  "Time: " + ev.getHour() + ":" + ev.getMinute() + " " + ev.getAmpm());
				alert.showAndWait();
			}
			
		});
		
		// "remove-event" menu-item handler, updates textfield when remove-event menu item is clicked
		view.setRemoveEventListener(new MyManagerEventListener(){

			@Override
			public void okBtnClicked(MyEventObject ev) {
				view.getDeleteEventPane().getTextArea().setText(eventBag.toStringBuilder().toString());
			}
			
		});
		
		//  delete event handler for manager view
		view.getDeleteEventPane().setDeleteBtnListener( new MyManagerEventListener(){

			@Override
			public void okBtnClicked(MyEventObject ev) {
				eventBag.delete(ev.getId());
				view.getDeleteEventPane().getTextArea().setText(eventBag.toStringBuilder().toString());

			}
			
		});
		
		// set shift handler
		view.getShiftPane().setOkBtnListener( new MyManagerEventListener(){

			@Override
			public void okBtnClicked(MyEventObject ev) {
				Shift shift = new Shift();
				shift.setDayTime(ev.getIndexOfDay(), ev.getStartTime(), ev.getEndTime());
				((Employee) employeeBag.findPerson(ev.getId())).setShift(shift);
			}
			
		});
		
		
		view.getViewShiftPane().setViewShiftBtnListener( new MyManagerEventListener(){  // fix how shift works

			@Override
			public void okBtnClicked(MyEventObject ev) {
				view.getViewShiftPane().getTextArea().setText(((Employee) employeeBag.findPerson(ev.getId())).getShift().toString());
			}
			
		});
		
		// add food handler
		view.getAddFoodPane().setOkBtnListener(new MyManagerEventListener(){

			@Override
			public void okBtnClicked(MyEventObject ev) {
				FoodItem f = new FoodItem(ev.getName(), ev.getSku(), ev.getPrice());
				foodBag.add(f);
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Food Item Created");
				alert.setHeaderText("New Food Item Added");
				alert.setContentText( "Food Item: " + ev.getName() + System.lineSeparator() + 
									  "SKU: " + ev.getSku() + System.lineSeparator() + 
									  "Price: " + ev.getPrice());
				alert.showAndWait();
			}
			
		});
		
		//  delete food item handler for manager view
		view.getDeleteFoodPane().setDeleteBtnListener( new MyEventFoodListener(){

			@Override
			public void okBtnClicked(MyEventFoodObject ev) {
				foodBag.deleteBySku(ev.getSku());
				view.getDeleteFoodPane().getTextArea().setText(foodBag.getFoodItemArray().toString());

			}
			
		});
		
		
		// delete food menu item handler
		view.setDeleteFoodListener(new MyManagerEventListener(){

			@Override
			public void okBtnClicked(MyEventObject ev) {
				view.getDeleteFoodPane().getTextArea().setText(foodBag.getFoodItemArray().toString());
			}
			
		});
		
		//save file handler
		view.setFileListener(new MyManagerEventListener(){

			@Override
			public void okBtnClicked(MyEventObject ev) {
				try {
					foodBag.save();
					eventBag.save();
					employeeBag.save();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		});
	}
}
