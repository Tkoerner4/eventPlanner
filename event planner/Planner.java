// TO DO: add your implementation and JavaDocs.

/**
 * @author thomas
 */
public class Planner{

	// DO NOT MODIFY INSTANCE VARIABLES PROVIDED BELOW
	
	//underlying array of events  -- you MUST use this for credit!
	//Do NOT change the name or type

	private MySortedArray<Event> events;
	
	// ADD MORE PRIVATE MEMBERS HERE IF NEEDED!

	/**
	 * zero arg constructor for planner object, since no args for size given creates a generic sorted array
	 * holding events with the default size, which is 2
	 */
	public Planner(){
		// Constructor with no arguments.
		this.events = new MySortedArray<>(2);// i couldnt do MySortedArray.DEFAULT_CAPACITY so i just did 2(which is what default capacity is anyway lol)
		// A list of events should be created.  The initial capacity should be 
		// DEFAULT_CAPACITY defined in our MySortedArray class. 
		// The list should be empty (with no events).
		
	}

	/**
	 * returns the amount of events in the array, calling mysortedarrays size method
	 * @return the amount of non null objects in the array
	 */
	public int size(){
		// return the number of events in the list.
		// O(1)

		return events.size(); //default return, remove/change as needed
	}


	/**
	 * returns a string representation of the planner object
	 * @return an ascending list, starting at the beginning of the day, where each event has an end and start time and description
	 * and each event is on its own line
	 */
	public String toString(){
		if(this.events.size()==0)
		{
			return "";
		}
		String events_str="";
		for(int i = 0; i<this.size();i++)
		{

				events_str = "" + events_str +"["+i+"]"+ events.get(i).toString() + "\n";

		}
		// return the string representation of the planner with this format:
		// - include all events in the list in ascending order of the indexes;
		// - each event goes into a separate line;
		// - each line except for the last uses this format (quotes excluded): "[index]event\n"
		// - the last line does not end with a new line and uses this format: "[index]event"

		// The format of an event is the same as .toString() of Event class

		// Hint: String.format() can be helpful here...
		
		// Note: use StringBuilder instead of String concatenation for a better efficiency 

			
		return events_str.substring(0,events_str.length()-1);
	}

	/**
	 * adds an event to the array, sorts automatically after addition
	 * @param event the event to be added into the array
	 * @throws IllegalArgumentException if the event being attamped to be added is null
	 */
	public void addEvent(Event event) throws IllegalArgumentException
	{
		// Throw IllegalArgumentException if event is null.
		// - Use this _exact_ error message for the exception
		//  (quotes are not part of the message):
		//    "Null Event object!"
		if(event==null)
		{
			throw new IllegalArgumentException("Null Event object!");
		}

		this.events.add(event);
		// adds new event into array, mysortedarray in house method should do sorting itself...
		// but we will see... lol
		// Add a new event into the list
		//	- make sure events are sorted after addition


		
		// O(N) where N is the number of events in the list

	}

	/**
	 * changes the starting time of an event at index, then updates its postion in the array accordingly
	 * @param index the location of the event to be updated within the array
	 * @param newStart the new start time for the event at index to be given
	 * @return if the updating and moving of the event was sucessfull or not
	 */
	public boolean moveEvent(int index, MyTime newStart){//moves the event a index to a newstart
		// - return false if newStart is null
		if(newStart==null)
		{
			return false;
		}
		// Return true if event can be updated; return false otherwise.
		// - return false for an invalid index
		if((index<0)||(index>= events.size()))// if index is negative or longer than array
		{
			return false;
		}
		Event moving_original=this.events.get(index);
		Event moving = this.events.get(index);//event to be moved
		//since a copy of the event is crated and changed,
		this.events.delete(index);// the original one is removed

		// Move the event at index to be start at newStart.
		// Hint: we will keep the same duration but the end time may need to be changed.
		// the duration is automatically updated in event.moveStart
		moving.moveStart(newStart);// start time of event that will be moved is updated
		//attempt to move event with updated starttime
		boolean move_status=this.events.add(index,moving);// status of the sucess of moving the event
		//events location is updated
		// - return false if event cannot be moved to newStart
		if(move_status==false)
		{// if the move cannot be completed
			this.events.add(moving_original);//event at index placed back into array

			return false;
		}







		return true;

		
		// If with the updated starting time, the events are still sorted in ascending 
		// order of their starting times, do not change the index of the event.
		// Otherwise, fix the ordering by first removing the updated event, 
		// then adding it back.


		// O(N) where N is the number of events currently in list
		
		

	}

	/**
	 * changes the duration of an event at a selected index
	 * @param index the index of the event within the array to be changed
	 * @param minute the amount of minutes to augment the duration of the selected event by
	 * @return if the change in duration for the event at index was sucessful
	 */
	public boolean changeDuration (int index, int minute){
		// Change the duration of event at index to be the given number of minutes.

		// Return true if the duration can be changed.
		// Return false if:
		// - index is invalid; or
		if((index<0)||(index>= events.size()))// if index is negative or longer than array
		{
			return false;
		}
		// - minute is negative; or
		if(minute<0)
		{
			return false;
		}
		Event change = this.events.get(index);
		// - the duration of event at index can not be updated with the specified minute
		if(change.changeDuration(minute)==false)
		{
			return false;
		}
		else {
			this.events.get(index).changeDuration(minute);// the operation is able to be done
			return true;
		}
		// so its done in place on the element at index


		// O(1)		
		//return false; //default return, remove/change as needed
	
	}

	/**
	 * changes the description of the event at the index within the array events
	 * @param index the index of the event to be changed
	 * @param description the decription for the event to have its description field updated to
	 * @return if the change was sucessful or not
	 */
	public boolean changeDescription(int index, String description){
		// Change the description of event at index.

		// Return true if the event can be changed.
		// Return false for an invalid index.
		if((index<0)||(index>= events.size()))// if index is negative or longer than array
		{
			return false;
		}
		if(description==null)
		{
			description="";
		}
		this.events.get(index).setDescription(description);
		return true;
		// If description argument is null, 
		// set description of the event to be empty string ""
		
		// O(1)
		//return false; //default return, remove/change as needed
	}

	/**
	 * removes an event at a selected index
	 * @param index the index for the object to be removed from
	 * @return if the removal of the event was sucessful or not
	 */
	public boolean removeEvent(int index){
		// Return false for an invalid index.
		if((index<0)||(index>= events.size()))// if index is negative or longer than array
		{
			return false;
		}

		// Remove the event at index.
			this.events.delete(index);
			return true;
		// Return true if the event can be removed

		// O(N) where N is the number of elements currently in the storage
		

	//	return false; //default return, remove/change as needed
	}

	/**
	 * returns the event at the selected index
	 * @param index the index that the associated element at will be returned
	 * @return the event at the selected index
	 */
	public Event getEvent(int index){
		// Return the event at index
		if((index<0)||(index>= events.size()))// if index is negative or longer than array
		{
			return null;
		}
		return this.events.get(index);
		// Return null for an invalid index.
		
		//O(1)
		//return null; //default return, remove/change as needed
	}

	public static void main(String[] args){
	
		// creating a planner
		Planner day1 = new Planner();

		// adding two events		
		Event breakfast = new Event(new MyTime(7), new MyTime(7,30), "breakfast");
		Event jogging = new Event(new MyTime(5), new MyTime(6), "jogging");
		day1.addEvent(breakfast);
		day1.addEvent(jogging);
		
		if (day1.size()==2 && day1.getEvent(0)==jogging && day1.getEvent(1)==breakfast ){
			System.out.println("Yay 1");					
		}
		
		//toString
		if (day1.toString().equals("[0]05:00-06:00/jogging\n[1]07:00-07:30/breakfast")){
			System.out.println("Yay 2");	              //[1]07:00-07:30/breakfast
		}
		System.out.println(day1);

		// move start of breakfast		
		MyTime newBFTime = new MyTime(6,30);
		
		if (day1.moveEvent(1, newBFTime) && day1.getEvent(1).getStart().getHour() == 6
			&& day1.getEvent(1).getStart().getMin() == 30){
			System.out.println("Yay 3");								
		}
		//System.out.println(day1);
		
		// change duration
		if (day1.changeDuration(0, 45) && day1.getEvent(0).getEnd().getHour() == 5 
			&& day1.getEvent(0).getEnd().getMin() == 45 && day1.changeDuration(1, 60)
			&& day1.getEvent(1).getEnd().getHour() == 7 
			&& day1.getEvent(1).getEnd().getMin() == 30){
			System.out.println("Yay 4");											
		}
		//System.out.println(day1);
		
		// change description, remove
		if (day1.changeDescription(1, "sleeping") && !day1.removeEvent(3) 
			&& !day1.removeEvent(-2) && day1.removeEvent(0)){
			System.out.println("Yay 5");							
		}
		//System.out.println(day1);
		
	}
}