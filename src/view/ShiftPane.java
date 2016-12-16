package view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.MyEventObject;
import model.MyManagerEventListener;

public class ShiftPane {
	private BorderPane pane;
	private HBox hbox4Employee;
	private HBox hbox4Day;
	private HBox hbox4Start;
	private HBox hbox4End;
	private VBox vbox;
	private ComboBox<String> day;
	private Label lblDay;
	private ComboBox<String> startShift;
	private ComboBox<String> endShift;
	private ComboBox<String> startAMPM;
	private ComboBox<String> endAMPM;
	private Label lblStartShift;
	private Label lblEndShift;
	private Label lblEmployee;
	private TextField tfEmployee;
	private Button okBtn;
	private MyManagerEventListener okBtnListener;
	
	public ShiftPane(){
		pane = new BorderPane();
		hbox4Employee = new HBox(20);
		hbox4Day = new HBox(20);
		hbox4Start = new HBox(20);
		hbox4End = new HBox(20);
		vbox = new VBox(20);
		day = new ComboBox<String>();
		startShift = new ComboBox<String>();
		endShift = new ComboBox<String>();
		startAMPM = new ComboBox<String>();
		endAMPM = new ComboBox<String>();
		lblStartShift = new Label("Start Time: ");
		lblEndShift = new Label("End Time: ");
		lblDay = new Label("Day: ");
		lblEmployee = new Label("Enter Employee ID: ");
		tfEmployee = new TextField();
		okBtn = new Button("Set Shift");
		
		// fill combo boxes 
		day.getItems().addAll("Mon", "Tues", "Wens", "Thurs", "Fri", "Sat", "Sun");
		startAMPM.getItems().addAll("AM", "PM");
		endAMPM.getItems().addAll("AM", "PM");
		for (int i = 1; i <= 12; i++) {
			startShift.getItems().add(String.valueOf(i));
			endShift.getItems().add(String.valueOf(i));
		}
		
		hbox4Employee.getChildren().addAll(lblEmployee, tfEmployee);
		hbox4Employee.setAlignment(Pos.CENTER);
		hbox4Day.getChildren().addAll(lblDay, day);
		hbox4Start.getChildren().addAll(lblStartShift, startShift, startAMPM);
		hbox4End.getChildren().addAll(lblEndShift, endShift, endAMPM);
		hbox4Day.setAlignment(Pos.CENTER);
		hbox4Start.setAlignment(Pos.CENTER);
		hbox4End.setAlignment(Pos.CENTER);
		vbox.getChildren().addAll(hbox4Employee, hbox4Day, hbox4Start, hbox4End, okBtn);
		vbox.setAlignment(Pos.CENTER);
		pane.setCenter(vbox);
		
		okBtn.setOnAction(e -> {
			String id = tfEmployee.getText();
			int indexOfDay = day.getSelectionModel().getSelectedIndex();
			String start = startShift.getValue() + " " + startAMPM.getValue();
			String end = endShift.getValue() + " " + endAMPM.getValue();
			MyEventObject ev = new MyEventObject(this, id, indexOfDay, start, end);
			if(okBtnListener != null){
				okBtnListener.okBtnClicked(ev);
			}
			
			
		});
		

	}
	
	public BorderPane getPane(){
		return pane;
	}
	
	public void setOkBtnListener(MyManagerEventListener okBtnListener){
		this.okBtnListener = okBtnListener;
	}
}
