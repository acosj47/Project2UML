What works:
Can create/view/delete Guest, Employee, FoodItem, Events objects
Choosing Manager from the sign-in combo box will take you to the ManagerView
Choosing Guest will ask you to sign in.

You can sign in with the default account with username "admin" and password "admin".

You can also create your own Guest account by selecting new user CheckBox from Guest sign-in.  You can then sign in with the account you created. 

You can save the bag files

What does not work:
Shift management does not work as intended, you can only set a shift for a single day.
Person id variable resets when you close the app, this create conflicting id numbers for employees and guests if you use the save feature.
Missing exception handling for NumberFormatExceptions
Oversight: The guestBag and EmployeeBag both load from the same save file, causing Guest to show as employees, if the save feature is used.