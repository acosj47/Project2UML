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

public class DeleteEmployeePane {
	private Label lblDelete;
	private TextField tfDelete;
	private TextArea txtArea;
	private Button deleteBtn;
	private HBox hbox;
	private VBox vbox;
	private BorderPane pane;
	private MyManagerEventListener deleteBtnListener;
	
	public DeleteEmployeePane(){
		pane = new BorderPane();
		lblDelete = new Label("Enter ID of Employee to Delete:");
		tfDelete = new TextField();
		txtArea = new TextArea();
		deleteBtn = new Button("Remove Employee");
		hbox = new HBox(30);
		vbox = new VBox(30);
		hbox.getChildren().addAll(lblDelete, tfDelete, deleteBtn);
		hbox.setAlignment(Pos.CENTER);
		vbox.getChildren().addAll(hbox, txtArea);
		vbox.setAlignment(Pos.CENTER);
		pane.setCenter(vbox);
		
		// store id for deleting an employee
		deleteBtn.setOnAction(e -> {
			String id = tfDelete.getText();
			MyEventObject ev = new MyEventObject(this, id);
			if(deleteBtnListener != null){
				deleteBtnListener.okBtnClicked(ev);
			}
		});
	}
	
	public BorderPane getPane(){
		return pane;
	}
	
	public MyManagerEventListener getDeleteBtnListener(){
		return deleteBtnListener;
	}
	
	public void setDeleteBtnListener(MyManagerEventListener deleteBtnListener){
		this.deleteBtnListener = deleteBtnListener;
	}
	
	public TextArea getTextArea(){
		return txtArea;
	}
}
