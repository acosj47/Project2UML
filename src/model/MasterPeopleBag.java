package model;

public class MasterPeopleBag {
	private PersonBag bag;
	private Person p1;
	private Person p2;
	private Address address = new Address();
	
	public MasterPeopleBag(){
		// change this in final
		p1 = new Person("Justin", "Acosta", "acosj47", "password1", address);
		p2 = new Person("Mike", "Smith", "smith50", "hello2", address);
		
		bag.add(p1);
		bag.add(p2);

	}
	
	
	
	
}
