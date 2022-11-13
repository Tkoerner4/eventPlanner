// TO DO: add your implementation and JavaDocs.

/**FINISHED ALL TESTS PAST EXCEPT 8 lol
 * class file for mysorted array
 * @param <T> generic for c;lass
 */
public class MySortedArray<T extends Comparable<T>> {

	//default initial capacity / minimum capacity
	private static final int DEFAULT_CAPACITY = 2;

	// Constructor
	//underlying array for storage -- you MUST use this for credit!
	//Do NOT change the name or type
	private T[] data;

	// ADD MORE PRIVATE MEMBERS HERE IF NEEDED!


	/**
	 * default constructor for class, set initial size of arr to 2
	 */
	@SuppressWarnings("unchecked")
	public MySortedArray() {
	data = (T[]) new Comparable[DEFAULT_CAPACITY];

		// Initial capacity of the storage should be DEFAULT_CAPACITY
		// Hint: Can't remember how to make an array of generic Ts? It's in the textbook...
		
	}


	/**
	 * constructor for class, has parameter for size
	 * @param initialCapacity initial number of elements array is able to hold
	 * @throws IllegalArgumentException if the capacity is less than 2
	 */
	public MySortedArray(int initialCapacity) throws IllegalArgumentException
	{
		// Constructor
	if(initialCapacity<2)
	{
		throw new IllegalArgumentException("Capacity must be at least 2!");
	}
	data = (T[]) new Comparable[initialCapacity];
		// Initial capacity of the storage should be initialCapacity

		// Throw IllegalArgumentException if initialCapacity is smaller than 
		// 2 (which is the DEFAULT_CAPACITY). 
		// Use this _exact_ error message for the exception 
		//  (quotes are not part of the message):
		//    "Capacity must be at least 2!"
		
	}


	/**WORKING
	 * getter for the number of elements in array
	 * @return the number of elements in the array
	 */
	public int size()
	{
		// Report the current number of elements
		// O(1)
		int arr_size=0;
		for(int i = 0 ; i < data.length;i++)
		{//goes thru arr
			if(data[i]!=null)// if location is not null
			{
				arr_size++;// element added to count
			}
		}
		
		return arr_size;

	}

	/**WORKING
	 * the able of elements maxes total that the array can handle before it must be expanded
	 * @return the length of the this array
	 */
	public int capacity() { 
		// Report max number of elements before the next expansion
		// O(1)

		
		return data.length; //default return, remove/change as needed
	}

	/**WORKING
	 *  selection sort method, private in class used for ease in other methods
	 * @param arr THe array given to be sorted
	 * @return a sorted array using selection sort
	 */
	private T[] sort (T[] arr)
	{
		int real_length=0;
		//finding real count of values in arr
		for(int i =0; i < arr.length;i++)
		{

			if(arr[i]==null)
			{
				break;
			}
			else
			{
				real_length++;
			}
		}

	int i;
	int j;
		int smallest_index;//smallest val in unsorted part
	T temp_val; // stores object that will be moved
	for(i=0;i<real_length-1;i++)// goes thru arr
	{
		//System.out.println("i="+i);
		smallest_index=i;// smallest index is default at beginning of unsorted part
		for(j =i+1;j< real_length;j++)// starts after the end of the unsorted, starting on the first unsorted val
		{

			if(arr[j].compareTo(arr[smallest_index])<0)// if the number being examined is less than the current smallest
			{// then theyre swapped
				smallest_index=j;
			}
		}
		//after the unsorted part is completely examined
		temp_val=arr[i]; //temp is set to the first unsorted number
		arr[i] = arr[smallest_index];//the first unsorted number is set to the smallest of the unsorted, making it sorted
		arr[smallest_index] = temp_val;// the spot where the smallest entry was formerly is replaced with the previous first sunroted number
	}
	return arr;
	}


	/** WORKING
	 * private method for checking if an array has a value
	 * @param value value to be searched for in array
	 * @return true if value fiund in array, false if value not found in array
	 */
	private boolean has(T value)
	{

		boolean is_in = false;//default flag for is in set to false
		for(int i = 0; i < data.length;i++)//goes thru arr
		{
			//System.out.println(data[i]);
			if(data[i]==null)// if part of array containing null values has been reached
			{// weve past all of the actual values of the array, so we can break out the for loops iteration because the for loop has searched
				//all non null values
				break;// after breakage continues to code after for loop
			}
			if(data[i].equals(value))// if identical entry detected
			{
				is_in = true;// flag set to true
			}
		}
		return is_in;
	}

	/**
	 * gets a cpunt of all elements in array and the size of the array to see if its at capacity yet- private in class
	 * @return true if array acnnot handle anymore else, false if it can handle more with no size augmentation
	 */
	private boolean is_full()
	{
		int count=0;
		for(int i = 0; i < data.length;i++)
		{
			if(data[i]!=null) {
				count++;
			}
		}
		if(count == data.length)
		{
			return true;
		}
		else
			return false;

	}

	/**
	 * adds a value to the end of the array
	 * @param value value to be added to the end of the array
	 * @throws IllegalStateException if the value given to be added in is null
	 */
	public void add(T value) throws IllegalStateException
	{
		// Insert the given value into the array and keep the array _SORTED_ 
		// in ascending order.

		// Note: The value to be added cannot be null.
		// - Throw IllegalArgumentException if value is null.
		// - Use this _exact_ error message for the exception
		//  (quotes are not part of the message):
		//    "Cannot add: null value!"
		if(value.equals(null))
		{
			throw new IllegalArgumentException("Cannot add: null value!");

		}
		int first_open_spot = size();
		int num_before = data.length;
		int num_after=data.length*2;
		// - For the rare case that doubleCapacity() fails to increase the max
		//   number of items allowed, throw IllegalStateException.
		// - Use this _exact_ error message for the exception
		//  (quotes are not part of the message):
		//    "Cannot add: capacity upper-bound reached!"
		if(num_after>= Integer.MAX_VALUE)
		{
			throw new IllegalStateException("Cannot add: capacity upper-bound reached!");
		}
// - You must call doubleCapacity() if no space is available.
		// - Check below for details of doubleCapacity().
		if(is_full())
		{
			doubleCapacity();
		}

		// If the array already contains value(s) that are equal to the new value,
		// make sure that the new value is added at the end of the group. Check examples
		// in project spec and main() below.
		if(has(value))
		{// if value is already in arr
			this.data[first_open_spot] = value;//added to end


		}
		else
		{// if it does not have the value added into it already
			this.data[first_open_spot] = value;//added to end

		}
		data =sort(data); // then sorted
		
		// Remember to use .compareTo() to perform order/equivalence checking.
				
		// Note: You _can_ append an item (and increase size) with this method.

		//

		


		// O(N) where N is the number of elements in the storage

	}

	/**WORKING
	 * priavte checker for seeing if arr is sorted
	 * @return true if array is sorted, false if not
	 */
	private boolean is_sorted(T[] arr)
	{
		if(size()<=1)
		{
			return true;
		}
		for(int i =0;i< arr.length-1;i++)
		{
			//System.out.println(arr[i]);
			//System.out.println(arr[i+1]);
			if(arr[i+1]==null)// if the null part of the arr has been reached
			{
				break;//for loop breaks, heads to code after for loop
			}
			if(arr[i].compareTo(arr[i+1])==1)
			{
			return false;
			}
		}
		return true;
	}

	/**
	 * returns a value at a given index without removing it
	 * @param index the index for the item to be retrieved from
	 * @return the item at the index
	 * @throws IndexOutOfBoundsException if an invalid index is given as an arg
	 */
	public T get(int index) throws IndexOutOfBoundsException
	{
		// Return the item at the given index
		if((index>= data.length)||(index<0))
		{
			throw new IndexOutOfBoundsException("Index " + index + " out of bounds!");
		}
		// For an invalid index, throw an IndexOutOfBoundsException.
		// Use this code to produce the correct error message for
		// the exception (do not use a different message):
		//	  "Index " + index + " out of bounds!"
		for(int i=0; i< data.length;i++)
		{
			if(i == index)
			{
				return data[index];
			}
		}
		// O(1)
				


		return null; //default return, remove/change as needed

	}

	/**
	 *replaces value at desired index,
	 * @param index index to have value replaced at
	 * @param value the value to go at index
	 * @return true if replacing does not violate order, false and no change to arr if replacement violates array order
	 * @throws IndexOutOfBoundsException if an invalid index is given
	 * @throws IllegalArgumentException if a null value is sent to be added
	 */
	public boolean replace(int index, T value) throws IndexOutOfBoundsException,IllegalArgumentException
	{
		// Change the item at the given index to be the given value.
		if((index>= data.length)||(index<0))
		{
			throw new IndexOutOfBoundsException("Index  "+ index + " out of bounds!");
		}
		// For an invalid index, throw an IndexOutOfBoundsException.
		// Use the same error message as get(index).
		// Note: You _cannot_ add new items with this method.
		// For a valid index, if value is null, throw IllegalArgumentException.
		// Use the exact same error message as add(value).
		if(value==null)
		{
			throw new IllegalArgumentException("Cannot add: null value!");
		}

// The array must keep to be sorted in ascending order after updating.
		// For a valid index, return false if setting the value at index violates
		// the required order hence can not be performed; no change should be made
		// to the array.  Otherwise, change the item and return true.
				T placeholder = data[index];// saves copy of item at index
				data[index]=value; // sets index to new item
		if(is_sorted(this.data)==false)// if new item violates sort
		{
			data[index]= placeholder;// revert back to orignal status
			return false;
		}
		else// if chaing element does not violate sorting
			return true;


		

				

		
		// O(1)
				
		 //default return, remove/change as needed
		
	}

	/**
	 * adds in a number at the desired index, shifting all elements to the right after the index
	 * @param index the position for the value to be inserted at
	 * @param value the new netry at the desired postion
	 * @return if adding the value at index violates sorting, return false and array is not edited, return true if adding value at index does not violate sorting
	 * and the array is updated
	 * @throws IllegalArgumentException if value is null
	 * @throws IndexOutOfBoundsException if invalid index is given
	 * @throws IllegalStateException if the array cannot be doubled to accomodate the new element
	 */
	public boolean add(int index, T value) throws IllegalArgumentException,IndexOutOfBoundsException,IllegalStateException
	{
		// Insert the given value at the given index. Shift elements if needed.


		// For a valid index, if value is null, throw IllegalArgumentException. -- done
		// Use the exact same error message as add(value). See add(value) above.

		if (value.equals(null)) {
			throw new IllegalArgumentException("Cannot add: null value!");

		}

		int num_before = data.length;
		int num_after = data.length * 2;
		// You must call doubleCapacity() if no space is available.
		// Throw IllegalStateException if doubleCapacity() fails.
		// Use the exact same error message as add(value). See add(value) above.
		if (num_after >= Integer.MAX_VALUE) {
			throw new IllegalStateException("Cannot add: capacity upper-bound reached!");
		}
		else
		if (is_full()) { // if the array is full the array is extended
			doubleCapacity();
		}
		// For an invalid index, throw an IndexOutOfBoundsException. --- done
		// Use the same error message as get(index).
		// Note: You _can_ append items with this method, which is different from replace()
		//System.out.println(index);
		//System.out.println(data.length);
		if ((index >= data.length) || (index < 0)) {

			throw new IndexOutOfBoundsException("Index " + index + " out of bounds!");// if index i invalid the method will be exited and an error will be thrown
		}
		/*
		if(has(value))// if value is already in the array
		{
			System.out.println("x");
			data[size()]=value;
			sort(data);
			return true;
		}

		 */
// The array must keep to be sorted in ascending order after updating.
		// For a valid index, return false if inserting the value at index violates -
		// the required order hence can not be performed; no change should be made
		// to the array.  Otherwise, insert the value and return true.

		T[] temp = (T[]) new Comparable[data.length];//makes a new array of same size


		for(int i =0;i<data.length;i++) // goes thru old array start to finsih
		{
			if (i < index) {//if before index
				temp[i] = data[i];//copy over index to index
			}
			if (i == index) {// if desired index, set to value
				temp[i] = value;
			}
			if (i > index) {//if past index, arr set to i-1 of data
				temp[i] = data[i - 1];
			}
		}// new array with addition still is data
		/*
		for(int i = 0;i<temp.length;i++) {

			System.out.println(temp[i]);
		}
		*/
		 //data=temp;
		 //System.out.println(this.toString());
		if(is_sorted(temp)==false)// if adding at index violates order
		{
			return false;
		}
		else
		{// if inserting at index does not violate order
			this.data=temp;//pointer set to updated array
			return true;
		}










			// O(N) where N is the number of elements in the storage


		}


	/**
	 * deletes an element at index and shifts elements after it to the left by 1
	 * @param index the index to have its value deleted
	 * @return the value removed
	 * @throws IndexOutOfBoundsException
	 */
	public T delete(int index) throws IndexOutOfBoundsException
	{
		// to remove the gap. Throw an exception when there is an invalid
		// index (see replace(), get(), etc. above).
		if ((index >= data.length) || (index < 0))
		{
			throw new IndexOutOfBoundsException("Index " + index + " out of bounds!");// if index i invalid the method will be exited and an error will be thrown
		}
		T removed =data[index];
		T[] new_arr = (T[]) new Comparable[data.length];// new empty array
		for(int i=0;i<data.length-1;i++)
		{
			if(i<index)// if before removed number
			{
				new_arr[i]=data[i];// elements copied over 1to1
			}
			else
				if(i>=index)
				{
					//System.out.println(this.toString());
					new_arr[i]=data[i+1];//elements copied over one to the left
				}
		}
		this.data=new_arr;

		// Remove and return the element at the given index. Shift elements
		// After deletion, if the number of elements falls below 1/3
		// of the capacity, you must call halveCapacity() to shrink the storage.

		// - Check halveCapacity() below for details.
		// - If the capacity would fall below the DEFAULT_CAPACITY,
		//   shrink to the DEFAULT_CAPACITY. This should be implemented by
		//   halveCapacity().
		if((size()-1<capacity()/3))// if num of elements is less than one third of arr data size
		{
			halveCapacity();
		}

		
		// O(N) where N is the number of elements currently in the storage
			return removed;

	}

	/**
	 * doubles capacity, unless doubling it would be too big then it defaults to max int -50. if its already max int -50 it does not double
	 * @return if the doubling of the size of the array is successful or not
	 */
	@SuppressWarnings("unchecked")
	public boolean doubleCapacity(){
		// - If the current capacity is already this upper-bound (Integer.MAX_VALUE - 50),
		//   do not expand and return false.
		if(capacity()==Integer.MAX_VALUE-50)
		{
			return false;
		}
		// - Out of abundance of caution, we will use (Integer.MAX_VALUE - 50)
		//   as the upper-bound of our capacity.
		// - If double the current capacity would go beyond this upper-bound,
		//   use this upper-bound value as the new capacity.
		int new_size=0;
		if(capacity()*2>Integer.MAX_VALUE-50)// if double the current capaicty is above the limit
		{
			new_size = Integer.MAX_VALUE-50; // this will be the new size
		}
		else// if doubling is still under the limit then we double
			new_size = capacity()*2;
		// Double the max number of items allowed in data storage.
		// Remember to copy existing items to the new storage after expansion.
		T[] new_arr = (T[]) new Comparable[new_size];// array with double capacity of old one
		for(int i = 0;i < this.data.length;i++)// goes thru array
		{
			new_arr[i]=this.data[i];// copies values over
		}

		this.data=new_arr;// data is set to point to new array with double capacity and copied over values




		
		// Return true for a successful expansion.

		// O(N) where N is the number of elements in the array

		return true; //default return, remove/change as needed

	}

	/**
	 * halves capacity while preseving elements
	 * @return if the halving was sucessful or not. if the size after havling is below default capacity, returns false. true otherwise
	 */
	@SuppressWarnings("unchecked")
	public boolean halveCapacity(){
		// - If the new capacity would fall below the DEFAULT_CAPACITY,
		//   shrink to the DEFAULT_CAPACITY;
		int new_size;
		// - If the new capacity (after necessary adjustment to DEFAULT_CAPACITY)
		//   cannot hold all existing items, do not shrink and return false;

		if(capacity()/2<=DEFAULT_CAPACITY)
		{
			new_size=DEFAULT_CAPACITY;
			if(new_size<size())
			{
				return false;
			}
		}


		// Reduce the max number of items allowed in data storage by half.
		// - If the current capacity is an odd number, _round down_ to get the
		//   new capacity;


		 else if(capacity()%2==1)
		{
			new_size=(capacity()-1)/2;// if curr capacity is odd
		}
		else {// if curr capacity is even
			new_size = capacity() / 2;// size cut in half
		}


		T[] new_arr = (T[]) new Comparable[new_size]; // array  created with half size
		//System.out.println(toString());
		for(int i=0;i<new_size;i++)
		{
			//System.out.println(data[i]);
			new_arr[i]=data[i];//elements copied over
		}
		//pointer updated
		this.data=new_arr;
		return true;


		// - Return true for a successful shrinking.

		// Remember to copy existing items to the new storage after shrinking.
		
		// O(N) where N is the number of elements in the array
		

		

	}
	//******************************************************
	//*******     BELOW THIS LINE IS TESTING CODE    *******
	//*******      Edit it as much as you'd like!    *******
	//*******		Remember to add JavaDoc			 *******
	//******************************************************
	
	public String toString() {
		//This method is provided for debugging purposes
		//(use/modify as much as you'd like), it just prints
		//out the MySortedArray for easy viewing.
		StringBuilder s = new StringBuilder("MySortedArray with " + size()
			+ " items and a capacity of " + capacity() + ":");
		for (int i = 0; i < size(); i++) {
			s.append("\n  ["+i+"]: " + get(i));
		}
		return s.toString();
		
	}

	
	public static void main(String[] args){
		//These are _sample_ tests. If you're seeing all the "yays" that's
		//an excellend first step! But it might not mean your code is 100%
		//working... You may edit this as much as you want, so you can add
		//own tests here, modify these tests, or whatever you need!

		//create a MySortedArray of integers
		MySortedArray<Integer> nums = new MySortedArray<>();
		if((nums.size() == 0) && (nums.capacity() == 2)){
			System.out.println("Yay 1");
		}

		//append some numbers 
		for(int i = 0; i < 3; i++) {
			//System.out.println(i);
			nums.add(i,i*2);
		}
		//uncomment to check the array details
		//System.out.println(nums.toString());
		
		
		if(!nums.add(nums.size(),1) && nums.size() == 3 && nums.get(2) == 4 && nums.capacity() == 4){
			System.out.println("Yay 2");
		}
		//System.out.println(nums.toString());
		
		//add more numbers, your insertion need to keep the array sorted
		//System.out.println(nums.toString());

		nums.add(1);
		nums.add(-1);
		nums.add(5);
		if (nums.size() == 6 && nums.get(0)==-1 && nums.get(2) == 1 && nums.get(5) == 5){
			System.out.println("Yay 3");
		}
		//System.out.println(nums.toString());
		
		//add with index
		if (nums.add(4,2) && nums.add(3,2) && nums.get(3) == nums.get(4) 
			&& nums.get(4) == nums.get(5) && nums.get(5)== 2){ 	
			System.out.println("Yay 4");		
		}
		//System.out.println(nums.toString());
		
		//replace with index
		if (nums.replace(5,3) && nums.get(5)==3 && nums.replace(6,5) && nums.get(6)==5
			&& !nums.replace(1,2) && nums.get(1) == 0){
			System.out.println("Yay 5");				
		}
		//System.out.println(nums.toString());
		
		MySortedArray<String> names = new MySortedArray<>();
		
		//insert some strings
		names.add("alice");
		names.add("charlie");
		names.add("bob");
		names.add("adam");
		//System.out.println(names.toString());

		//delete
		if (names.add(4,"emma") && names.delete(3).equals("charlie")){
			System.out.println("Yay 6");
		}
		
		names.delete(0);
		names.delete(0);
		
		//shrinking
		if (names.size()==2 && names.capacity() == 4){
			System.out.println("Yay 7");
		}
		//System.out.println(names.toString());
		
		//insert equal values: sorted by insertion order
		String dylan1 = new String("dylan");
		String dylan2 = new String("dylan");
		names.add(dylan1);
		names.add(dylan2);
		if (names.size()==4 && names.get(1) == dylan1 && names.get(2) == dylan2
			&& names.get(1)!=names.get(2)){
			System.out.println("Yay 8");		
		}
		//System.out.println(names.toString());
		
		// exception checking example
		// make sure you write more testings by yourself
		try{
			names.get(-1);
		}
		catch(IndexOutOfBoundsException ex){
			if (ex.getMessage().equals("Index -1 out of bounds!"))
				System.out.println("Yay 9");
		}
		//System.out.println(names.toString());
		//names.doubleCapacity();

		//System.out.println(names.toString());
		//names.halveCapacity();
		//System.out.println(names.toString());
		// call doubleCapacity() and halveCapacity() directly
		if (names.doubleCapacity() && names.capacity() == 8 
			&& names.halveCapacity() && names.capacity() == 4
			&& !names.halveCapacity() && names.capacity() == 4){
			System.out.println("Yay 10");
		
		}
		//System.out.println(names.toString());

	}
	

}