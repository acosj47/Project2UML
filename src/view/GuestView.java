package view;

import java.io.IOException;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.EventBag;
import model.FoodItemBag;
import model.Guest;
import model.MyEventListener;
import model.MyEventPersonObject;
import model.Person;
import model.TableBag;

public class GuestView {
	private Stage stage;
	private MenuBar menuBar;
	// event menu items
	private Menu events = new Menu("Events");
	private MenuItem yourEvents = new MenuItem("Your Events");
	private MenuItem findEvents = new MenuItem("Find Events");
	// food item menu items
	private Menu food = new Menu("Food");
	private MenuItem orderFood = new MenuItem("Order Food");
	private MenuItem yourOrders = new MenuItem("Your Orders");
	// table menu items, not used in final version
	private Menu tables = new Menu("Tables"); 
	private MenuItem reserveTable = new MenuItem("Reserve a Table");
	private MenuItem yourTables = new MenuItem("Your Tables");
	// invoice menu items
	private Menu invoice = new Menu("Invoice");
	private MenuItem payBill = new MenuItem("Pay Bill");
	// file menu items
	private Menu fileMenu = new Menu("File");
	private MenuItem saveFile = new MenuItem("Save");
	// sub panes
	private EventPane eventPane;
	private EventSearch4GuestPane eventSearch4Guest;
	private MyEventListener yourEventsListener;
	private String user;
	private Label lb;
	private FoodOrderHistoryPane foodOrderHistoryPane;
	private OrderFoodPane orderFoodPane;
	private InvoicePane invoicePane;
	private ReserveTablePane reserveTablePane;
	
	public GuestView(Stage stage, Person p, EventBag ev, FoodItemBag fb, TableBag tb){
		this.stage = stage;
		BorderPane pane = new BorderPane();
		eventPane = new EventPane(p);
		eventSearch4Guest = new EventSearch4GuestPane(p, ev);
		foodOrderHistoryPane = new FoodOrderHistoryPane(p);
		reserveTablePane = new ReserveTablePane(p, tb);
		orderFoodPane = new OrderFoodPane(p, fb);
		invoicePane = new InvoicePane(p);
		Label lb = new Label("Welcome " + p.getUsername());
		menuBar = new MenuBar();
		menuBar.getMenus().addAll(events, food, invoice, fileMenu);
		events.getItems().addAll(findEvents, yourEvents);
		food.getItems().addAll(orderFood, yourOrders);
		tables.getItems().addAll(reserveTable, yourTables);
		fileMenu.getItems().add(saveFile);
		invoice.getItems().add(payBill);
		pane.setTop(menuBar);
		pane.setCenter(lb);
		Scene scene = new Scene(pane, 600, 400);
		stage.setScene(scene);
		stage.setTitle("Welcome " + p.getUsername());
		stage.show();
		
		// menu item handlers
		yourEvents.setOnAction(e -> {
			pane.setCenter(eventPane.getPane());
			eventPane.getTextArea().setText(((Guest) p).getEventHistory().toStringBuilder().toString());
			
		});
		findEvents.setOnAction(e -> pane.setCenter(eventSearch4Guest.getPane()));
		
		yourOrders.setOnAction(e -> {
			pane.setCenter(foodOrderHistoryPane.getPane());
			foodOrderHistoryPane.getTextArea().setText(((Guest)p).getOrder().getFoodItemArray().toString());
			System.out.println(((Guest)p).getOrder().getFoodItemArray().toString());
		});
		
		orderFood.setOnAction(e -> pane.setCenter(orderFoodPane.getPane()));
		
		reserveTable.setOnAction(e -> {
			pane.setCenter(reserveTablePane.getPane());
		});
		
		payBill.setOnAction(e -> { 
			pane.setCenter(invoicePane.getPane());
			invoicePane.getTextArea().setText(((Guest)p).getOrder().getFoodItemArray().toString());
			invoicePane.getAmountLabel().setText(String.valueOf(((Guest)p).getOrder().getTotalPrice()));
		});
		
		saveFile.setOnAction(e -> {
			try {
				ev.save();
				fb.save();
				
			} catch (ClassNotFoundException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		});
		
		
	}
	
	// getters and setters
	public MyEventListener getYourEventsListener(){
		return yourEventsListener;
	}
	
	public void setUser(String username){
		stage.setTitle("Welcome " + username);
	}
	
	public void setWelcomeLabel(String s1){
		lb.setText("Welcome " + s1);
	}
	
	public Stage getStage(){
		return stage;
	}
	
	
	
}
