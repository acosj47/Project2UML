package model;

import java.util.ArrayList;

public class MasterEventBag {
	private ArrayList<Event> arr;
	
	public MasterEventBag(){
		arr = new ArrayList<>();
	}
	
	public void add(Event event){
		arr.add(event);
	}
	
	public void delete(Event event){
		arr.remove(event);
	}
	
	public void findEvent(String title ){
		for(Event e : arr){
			if(title.equals(e.getTitle())){
				// add to this
				// need to figure out calendar class
				System.out.println(e.getTitle() + " " + e.getDate().MONTH + "/ " + e.getDate().DAY_OF_MONTH + "/ " + e.getDate().YEAR );
				break;
			}else{
				System.out.println("cant find event " + title);

			}
			
			//System.out.println(e);
			//return e;
		}
		
			
	}
}
