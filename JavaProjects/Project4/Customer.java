public class Customer {
    private int arrivalTime;
    private int transactionTime;
    private int id;

    public Customer(int arrivalTime, int transactionTime, int id) {
        this.arrivalTime = arrivalTime;
        this.transactionTime = transactionTime;
        this.id = id;
    }

    public int getArrivalTime() {
        return this.arrivalTime;
    }

    public int getTransactionTime() {
        return this.transactionTime;
    }

    public int getId() {
        return this.id;
    }

    public String toString() {
        return "Customer " + id + " (" + transactionTime + "s transaction)";
    }
}