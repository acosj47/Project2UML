package view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.MyEventFoodListener;
import model.MyEventFoodObject;
import model.MyEventObject;
import model.MyManagerEventListener;

public class DeleteFoodPane {
	private Label lblDelete;
	private TextField tfDelete;
	private TextArea txtArea;
	private Button deleteBtn;
	private HBox hbox;
	private VBox vbox;
	private BorderPane pane;
	private MyEventFoodListener deleteBtnListener;
	
	public DeleteFoodPane(){
		pane = new BorderPane();
		lblDelete = new Label("Enter SKU of Item to Delete:");
		tfDelete = new TextField();
		txtArea = new TextArea();
		deleteBtn = new Button("Remove Item");
		hbox = new HBox(30);
		vbox = new VBox(30);
		hbox.getChildren().addAll(lblDelete, tfDelete, deleteBtn);
		hbox.setAlignment(Pos.CENTER);
		vbox.getChildren().addAll(hbox, txtArea);
		vbox.setAlignment(Pos.CENTER);
		pane.setCenter(vbox);
		
		// store sku for deleting a food item
		deleteBtn.setOnAction(e -> {
			String sku = tfDelete.getText();
			System.out.println(sku);
			MyEventFoodObject ev = new MyEventFoodObject(this, sku);
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
	
	public void setDeleteBtnListener(MyEventFoodListener deleteBtnListener){
		this.deleteBtnListener = deleteBtnListener;
	}
}
