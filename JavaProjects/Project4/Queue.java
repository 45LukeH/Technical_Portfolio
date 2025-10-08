public class Queue<T> implements QueueInterface<T> {

    // make an inner class for nodes
    private class Node {
        private T data;
        private Node next;
        private Node previous;

        private Node(T data) {
            this.data = data;
            this.next = null;
            this.previous = null;
        }
    }

    // make a first and lastNode variable to access front and back of queue
    private Node firstNode;
    private Node lastNode;

    // initialize a construcotr for making an empty queue
    public Queue() {
        firstNode = null;
        lastNode = null;
    }

    /**
     * Adds a new entry to the back of this queue.
     * 
     * @param newEntry An object to be added.
     */
    @Override
    public void enqueue(T newEntry) {
        Node newNode = new Node(newEntry);
        // if the chain is empty, set both first and last node to newNode
        if (isEmpty()) {
            firstNode = newNode;
            lastNode = newNode;
        } else {
            // doubly linked list needs to have refernce both the next and previous nodes
            lastNode.next = newNode;
            newNode.previous = lastNode;
            // the last node should become the newNode, adding it to the back
            lastNode = newNode;
        }
    }

    /**
     * Removes and returns the entry at the front of this queue.
     * 
     * @return The object at the front of the queue.
     * @throws EmptyQueueException if the queue is empty before the operation.
     */
    @Override
    public T dequeue() {
        // if there's nothing to take out, throw exception
        if (isEmpty()) {
            throw new EmptyQueueException("Cannot dequeue from empty queue");
        }
        // init variable to return at end of method
        T frontVal = firstNode.data;

        firstNode = firstNode.next;
        if (firstNode == null) {
            // if its empty, or first is null, then last must be null too
            lastNode = null;
        } else {
            firstNode.previous = null;
        }
        return frontVal;
    }

    /**
     * Retrieves the entry at the front of this queue.
     * 
     * @return The object at the front of the queue.
     * @throws EmptyQueueException if the queue is empty.
     */
    @Override
    public T getFront() {
        // if it's empty, there's no data to retrieve
        if (isEmpty()) {
            throw new EmptyQueueException("Empty queue. Nothing to retrieve");
        }
        return firstNode.data;
    }

    /**
     * Detects whether this queue is empty.
     * 
     * @return True if the queue is empty, or false otherwise.
     */
    @Override
    public boolean isEmpty() {
        return firstNode == null;
        // if it's null, it will return true. if it has data, it will return false
    }

    /** Removes all entries from this queue. */
    @Override
    public void clear() {
        // we can simply set bnoth nodes to null
        lastNode = null;
        firstNode = null;
    }

}
