import static org.junit.Assert.*;

import org.junit.Test;

import CoinOperator.Coin;
import CoinOperator.CoinNumber;

public class CoinNumberTest {

	@Test
	public void test() {
		CoinNumber target = new CoinNumber(5, 7);
		target.add(Coin.ONE_HUNDRED);
		target.add(Coin.FIVE_HUNDRED);

		assertTrue(target.equals(new CoinNumber(6, 8)));

		target.negative(Coin.ONE_HUNDRED);
		target.negative(Coin.FIVE_HUNDRED);

		assertTrue(target.equals(new CoinNumber(5, 7)));
	}

	@Test
	public void test_more() {
		CoinNumber target = new CoinNumber(2, 6);
		assertTrue(target.hasCoinsAtLeast(2,0));
		assertTrue(!target.hasCoinsAtLeast(3, 0));

		assertTrue(target.hasCoinsAtLeast(0,6));
		assertTrue(!target.hasCoinsAtLeast(0,7));
	}
}
