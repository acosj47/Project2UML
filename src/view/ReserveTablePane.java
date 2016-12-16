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
import model.Person;
import model.TableBag;

public class ReserveTablePane {
	private BorderPane pane = new BorderPane();
	private TextArea txtArea = new TextArea();
	private Label lblReserveTable = new Label("Reserve Table by Entering Table Number: ");
	private TextField tfTable = new TextField();
	private Label lblAvailableTables = new Label("Available Tables");
	private Button reserveBtn = new Button("Reserve Table");
	private Button historyBtn = new Button("View Event History");
	private HBox hbox4Reserve = new HBox(20);
	private HBox hbox4History = new HBox(20);
	private VBox vbox = new VBox(30);
	private MyEventListener joinBtnListener;
	
	public ReserveTablePane(Person p, TableBag tb){
		
        txtArea.setEditable(false);
		txtArea.setText(tb.printAvailableTables().toString());
		hbox4Reserve.getChildren().addAll(lblReserveTable, tfTable, reserveBtn);
		hbox4Reserve.setAlignment(Pos.CENTER);
		//hbox4History.getChildren().add(lblEventUpcoming);
		//hbox4History.setAlignment(Pos.CENTER);
		vbox.getChildren().addAll(hbox4Reserve, txtArea);
		pane.setCenter(vbox);
		
		reserveBtn.setOnAction(e -> { // put in try catch for null pointer
			((Guest)p).reserveTable(tb.findTable(tfTable.getText()));
			tb.findTable(tfTable.getText()).setReservedTable();
			//tb.deleteTable(tfTable.getText());
			txtArea.setText(tb.printAvailableTables().toString());

		});
	}
	
	public BorderPane getPane(){
		return pane;
	}
}
