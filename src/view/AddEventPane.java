package view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import model.MyEventObject;
import model.MyManagerEventListener;


public class AddEventPane {
	private BorderPane pane;
	private GridPane grid;
	private Label lblTitle;
	private Label lblYear;
	private Label lblDay;
	private Label lblMonth;
	private Label lblHour;
	private Label lblMinute;
	private Label lblAMPM;
	private Button okBtn;
	
	private TextField tfTitle;
	private TextField tfYear;
	private ComboBox<String> cbDay;
	private ComboBox<String> cbMonth;
	private ComboBox<String> cbHour;
	private ComboBox<String> cbMinute;
	private ComboBox<String> cbAMPM;
	private MyManagerEventListener okBtnEvent;
	
	public AddEventPane(){
		pane = new BorderPane();
		grid = new GridPane();
		lblTitle = new Label("Event Title");
		lblYear = new Label("Year");
		lblDay = new Label("Day");
		lblMonth = new Label("Month");
		lblHour = new Label("Hour");
		lblMinute = new Label("Minute");
		lblAMPM = new Label("AM/PM");
		tfTitle = new TextField();
		tfYear = new TextField();
		cbDay = new ComboBox<>();
		cbMonth = new ComboBox<>();
		cbHour = new ComboBox<>();
		cbMinute = new ComboBox<>();
		cbAMPM = new ComboBox<>();
		okBtn = new Button("Add Event");

		//fill combo boxes
		for(int i = 1; i <= 31; i++){
			cbDay.getItems().add(String.valueOf(i));
		}
		
		for(int i = 1; i <= 12; i++){
			cbHour.getItems().add(String.valueOf(i));
		}
		
		for(int i = 0; i <= 59; i++){
			cbMinute.getItems().add(String.valueOf(i));
		}
		
		cbMonth.getItems().addAll("Jan", "Feb", "Mar", "Apr", "May", "June", "July", "Aug", "Sept", "Oct", "Nov", "Dec");
		cbAMPM.getItems().addAll("AM", "PM");
		
		grid.add(lblTitle, 0, 0);
		grid.add(tfTitle, 1, 0);
		grid.add(lblMonth, 0, 1);
		grid.add(cbMonth, 1, 1);
		grid.add(lblDay, 0, 2);
		grid.add(cbDay, 1, 2);
		grid.add(lblYear, 0, 3);
		grid.add(tfYear, 1, 3);
		grid.add(lblHour, 2, 0);
		grid.add(cbHour, 3, 0);
		grid.add(lblMinute, 2, 1);
		grid.add(cbMinute, 3, 1);
		grid.add(lblAMPM, 2, 2);
		grid.add(cbAMPM, 3, 2);
		grid.add(okBtn, 3, 3);
		
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(20);
		grid.setVgap(20);
		pane.setCenter(grid);
		
		// store event variables
		okBtn.setOnAction(e -> {
			String title = tfTitle.getText();
			String year = tfYear.getText();
			String month = cbMonth.getValue();
			String day = cbDay.getValue();
			String hour = cbHour.getValue();
			String minute = cbMinute.getValue();
			String ampm = String.valueOf(cbAMPM.getValue());
			MyEventObject ev = new MyEventObject(this, title, year, month, day, hour, minute, ampm);
			if(okBtnEvent != null){
				okBtnEvent.okBtnClicked(ev);
			}
		});
		
		
	}
	
	public BorderPane getPane(){
		return pane;
	}
	
	public void setOkBtnEvent(MyManagerEventListener okBtnEvent){
		this.okBtnEvent = okBtnEvent;
	}
}
