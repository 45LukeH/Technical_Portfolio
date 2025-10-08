public class ArrayDS<T> implements SequenceInterface<T> {

    // Required fields
    private final BagInterface<T>[][] array; // the underlying 2-D array
    private int size; // the number of items in the sequence
    private T[] alphabet; // the possible item values (e.g., the decimal digits)
    private T firstItem; // the first item in the sequence
    private T lastItem; // the last item in the sequence
    // Additional fields can go here
    

    @SuppressWarnings("unchecked")
    public ArrayDS(T[] alphabet) {
        this.alphabet = alphabet;
		this.array = new BagInterface[alphabet.length][alphabet.length]; 
        for(int i=0; i < alphabet.length; i++) {
            for(int j=0; j < alphabet.length; j++) {
                array[i][j] = new ResizableArrayBag<T>();
            }
        }
        this.size = 0;
    }
    // i have to create a helper method. I am running into a few issues
    // and can't think of any other solutions
    private T getItemAt(int position) {
        T[] items = array[position][position].toArray();
        return items.length > 0 ? items[0] : null;
    }
   
    //https://www.geeksforgeeks.org/stringbuilder-class-in-java-with-examples/
    @Override
    public String toString() {
        if (size == 0) {
        return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            if (!array[i][i].isEmpty()) {
                for (T item : array[i][i].toArray()) {
                    sb.append(item);
                }
            }
        }
        return sb.toString();
    }
// add item to array
    public void append(T item) {
        if (size >= array.length) {
            throw new ArrayIndexOutOfBoundsException("Sequence is full!!!");
        }
        array [size][size] = new ResizableArrayBag<>();
        array[size][size].add(item);
        // if the array is empty, make the firstItem the appended item
        if (size == 0) {
            firstItem = item;
        }
        // after this, increment size and store item at the end as lastItem
        // (if just 1 item, it will be both first and last)
        lastItem = item;
        size++;
    }
// add item to front
    public void prefix(T item) {
        if (size >= array.length) {
            throw new ArrayIndexOutOfBoundsException("Sequence is full!!!");
        }
        // shift items right
        for (int i = size; i > 0; i--) {
            array[i][i] = array[i-1][i-1];
        }
        // put the item at the front now that all indexes increased by 1
        array[0][0] = new ResizableArrayBag<>();
        array[0][0].add(item);
        firstItem = item;
        if (size == 0) {
            lastItem = item;
        }
        size++;
    }
// get rid of first sequence item
    public T deleteHead() {
        if (isEmpty()) {
            throw new EmptySequenceException("Nothing in the sequence.");
        }
        T itemDeleted = firstItem;
        // shfit items left
        for (int i = 0; i < size - 1; i++) {
            array[i][i] = array[i + 1][i + 1];
        }
        array[size - 1][size - 1] = new ResizableArrayBag<>();
        size--;
        // use ternary op here for efficiency
        firstItem = (size > 0) ? getItemAt(0) : null;
        return itemDeleted;
    }
// get rid of last sequence item
    public T deleteTail() {
        if (isEmpty()) {
            throw new EmptySequenceException("Nothing in the sequence.");
        }
        T itemDeleted = lastItem;
        array[size - 1][size - 1] = new ResizableArrayBag<>();
        size--;
        // follow same logic ^ but with lastItem
        lastItem = (size > 0) ? getItemAt(size - 1) : null;
        return itemDeleted;
    }
// return true if empty, or 0
    public boolean isEmpty() {
        return size == 0;
    }
// size, first, and last are all simple getters
    public int size() {
        return size;
    }

    public T first() {
        return firstItem;
    }

    public T last() {
        return lastItem;
    }
// check if another is subsequence of sequence
    public boolean hasSubsequence(SequenceInterface<T> another) {
        // all booleans here return false because another needs a reference
        if (another == null || another.isEmpty() || this.size < another.size()) {
            return false;
        }
        // turn both sequences to arrays
        T[] main = this.toArray();
        T[] sub = another.toArray();
        int mainSize = this.size;
        int subSize = another.size();
        // go through main to look for a pair
        for (int i = 0; i <= mainSize - subSize; i++) {
            boolean match = true;
            for (int j = 0; j < subSize; j++) {
                if (!main[i+j].equals(sub[j])) {
                    match = false;
                    // no subsequence found, break loop
                    break;
                }
            }
            if (match) {
                return true;
            }
        }
        // if no pairs are found we'll return false
        return false;
    }
// check if T first precedes T second,
    public boolean predecessor(T first, T second) {
        int firstIndex = indexInAlphabet(first);
        int secondIndex = indexInAlphabet(second);
        // if returning true, then first preceds second
        return firstIndex >= 0 && secondIndex > firstIndex;
    }

// simnple counter for T item
    public int getFrequencyOf(T item) {
        int frequency = 0;
        for (int i = 0; i < size; i++) {
            if (array[i][i].contains(item)) {
                frequency++;
            }
        }
        return frequency;
    }
// clear the sequence of all elements
    public void clear() {
        while(!isEmpty()) {
            // can use either deletion method
            deleteHead();
        }
      
    }
// return an integer at int position
    public T itemAt(int position) {
        if (position < 0 || position >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds.");
        }
        return getItemAt(position);
    }
    @SuppressWarnings("unchecked")
    public T[] toArray() {
        T[] result = (T[]) new Object[size];
        for (int i = 0; i < size; i++) {
            result[i] = getItemAt(i);
        }
        return result;
    }
// find the smallest index T item appears at
    public int firstOccurrenceOf(T item) {
        for (int i = 0; i < size; i++) {
            if (array[i][i].contains(item)) {
            return i;
            }
        }
        return -1;
    }
// get index of alphabet instead of sequence
    public int indexInAlphabet(T item) {
        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i].equals(item)) {
                return i;
            }
        }
       return -1;
    }
// return the next index of an item at a given position
    public int nextIndex(T item, int position) {
        // fixed some logic so it won't search for new index at the end of array
        if (position < 0 || position >= size - 1) { 
            return -1;
        }
        for (int i = position + 1; i < size; i++) {
            if (array[i][i].contains(item)) {
                return i;
            }
        }
        //???
        return position;

    }
// same thing ^, just backwards
    public int prevIndex(T item, int position) {
        if (position <= 0 || position >= size) {
            return -1;
        }
        for (int i = position - 1; i >= 0; i--) {
            if (array[i][i].contains(item)) {
                return i;
            }
        }
        // is this the problem??
        return position;
    }

    // The end!

}
