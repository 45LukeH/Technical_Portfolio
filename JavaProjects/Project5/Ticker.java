/**
 * Represents a stock ticker (ex: "AAPL" is Apple's stock ticker)
 * Contains one private field `symbol` which represents the actual string of the Ticker.
 * Overrides equals() and hashCode() so Tickers can be used as keys in Dictionaries that use hashing.
 */
public class Ticker {
    private String symbol;
    public Ticker(String symbol) {
        this.symbol = symbol;
    }

    public String toString() {
        return this.symbol;
    }

    public int hashCode() {
        return this.symbol.hashCode();
    }

    public boolean equals(Object other) {
        if (other instanceof Ticker) {
            return ((Ticker)other).symbol.equals(this.symbol);
        } else {
            return false;
        }
    }
}