package constant;

/**
 * ENUM which represents possible cell states
 */
public enum CellState {

    ALIVE("*"),

    DEAD(" ");

    private final String symbol;

    CellState(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return this.symbol;
    }
}
