package controllers;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import model.Address;
import model.Guest;
import model.MyEventListener;
import model.MyEventPersonObject;
import model.PersonBag;
import view.NewGuestSignUp;

public class SignUpController {

		public SignUpController(PersonBag bag, NewGuestSignUp view){
			
			// handles new Guest signup, creates new guest and adds them to the bag, which then allows new users to login via the Guest controller
			view.setOkBtnListener(new MyEventListener(){

				@Override
				public void okBtnClicked(MyEventPersonObject mepo) {
					
					try {
						Address address = new Address(mepo.getStreetName(), mepo.getStreetNumber(), mepo.getCity(), mepo.getState(), mepo.getZip());
						Guest guest = new Guest(mepo.getFirstName(), mepo.getLastName(), mepo.getUsername(), mepo.getPassword(), address);
						bag.add(guest);
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("New User Created");
						alert.setHeaderText("New Guest Account Created");
						alert.setContentText( "Name: " + mepo.getFirstName() + " " + mepo.getLastName() + System.lineSeparator() + 
											  "Username: " + mepo.getUsername() + System.lineSeparator() + 
											  address.toString());
						alert.showAndWait();
					} catch (NullPointerException ex) {
						Alert alert = new Alert(AlertType.WARNING);
						alert.setTitle("Sign up Error");
						alert.setContentText("Please do not leave any field blank");
						alert.showAndWait();
						ex.printStackTrace();
					}
				}
				
			});
		}
}
