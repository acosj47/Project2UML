package view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.MyEventListener;
import model.MyEventObject;
import model.MyManagerEventListener;

public class ManagerDeleteEventPane {
	private BorderPane pane = new BorderPane();
	private TextArea txtArea = new TextArea();
	private Label lblEvent = new Label("Delete Event by Entering Event ID: ");
	private TextField tfEvent = new TextField();
	private Label lblHistory = new Label("List of Events Created");
	private Button deleteBtn = new Button("Delete Event");
	private HBox hbox4Join = new HBox(20);
	private HBox hbox4History = new HBox(20);
	private VBox vbox = new VBox(30);
	private MyManagerEventListener deleteBtnListener;
	
	public ManagerDeleteEventPane(){
		
		txtArea.setEditable(false);
	    hbox4Join.getChildren().addAll(lblEvent, tfEvent, deleteBtn);
		hbox4Join.setAlignment(Pos.CENTER);
		hbox4History.getChildren().add(lblHistory);
		hbox4History.setAlignment(Pos.CENTER);
		vbox.getChildren().addAll(hbox4Join, hbox4History, txtArea);
		pane.setCenter(vbox);
		
		deleteBtn.setOnAction(e -> {
			String id = tfEvent.getText();
			MyEventObject ev = new MyEventObject(this, id);
			if(deleteBtnListener != null){
				deleteBtnListener.okBtnClicked(ev);
			}
		});
		
		
	}
	
	public BorderPane getPane(){
		return pane;
	}
	
	public TextArea getTextArea(){
		return txtArea;
	}
	
	public void setDeleteBtnListener(MyManagerEventListener deleteBtnListener){
		this.deleteBtnListener = deleteBtnListener;
	}
	
	
}
