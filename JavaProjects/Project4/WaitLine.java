public class WaitLine extends Queue<Customer> implements WaitLineInterface {
    // init some variables to keep track of customers, how many have been served, and time
    private int totArrivals;
    private int totServed;
    private int totTime;

    // similar to queue file, make a waitline constructor to init an empty waitline
    public WaitLine() {
        super();
        totArrivals = 0;
        totServed = 0;
        totTime = 0;
    }
    /**
     * Adds `newCustomer` to the end of the queue
     */
    @Override
    public void addCustomer(Customer newCustomer) {
        // enqueue a new customer and track the arrival
        enqueue(newCustomer);
        totArrivals++;
    }

    /**
     * Returns whether or not there are any Customers waiting in the queue
     */
    @Override
    public boolean hasCustomer() {
        // can just use the isEmpty method (basicallty opposite of isEmpty)
        return !isEmpty();
    }

    /**
     * Removes a Customer from the front of the queue and records the Customer's wait time. 
     * @param time the time that the Customer was served
     * @return the Customer that was served
     */
    @Override
    public Customer serveCustomer(int time) {
        // remove a customer from the front
        Customer customer = dequeue();
        // make a variable for how long the customer was waiting
        int waitingTime = time - customer.getArrivalTime();
        // add the waiting time to the total time
        totTime += waitingTime;
        totServed++;
        return customer;
    }

    /**
     * Returns the total number of Customers that arrived
     * @return the number of Customers that were placed in the queue
     */
    @Override
    public int getTotalNumArrivals(){
    // simple getters for this and next 2 methods
        return totArrivals;
    }

    /**
     * Returns the total number of Customers that have been served
     * @return the number of Customers that were removed from the queue
     */
    @Override
    public int getTotalCustomersServed() {
        return totServed;
    }
    
    /**
     * Returns the total amount of time waited by all served Customers combined.
     * Customers that are still waiting in the queue should not count towards this.
     * @return the sum value of all served Customer's wait times.
     */
    @Override
    public int getTotalTimeWaited() {
        return totTime;
    }

}

