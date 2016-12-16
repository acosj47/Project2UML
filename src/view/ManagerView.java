package view;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.MyEventListener;
import model.MyEventObject;
import model.MyManagerEventListener;

public class ManagerView {
	private BorderPane pane;
	private Stage stage = new Stage();
	private MenuBar menuBar;
	// emloyee menu items
	private Menu employMenu = new Menu("Employees");
	private MenuItem addEmployee = new MenuItem("Register New Employee");
	private MenuItem removeEmployee = new MenuItem("View & Remove");
	// event menu items
	private Menu eventMenu = new Menu("Events");
	private MenuItem addEvent = new MenuItem("Add Events");
	private MenuItem removeEvent = new MenuItem("Remove Events");
	//food item menu items
	private Menu foodMenu = new Menu("Food");
	private MenuItem addFood = new MenuItem("Add Food Items");
	private MenuItem deleteFood = new MenuItem("Remove Food Items");
	// guest menu items
	private Menu guestMenu = new Menu("Guests");
	private MenuItem viewGuests = new MenuItem("View Guests");
	// shift menu items
	private Menu shiftMenu = new Menu("Shifts");
	private MenuItem addShifts = new MenuItem("Set Shifts");
	private MenuItem viewShifts = new MenuItem("View Shifts");
	// file menu items
	private Menu fileMenu = new Menu("File");
	private MenuItem saveFile = new MenuItem("Save");
	// table menu items, not used in final version
	private Menu tableMenu = new Menu("Tables");
	// sub panes
	private AddEmployeePane addEmployeePane;
	private DeleteEmployeePane deleteEmployeePane;
	private ViewGuestPane viewGuestPane;
	private AddEventPane addEventPane;
	private ManagerDeleteEventPane deleteEventPane;
	private ShiftPane shiftPane;
	private ViewShiftPane viewShiftPane;
	private AddFoodPane addFoodPane;
	private DeleteFoodPane deleteFoodPane;
	// event listeners
	private MyManagerEventListener removeListener;
	private MyManagerEventListener viewGuestListener;
	private MyManagerEventListener removeEventListener;
	private MyManagerEventListener viewShiftListener;
	private MyManagerEventListener deleteFoodListener;
	private MyManagerEventListener fileListener;
	
	public ManagerView(Stage stage){
		this.stage = stage;
		pane = new BorderPane();
		menuBar = new MenuBar();
		menuBar.getMenus().addAll(employMenu, guestMenu, eventMenu, shiftMenu, foodMenu, fileMenu); 
		employMenu.getItems().addAll(addEmployee, removeEmployee);
		guestMenu.getItems().add(viewGuests);
		eventMenu.getItems().addAll(addEvent, removeEvent);
		shiftMenu.getItems().addAll(addShifts, viewShifts);
		foodMenu.getItems().addAll(addFood, deleteFood);
		fileMenu.getItems().add(saveFile);
		pane.setTop(menuBar);
		pane.setCenter(new Label("Manager View"));
		addEmployeePane = new AddEmployeePane();
		deleteEmployeePane = new DeleteEmployeePane();
		viewGuestPane = new ViewGuestPane();
		addEventPane = new AddEventPane();
		deleteEventPane = new ManagerDeleteEventPane();
		shiftPane = new ShiftPane();
		viewShiftPane = new ViewShiftPane();
		addFoodPane = new AddFoodPane();
		deleteFoodPane = new DeleteFoodPane();
		
		Scene scene = new Scene(pane, 600, 400);
		stage.setScene(scene);
		stage.setTitle("Manager Window");
		
		// guest menu item button handler
		viewGuests.setOnAction(e -> { 
			pane.setCenter(viewGuestPane.getPane());
			MyEventObject ev = new MyEventObject(this);
			if(viewGuestListener != null){
				viewGuestListener.okBtnClicked(ev);
			}
		});
		
		// employee menu item handler
		addEmployee.setOnAction(e -> pane.setCenter(addEmployeePane.getPane()));
		removeEmployee.setOnAction(e -> {
			pane.setCenter(deleteEmployeePane.getPane());
			MyEventObject ev = new MyEventObject(this);
			if(removeListener != null){
				removeListener.okBtnClicked(ev);
			}
		});
		
		// event menu item handler
		addEvent.setOnAction(e -> pane.setCenter(addEventPane.getPane()));
		removeEvent.setOnAction(e -> { 
			pane.setCenter(deleteEventPane.getPane());
			MyEventObject ev = new MyEventObject(this);
			if(removeEventListener != null){
				removeEventListener.okBtnClicked(ev);
			}
		});
		
		// shift menu item handler
		addShifts.setOnAction(e -> pane.setCenter(shiftPane.getPane()));
		viewShifts.setOnAction(e -> pane.setCenter(viewShiftPane.getPane()));
		
		// food item menu item handler
		addFood.setOnAction(e -> pane.setCenter(addFoodPane.getPane()));
		deleteFood.setOnAction(e ->  { 
			pane.setCenter(deleteFoodPane.getPane());
			MyEventObject ev = new MyEventObject(this);
			if(deleteFoodListener != null){
				deleteFoodListener.okBtnClicked(ev);
			}
		});
		
		// save menu item handler
		saveFile.setOnAction(e -> {
			MyEventObject ev = new MyEventObject(this);
			if(fileListener != null){
				fileListener.okBtnClicked(ev);
			}
		});

		
	}
	
	// getters and setters
	public AddEmployeePane getAddEmployeePane(){
		return addEmployeePane;
	}
	
	public DeleteEmployeePane getDeleteEmployeePane(){
		return deleteEmployeePane;
	}
	
	public ViewGuestPane getViewGuestPane(){
		return viewGuestPane;
	}
	
	public AddEventPane getAddEventPane(){
		return addEventPane;
	}
	
	public ManagerDeleteEventPane getDeleteEventPane(){
		return deleteEventPane;
	}
	
	public ShiftPane getShiftPane(){
		return shiftPane;
	}
	
	public ViewShiftPane getViewShiftPane(){
		return viewShiftPane;
	}
	
	public AddFoodPane getAddFoodPane(){
		return addFoodPane;
	}
	
	public DeleteFoodPane getDeleteFoodPane(){
		return deleteFoodPane;
	}
	
	public void setRemoveListener(MyManagerEventListener removeListener){
		this.removeListener = removeListener;
	}
	
	public void setViewGuestListener(MyManagerEventListener viewGuestListener){
		this.viewGuestListener = viewGuestListener;
	}
	
	public void setRemoveEventListener(MyManagerEventListener removeEventListener){
		this.removeEventListener = removeEventListener;
	}
	
	public void setViewShiftListener(MyManagerEventListener viewShiftListener){
		this.viewShiftListener = viewShiftListener;
	}
	
	public void setDeleteFoodListener(MyManagerEventListener deleteFoodListener){
		this.deleteFoodListener = deleteFoodListener;
	}
	
	public void setFileListener(MyManagerEventListener fileListener){
		this.fileListener = fileListener;
	}
}
