package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import model.Address;
import model.Event;
import model.EventBag;
import model.Guest;
import model.MyEventListener;
import model.MyEventPersonObject;
import model.Person;
import model.PersonBag;


public class SignInWindow {
	private BorderPane pane;
	private ComboBox<String> userType;
	private Label comboLbl;
	private Button okBtn;
	private Button cancelBtn;
	private Label userLbl;
	private Label passwordLbl;
	private TextField userTf;
	private TextField passwordTf;
	private Label newUserLbl;
	private CheckBox checkBox = new CheckBox();
	private CheckBox existingCheckBox = new CheckBox();
	private HBox hbox;
	private HBox credHbox;
	private Stage stage;
	private Stage second = new Stage();
	private Stage third = new Stage();
	private Stage fourth = new Stage();
	private HBox buttonPane;
	private GridPane gridPane;
	private PersonBag master = new PersonBag();
	private EventBag masterEventBag = new EventBag();
	private MyEventListener okBtnListener;
	
	public SignInWindow(Stage stage, Stage secondary, Stage third){
		this.stage = stage;
		pane = new BorderPane();
	    //pane.setPadding(new Insets(10, 10, 10, 10));
		comboLbl = new Label("Manager or Guest?");
		userType = new ComboBox<String>();
		userType.getItems().add("Manager");
		userType.getItems().add("Guest");
		hbox = new HBox(30);
		hbox.getChildren().addAll(comboLbl, userType);
		hbox.setAlignment(Pos.CENTER);
		pane.setTop(hbox);
		userLbl = new Label("Username: ");
		passwordLbl = new Label("Password: ");
		userTf = new TextField();
		passwordTf = new TextField();
		credHbox = new HBox(30);
		credHbox.getChildren().addAll(userLbl, userTf, passwordLbl, passwordTf);
		credHbox.setAlignment(Pos.CENTER);
		okBtn = new Button("OK");
		cancelBtn = new Button("Cancel");
		buttonPane = new HBox(30);
		buttonPane.getChildren().addAll(okBtn, cancelBtn);
		buttonPane.setAlignment(Pos.CENTER);
		newUserLbl = new Label("New User?");
		
		gridPane = new GridPane();
		gridPane.add(userLbl, 0, 0);
		gridPane.add(userTf, 1, 0);
		gridPane.add(passwordLbl, 0, 1);
		gridPane.add(passwordTf, 1, 1);
		gridPane.add(newUserLbl, 0, 2);
		gridPane.add(checkBox, 1, 2);
		gridPane.setAlignment(Pos.CENTER);
		gridPane.setVgap(10.0);
		
		
		// add people to master bag, remove this in final
		Guest per1 = new Guest("Justin", "Acosta", "acosj47", "password1", new Address());
		Person per2 = new Person("Bob", "Jones", "jones50", "12345", new Address());
		master.add(per1);
		master.add(per2);
		masterEventBag.add(new Event("New Years Ball", "0", "0", "0", "0", "0", "0"));

		
		userType.setOnAction(e -> {
			if(userType.getValue().equals("Guest")){
				//pane.setCenter(credHbox);
				pane.setCenter(gridPane);
				pane.setBottom(buttonPane);
				pane.setPadding(new Insets(10, 10, 10, 10));
			}else{
				//ManagerView mv = new ManagerView(second);
				third.show();
				// stage.close();  // consider re-adding this line in final build
				//pane.setCenter(null);
			}
		});
		
		cancelBtn.setOnAction(e -> stage.close());
		okBtn.setOnAction(e -> {
			//System.out.println("Username: " + getUsername() + "\nPassword: " + getPassword());
			//GuestView gv = new GuestView(third, master.findPersonByUser(getUsername(), getPassword()));
			//GuestView gv = new GuestView(third, per1, masterEventBag);
			String username = getUsername();
			String password = getPassword();
			MyEventPersonObject ev = new MyEventPersonObject(this, username, password);
			if(okBtnListener != null) {
				okBtnListener.okBtnClicked(ev);
			}
		});
		
		
		checkBox.setOnAction(e -> {
			if(checkBox.isSelected()){
			//NewGuestSignUp ng = new NewGuestSignUp(fourth);
				secondary.show();
				checkBox.setSelected(false);
			}else{
				secondary.close();
			}
		});
		

		Scene scene = new Scene(pane, 600, 200);
		stage.setScene(scene);
		stage.setTitle("Welcome, Please Sign In");
		stage.show();
		
	}
	
	public String getUsername(){
		return userTf.getText();
	}
	
	
	public String getPassword(){
		return passwordTf.getText();
	}
	
	public void setOkBtnListener(MyEventListener okBtnListener){
		this.okBtnListener = okBtnListener;
	}
	
	public Stage getStage(){
		return stage;
	}
	
	
	
}
