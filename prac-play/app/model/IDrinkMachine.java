import CoinOperator.Coin;
import CoinOperator.CoinNumber;
import Drink.DefaultDrinkType;
import Drink.Drink;

/***
 * 汎用的自動販売機
 *
 */
public interface IDrinkMachine {
	/***
	 * 購入できればDrinkインスタンスを返す
	 * 在庫切れ、つり銭切れの際はnullを返す
	 * @param coin
	 * @param drinkType
	 * @return
	 */
	Drink buy(Coin coin, DefaultDrinkType drinkType);

	/***
	 * お釣りを返す
	 * @return
	 */
	CoinNumber refund();
}
