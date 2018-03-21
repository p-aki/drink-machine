package CoinOperator;

public enum Coin {
    ONE_HUNDRED(100),
    FIVE_HUNDRED(500);

    private final int value_;

    private Coin(int amount) {
        this.value_ = amount;
    }

    public int getValue() {
        return value_;
    }

}
