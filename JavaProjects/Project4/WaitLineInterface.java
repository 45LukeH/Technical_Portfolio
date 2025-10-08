

/**
 * Interface for a line of Customer objects.
 */
public interface WaitLineInterface {

    /**
     * Adds `newCustomer` to the end of the queue
     */
    public void addCustomer(Customer newCustomer);

    /**
     * Returns whether or not there are any Customers waiting in the queue
     */
    public boolean hasCustomer();

    /**
     * Removes a Customer from the front of the queue and records the Customer's wait time. 
     * @param time the time that the Customer was served
     * @return the Customer that was served
     */
    public Customer serveCustomer(int time);

    /**
     * Returns the total number of Customers that arrived
     * @return the number of Customers that were placed in the queue
     */
    public int getTotalNumArrivals();

    /**
     * Returns the total number of Customers that have been served
     * @return the number of Customers that were removed from the queue
     */
    public int getTotalCustomersServed();
    
    /**
     * Returns the total amount of time waited by all served Customers combined.
     * Customers that are still waiting in the queue should not count towards this.
     * @return the sum value of all served Customer's wait times.
     */
    public int getTotalTimeWaited();

}