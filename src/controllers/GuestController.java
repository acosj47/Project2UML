package controllers;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import model.EventBag;
import model.FoodItemBag;
import model.MyEventListener;
import model.MyEventPersonObject;
import model.PersonBag;
import model.TableBag;
import view.GuestView;
import view.SignInWindow;

public class GuestController {
	
	public GuestController(PersonBag bag, SignInWindow view, EventBag eventBag, FoodItemBag fb, TableBag tb){
		
		//  handler that takes guest username and password and opens up the guestview
			view.setOkBtnListener(new MyEventListener(){
				
				@Override
				public void okBtnClicked(MyEventPersonObject ev) {
					Stage stage = new Stage();

					String s1 = ev.getUsername();
					String s2 = ev.getPassword();
					
					try{
						GuestView gv = new GuestView(stage, bag.findPersonByUser(ev.getUsername(), ev.getPassword()), eventBag, fb, tb);
						view.getStage().close();
				}catch(NullPointerException e){
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Sign in Error");
					alert.setContentText("Incorrect Username and/or Password");
					alert.showAndWait();

				}
			}
		
	});
			
			
 }
}
