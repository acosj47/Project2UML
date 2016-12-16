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

public class ViewGuestPane {
	
	private Label lblDelete;
	private TextField tfDelete;
	private TextArea txtArea;
	private Button deleteBtn;
	private HBox hbox;
	private VBox vbox;
	private BorderPane pane;
	private MyManagerEventListener deleteGuestListener;
	
	public ViewGuestPane(){
		pane = new BorderPane();
		lblDelete = new Label("Enter ID of Guest to Delete:");
		tfDelete = new TextField();
		txtArea = new TextArea();
		deleteBtn = new Button("Remove Guest");
		hbox = new HBox(30);
		vbox = new VBox(30);
		hbox.getChildren().addAll(lblDelete, tfDelete, deleteBtn);
		hbox.setAlignment(Pos.CENTER);
		vbox.getChildren().addAll(hbox, txtArea);
		vbox.setAlignment(Pos.CENTER);
		pane.setCenter(vbox);
		
		deleteBtn.setOnAction(e -> {
			String id = tfDelete.getText();
			MyEventObject ev = new MyEventObject(this, id);
			if(deleteGuestListener != null){
				deleteGuestListener.okBtnClicked(ev);
			}
		});
	}
	
	public BorderPane getPane(){
		return pane;
	}
	
	public TextArea getTextArea(){
		return txtArea;
	}
	
	public void setDeleteGuestListener(MyManagerEventListener deleteGuestListener){
		this.deleteGuestListener = deleteGuestListener;
	}
	
	public MyManagerEventListener getDeleteGuestListener(){
		return deleteGuestListener;
	}
}
