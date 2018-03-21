package CoinOperator;
public interface ICoinOperator {

	boolean addTotalAmount(Coin amount);

	boolean available();

	void negatine();

	CoinNumber refund();

}
