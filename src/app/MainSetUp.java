package app;

import controllers.EmployeeController;
import controllers.GuestController;
import controllers.SignUpController;
import javafx.application.Application;
import javafx.stage.Stage;
import model.Address;
import model.EventBag;
import model.FoodItemBag;
import model.Guest;
import model.Person;
import model.PersonBag;
import model.TableBag;
import view.ManagerView;
import view.NewGuestSignUp;
import view.SignInWindow;

public class MainSetUp extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		Stage second = new Stage();
		Stage third = new Stage();
		SignInWindow view = new SignInWindow(primaryStage, second, third);
		NewGuestSignUp signUpView = new NewGuestSignUp(second);
		ManagerView mv = new ManagerView(third);
		PersonBag bag = new PersonBag();
		Person demoPerson = new Guest("John", "Smith", "admin", "admin", new Address());
		EventBag eventBag = new EventBag();
		TableBag tableBag = new TableBag();
		FoodItemBag foodBag = new FoodItemBag();
		PersonBag employeeBag = new PersonBag();

		bag.add(demoPerson);
		bag.save();
		eventBag.load();
		employeeBag.load();
		foodBag.load();
		
		GuestController gc = new GuestController(bag, view, eventBag, foodBag, tableBag);
		SignUpController sup = new SignUpController(bag, signUpView);
		EmployeeController ec = new EmployeeController(employeeBag, bag, eventBag, foodBag ,mv );
		
	}

}
