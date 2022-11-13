// TO DO: add your implementation and JavaDocs.

/**
 * @author thomas koerner
 */
public class Event implements Comparable<Event> {

	//starting and ending time of the event
	/**
	 * starttime and endtime for events initialized
	 */
	private MyTime startTime;
	private MyTime endTime;
	private int duration;// = startTime.getDuration(endTime);
		
	//description of the event
	/**
	 * description of events
	 */
	private String description;

	/**
	 * constructor for event class
	 * @param startTime time for the event to start
	 * @param endTime time for event to end
	 * @throws IllegalArgumentException if start time or end time are null, or if the event ends before it starts
	 */
	public Event(MyTime startTime, MyTime endTime) throws IllegalArgumentException
	{
		// constructor with start and end times
		// set description to be empty string ""
		this.description="";

		// Throw IllegalArgumentException if either time is null.
		// - Use this _exact_ error message for the exception
		//  (quotes are not part of the message):
		//    "Null Time object!"
		if((startTime==null)||(endTime==null))
		{
			throw new IllegalArgumentException( "Null Time object!");
		}
		// Throw IllegalArgumentException if endTime comes before startTime
		if(endTime.compareTo(startTime)==-1)
		{
			throw new IllegalArgumentException("End time cannot come before Start Time!");
		}
		// - Use this _exact_ error message for the exception
		//  (quotes are not part of the message):
		//        "End Time cannot come before Start Time!"
		// - Assume that the start time can be the same as the end time
		//   (0-duration event allowed)

		this.endTime=endTime;
		this.startTime=startTime;
				this.duration= startTime.getDuration(endTime);
	}

	/**
	 * constructor for event object with description parameter added in as well
	 * @param startTime time for event to start
	 * @param endTime time for event ot end
	 * @param description description of the event
	 */
	public Event(MyTime startTime, MyTime endTime, String description){
		// constructor with start time, end time, and description
		
		// perform the same checking of start/end times and 
		// throw the same exception as the constructor above
		if(endTime.compareTo(startTime)==-1)
		{
			throw new IllegalArgumentException("End time cannot come before Start Time!");
		}
		// - Use this _exact_ error message for the exception
		//  (quotes are not part of the message):
		//        "End Time cannot come before Start Time!"
		// - Assume that the start time can be the same as the end time
		//   (0-duration event allowed)
		if((startTime==null)||(endTime==null))
		{
			throw new IllegalArgumentException( "Null Time object!");
		}
		// if description argument is null, 
		// set description of the event to be empty string ""
		if(description==null)
		{
			description="";
		}


			this.description=description;

		this.startTime=startTime;
		this.endTime=endTime;
		this.duration=startTime.getDuration(endTime);

	}

	/**
	 * getter for starting time
	 * @return starting time of selected event
	 */
	public MyTime getStart(){
		// report starting time

		return this.startTime; //default return, remove/change as needed
	}

	/**
	 * getter method for end time of event
	 * @return the time the event will be ending
	 */
	public MyTime getEnd(){
		// report starting time

		return this.endTime; //default return, remove/change as needed
	}

	/**
	 * getter method for description of event
	 * @return the description of selected event
	 */
	public String getDescription(){
		// report description
		
		return this.description; //default return, remove/change as needed
	}

	/**
	 * compares two events together based on their start times
	 * @param otherEvent the event to be compared against
	 * @return -1 if this event is earlier than the other, 1 if this event is later than the other, 0 if they start at the same time
	 * @throws IllegalArgumentException if the other event is null
	 */
	@Override 
	public int compareTo(Event otherEvent) throws IllegalArgumentException
	{
		// compare two times for ordering
		if(otherEvent==null)
		{
			throw new IllegalArgumentException("Null Event object!");
		}
		// Throw IllegalArgumentException if otherEvent is null.
		// - Use this _exact_ error message for the exception
		//  (quotes are not part of the message):
		//    "Null Event object!"
		if(this.startTime.compareTo(otherEvent.startTime)==-1)// if the starting time of this event is earlier than the start time of the other event
		{
			return -1;
		}
		if(this.startTime.compareTo(otherEvent.startTime)==1)// if the starting time of this event is later than the start time of the other event
		{
			return 1;
		}
		if(this.startTime.compareTo(otherEvent.startTime)==0)// if the starting time of this event is same as the start time of the other event
		{
			return 0;
		}
		// The ordering of two events is the same as the ordering of their start times
	



return 0;
	}

	/**
	 * updates the end and start times by chaning the start time and according moving the end time
	 * @param newStart the new time that the event will be starting
	 * @return if the changing of this events start time was succesfull
	 */
	public boolean moveStart(MyTime newStart)
	{

		//int difference_start_mins = Math.abs(this.startTime.getMin()- newStart.getMin());

		int duration = this.duration;//current duration between start and end
		//time of new start in mins from start of day
		int new_time_mins=newStart.getMin()+ (60*newStart.getHour());
		// adds duration of event in mins to new start time in mins
		int new_end_time_mins=duration + new_time_mins;
		// find the mod of 60 of mins in day to find minutes of start time
		int mins_2=new_end_time_mins%60;
		// subtracts spare mins from day and then divides by 60 to find new end time in hours
		int hours_2=(new_end_time_mins-mins_2)/60;
		MyTime new_end = new MyTime(hours_2,mins_2);// end time



		// The start time can be moved forward or backward but the end time cannot
		// go beyond 23:59 of the same day.  Do not update the event if this condition
		// cannot be satisfied and return false.  Return false if newStart is null.
		if(hours_2>23)
		{// if the end time would go into the enxt day, end time and start time are not updated
			// and method returns false
			return false;
		}
		this.startTime=newStart;//pointers updated

		this.endTime=new_end;
		return true;

		// Move the start time of this Event to be newStart but keep the same duration. 
		// - Remember to update the end time to ensure duration unchanged.
		

		
		// Return true if the start time can be moved to newStart successfully.
		
		// Note: a false return value means the specified newStart can not be used 
		//       for the current event.  Hence if newSart is the same as the current 
		//       start, we will still return true.


	}

	/**
	 * changes the duration of the event, and keeps the start date but updates the end time
	 * @param minute the new duration for this event to be
	 * @return if the new duration can sucessfully be applied to the event or not, true if sucessfull,false if unscuessfull
	 */
	public boolean changeDuration(int minute){
		if(minute<0)
		{
			return false;
		}
		int old_duration=this.duration;//stores old duration in case new end time is invalid
		this.duration=minute;//duration pointer updated
		// the start time stays the same but the end time changes
		int start_time_mins=startTime.getMin()+ (60*startTime.getHour());
		// the start time but in minutes
		int end_time_mins=start_time_mins+duration;
		//the end time in minutes with new duration
		int end_mins=end_time_mins%60;// the spare mins of new end time
		int end_hours=(end_time_mins-end_mins)/60;
		if(end_hours>23)
		{
			this.duration=old_duration;
			return false;
		}
		this.endTime= new MyTime(end_hours,end_mins);
		return true;

		// Change the duration of event to be the given number of minutes.
		// Update the end time of event based on the updated duration.	
			
		// The given minute cannot be negative; and the updated end time cannot go 
		// beyond 23:59 of the same day.  Do not update the event if these conditions
		// cannot be satisfied and return false.  
		// Return true if the duration can be changed.
		
		// Note: a false return value means the specified duration is invalid for some 
		// 		 reason.  Hence if minute argument is the same as the current duration, 
		//       we will still return true.

		//return false; //default return, remove/change as needed
	
	}

	/**
	 * setter method for description, if null arg given desc set to empty string
	 * @param newDescription the new description for the event object
	 */
	public void setDescription(String newDescription){
		// set the description of this event
		if(description==null)
		{
			this.description="";
		}
		this.description=newDescription;

		// if newDescription argument is null, 
		// set description of the event to be empty string ""
	
	}

	/**
	 * returns a string representation of the event object
	 * @return a string representation of the event obejct with start- end times, and then a description of the event
	 */
	public String toString(){
		return ""+this.startTime.toString()+"-"+this.endTime.toString()+"/"+this.description+"";
		// return a string representation of the event in the form of
		// startTime-endTime/description
		// example: "06:30-07:00/breakfast"

		// Hint: String.format() can be helpful here...
		
		// The format of start/end times is the same as .toString() of MyTime


		//return ""; //default return, remove/change as needed
	
	}
	
	public static void main(String[] args){
		// creating an event
		Event breakfast = new Event(new MyTime(7), new MyTime(7,30), "breakfast");
		
		// checking start/end times
		if (breakfast.getStart()!=null && breakfast.getEnd()!=null &&
			breakfast.getStart().getHour() == 7 && breakfast.getEnd().getHour() == 7 && 
			breakfast.getStart().getMin() == 0 && breakfast.getEnd().getMin() == 30){
			System.out.println("Yay 1");			
		}		
		//System.out.println(breakfast);
		//expected output (excluding quote):
		//"07:00-07:30/breakfast"

		// moveStart
		if (breakfast.moveStart(new MyTime(6,30)) && breakfast.getStart().getHour() == 6
			&& breakfast.getStart().getMin() == 30 && breakfast.getEnd().getMin() == 0){
			System.out.println("Yay 2");					
		}
		//System.out.println(breakfast);
		
		//longer duration
		if (breakfast.changeDuration(45) && breakfast.getStart().getHour() == 6
			&& breakfast.getStart().getMin() == 30 && breakfast.getEnd().getMin() == 15
			&& breakfast.getEnd().getHour() == 7){

			System.out.println("Yay 3");					
		}
		//System.out.println(breakfast);
		
		//shorter duration
		if (!breakfast.changeDuration(-10) && breakfast.changeDuration(15) 
			&& breakfast.getStart().getHour() == 6 && breakfast.getStart().getMin() == 30 
			&& breakfast.getEnd().getMin() == 45 && breakfast.getEnd().getHour() == 6){
			System.out.println("Yay 4");					
		}
		//System.out.println(breakfast);
		
		// compareTo
		Event jogging = new Event(new MyTime(5), new MyTime(6), "jogging");
		Event morningNews = new Event(new MyTime(6, 30), new MyTime(7), "morning news");
		if (breakfast.compareTo(jogging)>0 && jogging.compareTo(breakfast)<0
			&& breakfast.compareTo(morningNews) == 0){
			System.out.println("Yay 5");								
		}
	}

}