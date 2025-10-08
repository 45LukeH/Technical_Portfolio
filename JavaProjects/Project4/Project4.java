import java.lang.Math;

public class Project4 {
    private static final int DURATION = 600;
    private static final double ARRIVAL_PROB = 0.1;
    private static final int MAX_TRANSACTION_TIME = 30;

    public static void main(String[] args) {
        int nextId = 1;
        WaitLine q = new WaitLine();
        int transactionTimeLeft = 0;
        for (int clock = 0; clock < DURATION; clock++) {
            if (Math.random() < ARRIVAL_PROB) {
                Customer c = new Customer(clock, (int)(Math.random() * MAX_TRANSACTION_TIME + 1), nextId++);
                q.addCustomer(c);
                System.out.println(c + " arrived at time " + clock);
            }
            if (transactionTimeLeft == 0) {
                // ready for a new customer!
                if (q.hasCustomer()) {
                    Customer c = q.serveCustomer(clock);
                    transactionTimeLeft = c.getTransactionTime();
                    System.out.println(c + " began service at time " + clock);
                }
            } 
            else {
                // need to wait for the current transaction to complete
                transactionTimeLeft--;
            }
        }
        display(q);
    }

    public static void display(WaitLine q) {
        System.out.println();
        System.out.println("Simulation Complete!");
        System.out.println("Customer arrivals: " + q.getTotalNumArrivals());
        System.out.println("Customers served:  " + q.getTotalCustomersServed());
        System.out.println("Average wait time: " + q.getTotalTimeWaited() / (double)q.getTotalCustomersServed());
    }
}