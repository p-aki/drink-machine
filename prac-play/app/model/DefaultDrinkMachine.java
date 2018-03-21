import CoinOperator.Coin;
import CoinOperator.CoinNumber;
import CoinOperator.DefaultCoinOperator;
import CoinOperator.ICoinOperator;
import Drink.DefaultDrinkStock;
import Drink.DefaultDrinkType;
import Drink.Drink;
import Drink.IDrinkStock;

public class DefaultDrinkMachine implements IDrinkMachine{

	private IDrinkStock drinkStock_;
	private ICoinOperator coinOperator_;

	public DefaultDrinkMachine() {
		this(new DefaultDrinkStock(), new DefaultCoinOperator());
	}

	public DefaultDrinkMachine(IDrinkStock drinkStock, ICoinOperator coinOperator) {
		this.drinkStock_ = drinkStock;
		this.coinOperator_ = coinOperator;
	}

    /**
     * ジュースを購入する.
     *
     * @param amount           投入金額. 100円と500円のみ受け付ける.
     * @param kindOfDrink ジュースの種類.
     *                    コーラ({@code Juice.COKE}),ダイエットコーラ({@code Juice.DIET_COKE},お茶({@code Juice.TEA})が指定できる.
     * @return 指定したジュース. 在庫不足や釣り銭不足で買えなかった場合は {@code null} が返される.
     */
    @Override
    public Drink buy(Coin amount, DefaultDrinkType kindOfDrink) {
    	if (!this.coinOperator_.addTotalAmount(amount)) {
    		return null;
    	}
    	
    	if (!this.drinkStock_.available(kindOfDrink)) {
    		return null;
    	}

    	if(!this.coinOperator_.available()) {
    		return null;
    	}

    	this.drinkStock_.takeOut(kindOfDrink);
    	this.coinOperator_.negatine();

        return new Drink(kindOfDrink);
    }

    /**
     * お釣りを取り出す.
     *
     * @return お釣りの金額
     */
    @Override
    public CoinNumber refund() {
        return this.coinOperator_.refund();
    }
}
