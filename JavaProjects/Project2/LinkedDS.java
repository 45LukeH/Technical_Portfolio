
public class LinkedDS<T> implements SequenceInterface<T> {

    private Node[] array; //1-D array of linked lists
    private int size; //the number of items in the sequence
    private T[] alphabet; //the possible item values (e.g., the decimal digits)
    private T firstItem; //the first item
    private T lastItem; //the last item
  
    public LinkedDS(T[] alphabet){
		//TODO: implement this constructor
		// init constructor with all variables
		this.array = new Node[alphabet.length];
		this.size = 0;
		this.alphabet = alphabet;
		this.firstItem = null;
		this.lastItem = null;
    }
    
	// adding a helper method to the top to make the list be able to find an item at a certain
	// index, will have to be O(n)
	private int findIndex(T item) {
		for (int i = 0; i < alphabet.length; i++) {
			if (alphabet[i].equals(item)) {
				return i;
			}
		}
		throw new IllegalArgumentException("Item not found");
	}

    /** Add a new Object to the logical start of the sequence in O(1) time
	 * @param item the item to be added.
	 */
	public void push(T item){
		//TODO: implement this method
		// get the index and create a new node that needs to be pushed in at that position
		int pos = findIndex(item);
		Node newNode = new Node(pos);
		// if the list is empty assign both first and last item to item
		if (size ==0) {
			firstItem = item;
			lastItem = item;
			// if the size is greater than 0, assign item to top of stack and increase size
		} 
		else {
			// new node goes to the end of the list
			newNode.next = array[pos];
			array[pos] = new Node(findIndex(firstItem), newNode);
			// update the firstItem variable with the item pushed in
			firstItem = item;
		}
		size++;
	}

    /** Delete the item at the logical start of the sequence in O(1) item
	 * @return the deleted item
	 * @throws EmptySequenceException if the sequence is empty
	 */
	public T pop(){
        //TODO: implement this method
		// throw sequenceException if sequence is empty
		if (size == 0) {
			throw new EmptySequenceException("List empty.");
		}
		// first item is what needs to be popped and returned
		T item = firstItem;
		int pos = findIndex(item);
		// make sure the item at postion is not empty
		if (array[pos] != null) {
			// update the first items data
			firstItem = alphabet[array[pos].item];
			//get rid of the first node
			array[pos] = array[pos].next;
		}
		// if the reference points to null, then both first and last are null
		if (size == 0 ){
			firstItem = null;
			lastItem = null;
		}
		size--;
		return item;
    }



	/** Check if the sequence is empty in O(1) time
	 * @return true if the sequence is empty, and false otherwise
	 */
	public boolean isEmpty(){
		//TODO: implement this method
		// if size of sequence is 0, will return true, if > 0 it will return false
        return size == 0;
    }

	/** Return the number of items in the sequence in O(1) time
	 * @return the number of items currently in the sequence
	 */
	// simple getter for size of sequence
	public int size(){
		//TODO: implement this method
        return size;
    }

	/**
	 * @return the the logically first item in the sequence in O(1) time
	 */
	// simple getter for first item of sequence
	public T first(){
		//TODO: implement this method
        return firstItem;
    }

	/**
	 * @return the the logically last item in the sequence in O(1) time
	 */
	// same thing as first item here
	public T last(){
		//TODO: implement this method
        if (size == 0) {
			return null;
		}
		else {
		return lastItem;
		}
    }

    /** Return the number of times in the sequence that an item appears.
     * The running time is O(frequency of item in sequence).
	 * @param item an T item
	 * @return the number of occurences in the sequence of item
	 */
	public int getFrequencyOf(T item){
        //TODO: implement this method
		// start by init a counter 
		int count = 0;
		// make a position var like methods above to easilyt find the index of the item
		int pos = findIndex(item);
		// make a new node called current node, taking the index of the item
		Node current = array[pos];
		// as long as the current node is not null, then the count will increased
		// this will go through the list and incrememt the count
		while (current != null) {
			if (alphabet[current.item].equals(item)) {
				count++;
			}
			current = current.next;
		}
		return count;
    }


	/** Return the number of times in the sequence that an ordered pair of 
	 * items appear in the sequence. The running time is O(frequency of first 
	 * item).
	 * @param first the first item in the ordered pait
	 * @param second the second item in the ordered pair
	 * @return the number of occurences in the sequence of (first, second)
	 */
	public int getFrequencyOf(T first, T second){
        //TODO: implement this method
		// very similar to the first method to begin
		int count = 0;
		int pos = findIndex(first);
		Node current = array[pos];
		while (current != null) {
			// if its an ordered pair, incrememnt the count
			if (alphabet[current.item].equals(second)) {
				count++;
			}
			current = current.next;
		}
		return count;
    }

	/**
	 * Returns an array of all unique successors of an item in the sequence.
	 * The running time should be better than or equal to 
	 * O(frequency of item in sequence * number of successors).
	 * @param item an item
	 * @return an array of all unique successors of item or null if 
     * item doesn't exist in the sequence.
	 */
	@SuppressWarnings("unchecked")
	public T[] successors(T item){
        //TODO: implement this method
		int pos;
		// use a try/catch block to ensure all illegal arguments are caught
		try {
			pos = findIndex(item);
		} 
		catch (IllegalArgumentException e) {
			return null;
		}
		// if the item is not in the list (null) create a new object at position 0
		if (array[pos] == null) { 
			return (T[]) new Object[0];
		}
		// needs an array of booleans to track successors easier
		boolean[] found = new boolean[alphabet.length];
		int count = 0;
		Node current = array[pos];
		// as long as the current node is not null, it will go through the list
		while (current != null && current.next != null) {
			int nextIndex = current.next.item;
			// if the successor was not "found" then find it
			if (!found[nextIndex]) {
				
				// set the boolean to true and incrememnt count
				found[nextIndex] = true;
				count++;
			}
			current = current.next;
		}
		// make a generic result array that will be returned, tracks the successors
		T[] result = (T[]) new Object[count];
		int position = 0;
		for (int i = 0; i < found.length; i++) {
			if (found[i]) {
				result[position++] = alphabet[i];
			}
		}
		return result;
    }

    private static class Node {
        private int item; //index in alphabet of item
        private Node next;
    
        private Node(int item){
            this.item = item;
            next = null;
        }
		// add constructor that takes in a Node as well, allows findIndex to work propery
		private Node(int item, Node next) {
			this.item = item;
			this.next = next;
		}
    }
}