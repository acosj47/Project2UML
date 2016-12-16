package view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Guest;
import model.MyEventListener;
import model.Person;

public class FoodOrderHistoryPane {
	private BorderPane pane = new BorderPane();
	private TextArea txtArea = new TextArea();
	private Label lblEvent = new Label("Delete Event by Entering Event ID: ");
	private TextField tfEvent = new TextField();
	private Label lblHistory = new Label("Your Food Orders");
	private Button deleteBtn = new Button("Delete Event");
	private Button historyBtn = new Button("View Event History");
	private HBox hbox4Join = new HBox(20);
	private HBox hbox4History = new HBox(20);
	private VBox vbox = new VBox(30);
	private MyEventListener deleteBtnListener;
	
	public FoodOrderHistoryPane (Person p){
        txtArea.setEditable(false);
		//hbox4Join.getChildren().addAll(lblEvent, tfEvent);
		//hbox4Join.setAlignment(Pos.CENTER);
		//hbox4History.getChildren().add(lblHistory);
		hbox4History.setAlignment(Pos.CENTER);
		vbox.getChildren().addAll(lblHistory, txtArea);
		vbox.setAlignment(Pos.CENTER);
		pane.setCenter(vbox);
		
		
	}
	
	public BorderPane getPane(){
		return pane;
	}
	
	public TextArea getTextArea(){
		return txtArea;
	}
	
	public MyEventListener getDeleteBtnListener(){
		return deleteBtnListener;
	}
	
}
