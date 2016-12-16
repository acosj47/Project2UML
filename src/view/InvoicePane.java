package view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Guest;
import model.MyEventListener;
import model.Person;

public class InvoicePane {
	private BorderPane pane = new BorderPane();
	private TextArea txtArea = new TextArea();
	private Label lblPay = new Label("Pay your bill and clear order history: ");
	private Label lblAmount;
	private Label lblInvoice = new Label("Invoice");
	private Button payBtn = new Button("Pay Amount");
	private Button historyBtn = new Button("View Event History");
	private HBox hbox = new HBox(20);
	private HBox hbox4History = new HBox(20);
	private VBox vbox = new VBox(30);
	private MyEventListener payBtnListener;
	
	public InvoicePane(Person p){
		txtArea.setEditable(false);
		lblAmount = new Label(String.valueOf(((Guest)p).getOrder().getTotalPrice()));
		txtArea.setText(((Guest)p).getOrder().getFoodItemArray().toString());
		hbox.getChildren().addAll(lblPay, lblAmount, payBtn);
		vbox.getChildren().addAll(txtArea, hbox);
		hbox.setAlignment(Pos.CENTER);
		vbox.setAlignment(Pos.CENTER);
		pane.setCenter(vbox);
		
		payBtn.setOnAction(e ->{
			((Guest)p).getOrder().removeAll();
			txtArea.setText(((Guest)p).getOrder().getFoodItemArray().toString());
			lblAmount.setText("0");
		});
	}
	
	public BorderPane getPane(){
		return pane;
	}
	
	public TextArea getTextArea(){
		return txtArea;
	}
	
	public Label getAmountLabel(){
		return lblAmount;
	}
}
