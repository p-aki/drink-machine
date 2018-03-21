package Drink;

/***
 * 私の手に負えない
 *
 */
public interface IDrinkStock {

	boolean available(DefaultDrinkType kindOfDrink);

	void takeOut(DefaultDrinkType kindOfDrink);

}
