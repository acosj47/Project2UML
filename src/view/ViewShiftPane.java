package view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.MyEventObject;
import model.MyManagerEventListener;

public class ViewShiftPane {

	private Label lblViewShift;
	private TextField tfEmployee;
	private TextArea txtArea;
	private Button viewShiftBtn;
	private HBox hbox;
	private VBox vbox;
	private BorderPane pane;
	private MyManagerEventListener viewShiftBtnListener;
	
	public ViewShiftPane(){
		pane = new BorderPane();
		lblViewShift = new Label("Enter ID of Employee to view their shift:");
		tfEmployee = new TextField();
		txtArea = new TextArea();
		viewShiftBtn = new Button("View Shift");
		hbox = new HBox(30);
		vbox = new VBox(30);
		hbox.getChildren().addAll(lblViewShift, tfEmployee, viewShiftBtn);
		hbox.setAlignment(Pos.CENTER);
		vbox.getChildren().addAll(hbox, txtArea);
		vbox.setAlignment(Pos.CENTER);
		pane.setCenter(vbox);
		
		viewShiftBtn.setOnAction(e -> {
			String id = tfEmployee.getText();
			MyEventObject ev = new MyEventObject(this, id);
			if(viewShiftBtnListener != null){
				viewShiftBtnListener.okBtnClicked(ev);
			}
		});
		
	}
	
	public BorderPane getPane(){
		return pane;
	}
	
	public TextArea getTextArea(){
		return txtArea;
	}
	
	public void setViewShiftBtnListener(MyManagerEventListener viewShiftBtnListener){
		this.viewShiftBtnListener = viewShiftBtnListener;
	}
	
}
