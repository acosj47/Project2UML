package view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.EventBag;
import model.Guest;
import model.MyEventListener;
import model.MyEventPersonObject;
import model.Person;

public class EventSearch4GuestPane {
	private BorderPane pane = new BorderPane();
	private TextArea txtArea = new TextArea();
	private Label lblEventJoin = new Label("Join Event by Entering Event Title: ");
	private TextField tfEvent = new TextField();
	private Label lblEventUpcoming = new Label("Upcoming Events");
	private Button joinBtn = new Button("Join Event");
	private Button historyBtn = new Button("View Event History");
	private HBox hbox4Join = new HBox(20);
	private HBox hbox4History = new HBox(20);
	private VBox vbox = new VBox(30);
	private MyEventListener joinBtnListener;
	
	public EventSearch4GuestPane(Person p, EventBag ev){
		
        txtArea.setEditable(false);
		txtArea.setText(ev.toStringBuilder().toString());
		hbox4Join.getChildren().addAll(lblEventJoin, tfEvent, joinBtn);
		hbox4Join.setAlignment(Pos.CENTER);
		hbox4History.getChildren().add(lblEventUpcoming);
		hbox4History.setAlignment(Pos.CENTER);
		vbox.getChildren().addAll(hbox4Join, hbox4History, txtArea);
		pane.setCenter(vbox);
		
		joinBtn.setOnAction(e -> {
			((Guest)p).joinEvent(ev.findEvent(tfEvent.getText()));
			
		});
	}
	
	public BorderPane getPane(){
		return pane;
	}
}
