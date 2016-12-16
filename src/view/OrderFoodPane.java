package view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.FoodItemBag;
import model.Guest;
import model.MyEventListener;
import model.Person;

public class OrderFoodPane {
	private BorderPane pane = new BorderPane();
	private TextArea txtArea = new TextArea();
	private Label lblOrderFood = new Label("Order Item by Entering SKU: ");
	private TextField tfFood = new TextField();
	private Label lblCurrentMenu = new Label("Menu Items");
	private Button orderBtn = new Button("Order Item");
	private HBox hbox4Order = new HBox(20);
	private HBox hbox4History = new HBox(20);
	private VBox vbox = new VBox(30);
	private MyEventListener joinBtnListener;
	
	
	public OrderFoodPane(Person p, FoodItemBag foodBag){
		txtArea.setText(foodBag.getFoodItemArray().toString());
		hbox4Order.getChildren().addAll(lblOrderFood, tfFood, orderBtn);
		hbox4Order.setAlignment(Pos.CENTER);
		vbox.getChildren().addAll(hbox4Order, lblCurrentMenu, txtArea);
		vbox.setAlignment(Pos.CENTER);
		pane.setCenter(vbox);
		
		orderBtn.setOnAction(e-> {
			((Guest)p).orderFood(foodBag.findBySku(tfFood.getText()));
		});
	}
	
	public BorderPane getPane(){
		return pane;
	}
}
