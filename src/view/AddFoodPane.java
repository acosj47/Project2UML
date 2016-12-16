package view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.MyEventObject;
import model.MyManagerEventListener;

public class AddFoodPane {
	private BorderPane pane;
	private GridPane grid;
	private Label lblName;
	private Label lblSku;
	private Label lblPrice;
	private TextField tfName;
	private TextField tfSku;
	private TextField tfPrice;
	private Button btnOk;
	private MyManagerEventListener okBtnListener;
	
	public AddFoodPane(){
		pane = new BorderPane();
		grid = new GridPane();
		lblName = new Label("Name: ");
		lblSku = new Label("SKU: ");
		lblPrice = new Label("Price: ");
		tfName = new TextField();
		tfSku = new TextField();
		tfPrice = new TextField();
		btnOk = new Button("Add Food Item");
		
		grid.add(lblName, 0, 0);
		grid.add(tfName, 1, 0);
		grid.add(lblSku, 0, 1);
		grid.add(tfSku, 1, 1);
		grid.add(lblPrice, 0, 2);
		grid.add(tfPrice, 1, 2);
		grid.add(btnOk, 1, 3);
		
		grid.setHgap(5);
		grid.setVgap(5);
		grid.setAlignment(Pos.CENTER);
		
		pane.setCenter(grid);
		
		// store food variables
		btnOk.setOnAction(e -> {
			String name = tfName.getText();
			String sku = tfSku.getText();
			double price = Double.valueOf(tfPrice.getText());
			MyEventObject ev = new MyEventObject(this, name, sku, price);
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
