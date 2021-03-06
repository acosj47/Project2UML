package view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import model.MyEventListener;
import model.MyEventPersonObject;

public class NewGuestSignUp {
	private Stage stage = new Stage();
	private Label lblFirst;
	private Label lblLast;
	private Label lblUsername;
	private Label lblPassword;
	private Label lblStreetNumber;
	private Label lblStreetName;
	private Label lblCity;
	private Label lblState;
	private Label lblZip;
	// textfields
	private TextField tfFirst;
	private TextField tfLast;
	private TextField tfUsername;
	private TextField tfPassword;
	private TextField tfStreetNumber;
	private TextField tfStreetName;
	private TextField tfCity;
	private TextField tfState;
	private TextField tfZip;
	// buttons
	private Button okBtn;
	private Button cancelBtn;
	// combobox
	private ComboBox<String> states;
	private static String[] usa = {"Alabama", "Alaska", "Arizona", "Arkansas" , "California", "Colorado", "Connecticut", "Delaware", "Florida", "Georgia",
            "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts", "Michigan",
            "Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire", "New Jersey", "New Mexico", "New York",
            "North Carolina", "North Dakota", "Ohio", "Oklahoma", "Oregon", "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota",
            "Tennessee", "Texas", "Utah", "Vermont", "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming" };
	
	private MyEventListener okBtnListener;
	
	public NewGuestSignUp(Stage stage){
		this.stage = stage;
		BorderPane pane = new BorderPane();
		GridPane grid = new GridPane();
		HBox hbox4Buttons = new HBox(20);
		
		//buttons
		okBtn = new Button("OK");
		cancelBtn = new Button("Cancel");
		
		// place buttons in hbox
		hbox4Buttons.getChildren().addAll(okBtn, cancelBtn);
		hbox4Buttons.setAlignment(Pos.CENTER);
		
		// create labels
		lblFirst = new Label("First Name: ");
		lblLast = new Label("Last Name: ");
		lblUsername = new Label("Enter Username: ");
		lblPassword = new Label("Enter Password: ");
		lblStreetNumber = new Label("Enter Street Number: ");
		lblStreetName = new Label("Enter Street Name: ");
		lblCity = new Label("City: ");
		lblState = new Label("State: ");
		lblZip = new Label("Enter Zip: ");
		
		//create textfields
		tfFirst = new TextField();
		tfLast = new TextField();
		tfUsername = new TextField();
		tfPassword = new TextField();
		tfStreetNumber = new TextField();
		tfStreetName = new TextField();
		tfCity = new TextField();
		tfZip = new TextField();
		
		// create combo box
		states = new ComboBox<>();
		states.getItems().addAll(usa);
		
		// fill gridpane
		grid.add(lblFirst, 0, 0);
		grid.add(tfFirst, 1, 0);
		grid.add(lblLast, 0, 1);
		grid.add(tfLast, 1, 1);
		grid.add(lblUsername, 0, 2);
		grid.add(tfUsername, 1, 2);
		grid.add(lblPassword, 0, 3);
		grid.add(tfPassword, 1, 3);
		grid.add(lblStreetNumber, 2, 0);
		grid.add(tfStreetNumber, 3, 0);
		grid.add(lblStreetName, 2, 1);
		grid.add(tfStreetName, 3, 1);
		grid.add(lblCity, 2, 2);
		grid.add(tfCity, 3, 2);
		grid.add(lblState, 2, 3);
		grid.add(states, 3, 3);
		grid.add(lblZip, 2, 4);
		grid.add(tfZip, 3, 4);
		grid.setAlignment(Pos.CENTER);
		grid.setVgap(5);
		grid.setHgap(10);
		
		
		// place grid, hbox4buttons inside border pane
		pane.setCenter(grid);
		pane.setBottom(hbox4Buttons);
		
		// button handlers
		cancelBtn.setOnAction(e -> stage.close());
		okBtn.setOnAction(e -> {
			String first = tfFirst.getText();
			String last = tfLast.getText();
			String username = tfUsername.getText();
			String password = tfPassword.getText();
			String streetNumber = tfStreetNumber.getText();
			String streetName = tfStreetName.getText();
			String city = tfCity.getText();
			String state = states.getValue();
			String zip = tfZip.getText();
			MyEventPersonObject ev = new MyEventPersonObject(this, first, last, username, password, streetNumber, streetName, city, state, zip);
			if(okBtnListener != null){
				okBtnListener.okBtnClicked(ev);
			}
			stage.close();
		});

		// set scene
		Scene scene = new Scene(pane, 600, 400);
		stage.setScene(scene);
		stage.setTitle("New Guest Sign Up");
		//stage.show();
		
	}
	
	public void setOkBtnListener(MyEventListener okBtnListerner){
		this.okBtnListener = okBtnListerner;
	}
}
