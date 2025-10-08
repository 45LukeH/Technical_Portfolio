import java.util.HashMap;
import java.util.List;
import java.util.ArrayDeque;
import java.util.Queue;

public class Portfolio implements PortfolioInterface {

    private HashMap<Ticker, Queue<Lot>> positions;
    private HashMap<Ticker, Double> profits;

    public Portfolio() {
        this.positions = new HashMap<Ticker, Queue<Lot>>();
        this.profits = new HashMap<Ticker, Double>();
    }

    // Optional helper method to update a ticker's profit (or loss, if it's negative) in the `profits` HashMap with the value of `profit`.
    // Ex: If the ticker key AAPL has a value of 52.50 and we record a profit of -5.00, 
    // then the new value for AAPL will be updated to 47.50.
    //
    // Hint: If the profits HashMap already contains ticker, update the profit value
    //       If the profits HashMap doesnt contain the ticker, add a new entry
    private void updateProfit(Ticker ticker, double profit) {
        // TODO: implement or delete this helper method
        // if ticker is in map, add to value
        if (profits.containsKey(ticker)) {
            profits.put(ticker, profits.get(ticker) + profit);
        }
        else {
            // make a new ticker entryu if ticker isn't already in the mao
            profits.put(ticker, profit);
        }
    }

    // Optional helper method that adds a lot to the back of the relevant `positions` Deque, based on lot.getTicker().
    //
    // Hint: If the positions HashMap already contains a Deque for this lot's ticker, add to it.
    //       If the positions HashMap doesn't contain this ticker yet, create a new Deque and add it to the HashMap.
    private void addLot(Lot lot) {
        // TODO: implement or delete this helper method
        Ticker ticker = lot.getTicker();
        // create a queue if there isn't one already
        if (!positions.containsKey(ticker)) {
            positions.put(ticker, new ArrayDeque<>());
        }
        // add the lot in the queue
        positions.get(ticker).add(lot);
    }

    public void handleTrade(Trade trade) {
        // TODO: implement this method. Details in PortfolioInterface.java.
        Lot lot = trade.getLot();
        Ticker ticker = lot.getTicker();
        // if the trade type is buy, we add its lot to the port
        if (trade.getType() == Trade.TradeType.BUY) {
            addLot(lot);
        }
        // for sells, we need to sell FIFO
        else if (trade.getType() == Trade.TradeType.SELL) {
            int sellShare = lot.getQuantity();
            double sellPrice = lot.getPricePerShare();
            Queue<Lot> queue = positions.get(ticker);
            // sell all requested shares
            while(!queue.isEmpty() && sellShare > 0) {
                // find oldest purchase
                Lot boughtLot = queue.peek();
                int availableShares = boughtLot.getQuantity();

                // if the available shares are less or equal to the shares to sell, sell the whole lot
                if (availableShares <= sellShare) {
                    double profit = (sellPrice - boughtLot.getPricePerShare()) * availableShares;
                    updateProfit(ticker, profit);
                    sellShare -= availableShares;
                    // remove the lot from queue
                    queue.poll();
                }
                else {
                    // else sell what you can
                    double profit = (sellPrice - boughtLot.getPricePerShare()) * sellShare;
                    updateProfit(ticker, profit);
                    // update remaining shares and sellShares will be set to nothing
                    boughtLot.setQuantity(availableShares - sellShare);
                    sellShare = 0;
                }
            }
        }
    }

    public void handleTrades(List<Trade> trades) {
        // TODO: implement this method. Details in PortfolioInterface.java.
        // simply use the helper method with an enhanced for loop
        for (Trade trade : trades) {
            handleTrade(trade);
        }
    }

    public double getProfit(Ticker ticker) {
        // TODO: implement this method. Details in PortfolioInterface.java.
        // if the ticker is in the map, return it, and if not, return 0
        if (profits.containsKey(ticker)) {
            return profits.get(ticker);
        }
        else {
            return 0;
        }
    }

    public double getTotalProfit() {
        // TODO: implement this method. Details in PortfolioInterface.java.
        // use a for loop to add/subtract from total
        double total = 0;
        for (double value : profits.values()) {
            total += value;
        }
        return total;
    }

    public int getSharesHeld(Ticker ticker) {
        // TODO: implement this method. Details in PortfolioInterface.java.
        // track shares
        int totalShares = 0;
        Queue<Lot> queue = positions.get(ticker);
        // if queue isnt null, add quantity for the lots
        if(queue != null) {
            for (Lot lot : queue) {
                totalShares += lot.getQuantity();
            }
        }
        return totalShares;
    }
}
