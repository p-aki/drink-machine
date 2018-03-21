package CoinOperator;
public class CoinNumber {
	private int OneHundredCoinNumber_;
	private int FiveHundredCoinNumber_;

	public CoinNumber(int initAmountOne, int initAmountFive) {
		this.OneHundredCoinNumber_ = initAmountOne;
		this.FiveHundredCoinNumber_ = initAmountFive;
	}

	public void add(Coin coin) {
		if (coin == Coin.ONE_HUNDRED) {
			this.OneHundredCoinNumber_ += 1;
			return;
		}
		this.FiveHundredCoinNumber_ += 1;
	}

	public boolean negative(Coin coin) {
		if (coin == Coin.ONE_HUNDRED) {
			return raundUpNegativeForOne();
		}
		this.FiveHundredCoinNumber_ -= 1;
		return false;
	}

	public void initial() {
		this.OneHundredCoinNumber_ = 0;
		this.FiveHundredCoinNumber_ = 0;
	}

	public boolean hasCoinsAtLeast(int oneCoinNumber, int fiveCoinNumber) {
		if(this.OneHundredCoinNumber_ >= oneCoinNumber && this.FiveHundredCoinNumber_ >= fiveCoinNumber) {
			return true;
		}
		return false;
	}

	public boolean equals(CoinNumber coinNumber) {
		return (this.OneHundredCoinNumber_ == coinNumber.getOneHundredCoinNumber() && this.FiveHundredCoinNumber_ == coinNumber.getFiveHundredCoinNumber());
	}

	public int getOneHundredCoinNumber() {
		return this.OneHundredCoinNumber_;
	}

	public int getFiveHundredCoinNumber() {
		return this.FiveHundredCoinNumber_;
	}

	public static CoinNumber createCoinNumber(CoinNumber coinNumber) {
		return new CoinNumber(coinNumber.getOneHundredCoinNumber(), coinNumber.getFiveHundredCoinNumber());
	}

	private boolean raundUpNegativeForOne() {
		if(this.hasCoinsAtLeast(1, 0)) {
			this.OneHundredCoinNumber_--;
			return false;
		}

		this.FiveHundredCoinNumber_--;
		this.OneHundredCoinNumber_ += 4;
		return true;
	}
}
