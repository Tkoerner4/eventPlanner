// TO DO: add your implementation and JavaDocs.

/**
 * @author thomas
 * class for mytime--- FINISHED
 */
public class MyTime implements Comparable<MyTime> {

	/**
	 * hour and minute or time vars initilazlied
	 */
	private int hour;
	private int min;

	/**
	 * zero arg default constructor for mytime
	 */
	public MyTime(){
		// Constructor
		// initialize time to be 00:00
		this.hour=0;
		this.min=0;
	}

	/**
	 * constructor for mytime with hour parameter
	 * @param hour the desired hour for the time to be set at
	 * @throws IllegalArgumentException if an invalid hour is given
	 */
	public MyTime(int hour) throws IllegalArgumentException
	{
		// A valid hour can only be within [0, 23].
		// For an invalid hour, throw IllegalArgumentException.
		// Use this _exact_ error message for the exception
		//  (quotes are not part of the message):
		//
		if((hour<0)||(hour>23)) // if the hour is negative or over
		{
			throw new IllegalArgumentException("Hour must be within [0, 23]!");
		}
		// Constructor with hour specified
		// initialize time to be hour:00
		this.hour=hour;
		this.min=0;



	}

	/**
	 * constructor for mytime with hour and minute parameters
	 * @param hour the desired hour for mytime to be set at
	 * @param min the desired minute for mytime to be set at
	 * @throws IllegalArgumentException if the hour or minute given is less than 0 or too high, 23 for hour, 60 for min
	 */
	public MyTime(int hour, int min) throws IllegalArgumentException
	{
		// Constructor with hour and minutes specified
		// initialize time to be hour:minute
		if(((hour<0)||(hour>23)) || ((min<0)||(min>59)))// if the hour is negative or over, or if the min is negative or over
		{
			throw new IllegalArgumentException("Hour must be within [0, 23]; Minute must be within [0, 59]!");
		}

		this.hour=hour;
		this.min=min;
		// A valid hour can only be within [0, 23].
		// A valid minute can only be within [0, 59].

		// For an invalid hour / minute, throw IllegalArgumentException.
		// Use this _exact_ error message for the exception 
		//  (quotes are not part of the message):
		// "Hour must be within [0, 23]; Minute must be within [0, 59]!");


	}

	/**
	 * getter method for hour
	 * @return hour var for mytime obj
	 */
	public int getHour(){
		// report hour

		return this.hour; //default return, remove/change as needed
	}

	/**
	 * getter var for min
	 * @return the minute var for this obj
	 */
	public int getMin(){
		// report minute
		
		return this.min; //default return, remove/change as needed
	}

	/**
	 * compares two time objects together based on their hour and minute ints
	 * @param otherTime antoher time object with its own hour and min
	 * @return 1 if this one is later than the other, -1 if this one is earlier than the other, and 0 if theyre the saem time
	 * @throws IllegalArgumentException if the other mytime object is null
	 */
	@Override 
	public int compareTo(MyTime otherTime) throws IllegalArgumentException
	{
		// Throw IllegalArgumentException if otherTime is null.
		// - Use this _exact_ error message for the exception
		//  (quotes are not part of the message):
		//    "Null Time object!"
		if(otherTime==null)
		{
			throw new IllegalArgumentException( "Null Time object!");
		}


		// compare two times for ordering
		// return the value 0 if the argument Time has the same hour and minute of this Time;
		if(getHour()== otherTime.getHour())// if the hour is the same
		{
			if(getMin()== otherTime.getMin())
			{// if the two mytime objects have the same hour and min
				return 0;
			}
			if(getMin()< otherTime.getMin())// if this min is less than other min
			{
				return -1;
			}
			if(getMin()> otherTime.getMin())// if this min is greater than the other min
			{
				return 1;
			}
		}

		// return a value less than 0 if this Time is before the otherTime argument;
		if(getHour()< otherTime.getHour()) // if this mytime hour is less than the other mytime hour
		{
			return -1;
		}

		if(getHour()> otherTime.getHour()) //if this hour is greater than the other hour
		{
			return 1;
		}
		// return a value greater than 0 if this Time is after the otherTime argument.



		
			
		return 0; //default return, remove/change as needed
	}

	/**
	 *
	 * finds difference in mins between this time and the endtime
	 * 	 @param endTime the time that the event will end
	 *@return the difference between endtime and this time
	 * @throws IllegalArgumentException if the endtime object given is null
	 */
	public int getDuration(MyTime endTime) throws IllegalArgumentException
	{

		// Throw IllegalArgumentException if endTime is null.
		// - Use this _exact_ error message for the exception
		//  (quotes are not part of the message):
		//    "Null Time object!"
		if(endTime==null)
		{
			throw new IllegalArgumentException( "Null Time object!");
		}

		// return -1 if endTime is before this Time
		if(endTime.compareTo(this)==-1)
		{
			return -1;
		}


		// return the number of minutes starting from this Time and ending at endTime

		int this_total_min=getMin()+(getHour()*60); // get total mins of this
		int endTime_total_min = endTime.getMin()+(endTime.getHour()*60); // get total mins of endtime
		int duration = endTime_total_min-this_total_min; // subtract this endtime mins from this mins to see how much mins have passed
		return duration;




		//return -1; //default return, remove/change as needed
	}

	/**
	 * finds the new end time if a duration had been added, and crates a new object with an aaccording time
	 * @param duration the duration to be added for the ceration of the new mytime object
	 * @return a new object with an updated time of the duration added to this time
	 * @throws IllegalArgumentException if the duration of an event given is less than 0
	 */
	public MyTime getEndTime(int duration) throws IllegalArgumentException
	{
		// Throw IllegalArgumentException if duration is negative.
		// Use this _exact_ error message for the exception
		//  (quotes are not part of the message):
		// "Duration must be non-negative!"
		if(duration<0)
		{
			throw new IllegalArgumentException("Duration must be non-negative!"	);
		}
		// return a Time object that is duration minute from this Time
		int this_total_min=getMin()+(getHour()*60); // get total mins of this
		int new_time_mins =this_total_min+duration; // new total time in mins
		int new_mins = new_time_mins%60;
		int new_hours =(new_time_mins-new_mins)/60;
		// return null if endTime passes 23:59 given this Time and duration argument
		if(new_hours>23)
		{
			return null;
		}
		MyTime new_time = new MyTime(new_hours,new_mins);// new time object with duration added


		

		
		return new_time; //default return, remove/change as needed
	}

	/**
	 * returns a string representiaion of the time
	 * @return returns a string with hour and min, if hour or min is single digit then they will be padded to the right hand side with a zero
	 */
	public String toString() {
		// return a String representation of this object in the form of hh:mm
		if((getHour()<10) && (getMin()<10))
		{
			return "0"+getHour()+":"+"0"+getMin()+"";// if hour and min are single digit
		}
		if(!(getHour()<10) && (getMin()<10))
		{
			return ""+getHour()+":"+"0"+getMin()+""; // if only min is single digit
		}
		if((getHour()<10) && !(getMin()<10))
		{
			return "0"+getHour()+":"+""+getMin()+"";// if only hour is single dgiti
		}
		return ""+getHour()+":"+getMin()+""; // if hour and min are double digit
		// hh is the hour of the time (00 through 23), as two decimal digits
		// mm is the minute of the time (00 through 59), as two decimal digits
		
		// Hint: String.format() can be helpful here...
		

	}
	
	public static void main(String[] args){
		//This method is provided for testing 
		//(use/modify as much as you'd like)

		//time objects
		MyTime time1 = new MyTime(7);
		MyTime time2 = new MyTime(9,30);
		
		//checking hour/minute
		if (time1.getHour() == 7 && time1.getMin() == 0 && time2.getHour() == 9
			&& time2.getMin() == 30){
			System.out.println("Yay 1");			
		}		
	
		//compareTo, duration
		if (time1.compareTo(time2) < 0 && time1.compareTo(new MyTime(7,0)) == 0
			&& time2.compareTo(time1) > 0 && time1.getDuration(time2) == 150){
			System.out.println("Yay 2");						
		}
		
		//getEndTime
		MyTime time3 = time1.getEndTime(500);
		if (time3!=null && time3.getHour() == 15 && time3.getMin() == 20 
			&& time2.getEndTime(870) == null){
			System.out.println("Yay 3");								
		}
		
	}
}