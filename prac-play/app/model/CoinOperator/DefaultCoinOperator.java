package CoinOperator;
import java.util.stream.IntStream;

public class DefaultCoinOperator implements ICoinOperator {
	CoinNumber totalAmount_;
	CoinNumber coinStock_;

	public DefaultCoinOperator() {
		/*問題で与えられたデフォルト値*/
		this(0, 0, 10, 0);
	}

	public DefaultCoinOperator(int initAmountOne,int initAmountFive,int initCoinStockOne, int initCoinStockFive) {
		this.totalAmount_ = new CoinNumber(initAmountOne, initAmountFive);
		this.coinStock_ = new CoinNumber(initCoinStockOne, initCoinStockFive);
	}

	@Override
	public boolean addTotalAmount(Coin amount) {
		if(amount == Coin.FIVE_HUNDRED || amount == Coin.ONE_HUNDRED) {
			this.totalAmount_.add(amount);
			return true;
		}
		return false;
	}

	@Override
	public boolean available() {
		if(!this.totalAmount_.hasCoinsAtLeast(1, 0) && !this.coinStock_.hasCoinsAtLeast(4, 0)) {
			return false;
		}
		return true;
	}


	@Override
	public void negatine() {
		if (this.totalAmount_.negative(Coin.ONE_HUNDRED)) {
			this.coinStock_.add(Coin.FIVE_HUNDRED);

			IntStream.range(0, 4)
			    .forEach((i) ->
			        this.coinStock_.negative(Coin.ONE_HUNDRED)
			    );
			return;
		}
		this.coinStock_.add(Coin.ONE_HUNDRED);
	}

	@Override
	public CoinNumber refund() {
		CoinNumber refundCoinNumber = CoinNumber.createCoinNumber(this.totalAmount_);
		this.totalAmount_.initial();
		return refundCoinNumber;
	}

}
