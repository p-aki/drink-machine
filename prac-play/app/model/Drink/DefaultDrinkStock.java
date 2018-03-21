package Drink;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DefaultDrinkStock implements IDrinkStock {

	/*private IDrinkType drinkType_;*/
	private Map<DefaultDrinkType, Integer> drinkStock_;

	public DefaultDrinkStock() {
		drinkStock_ = new HashMap<>();

		Arrays.stream(DefaultDrinkType.values()).forEach((drinkType) -> {
			this.drinkStock_.put(drinkType, 5);
		});
	}
	@Override
	public boolean available(DefaultDrinkType kindOfDrink) {
		if (this.drinkStock_.get(kindOfDrink) == 0) {
			return false;
		}
		return true;
	}

	@Override
	public void takeOut(DefaultDrinkType kindOfDrink) {
		int stock = this.drinkStock_.get(kindOfDrink);
		this.drinkStock_.put(kindOfDrink, stock - 1);
	}

}
