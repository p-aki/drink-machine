package Drink;

public class Drink {

    private DefaultDrinkType kind_;

    public Drink(DefaultDrinkType kind) {
        this.kind_ = kind;
    }

    public DefaultDrinkType getKind() {
        return this.kind_;
    }
}