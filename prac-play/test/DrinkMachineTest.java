import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import CoinOperator.Coin;
import CoinOperator.CoinNumber;
import Drink.DefaultDrinkType;

public class DrinkMachineTest {

	DefaultDrinkMachine target_;
	List<DefaultDrinkType> drinkFieldList_;

	@Before
	public void startUp() {
		target_ = new DefaultDrinkMachine();
		drinkFieldList_ = Arrays.asList(DefaultDrinkType.values());
	}

	@After
	public void tearDown() {
		target_.refund();
	}

	/***
	 * Coin.ONE_HUNDRED円入れる
	 */
	@Test
	public void test_ONE_HUNDRED_yen() {
		drinkFieldList_.stream()
		.forEach(drink -> {
			assertThat(target_.buy(Coin.ONE_HUNDRED, drink).getKind(), is(drink));
			assertTrue(target_.refund().equals(new CoinNumber(0, 0)));
		});

	}

	/***
	 * Coin.FIVE_HUNDRED円入れる
	 */
	@Test
	public void test_FIVE_HUNDRED_yen() {
		drinkFieldList_.stream()
		.forEach(drink -> {
			DefaultDrinkMachine target = new DefaultDrinkMachine();
			assertThat(target.buy(Coin.FIVE_HUNDRED, drink).getKind(), is(drink));
			assertTrue(target.refund().equals(new CoinNumber(4, 0)));
			});
	}

	/***
	 * null入れる
	 * nullが変えることを確認
	 */
	@Test
	public void test_null() {
		drinkFieldList_.stream().forEach(drink -> {
			assertNull(target_.buy(null, drink));
			assertTrue(target_.refund().equals(new CoinNumber(0, 0)));
		});
	}

	/***
	 * つり銭切れになる確認
	 */
	@Test
	public void test_つり銭不足() {
		assertThat(target_.buy(Coin.FIVE_HUNDRED, DefaultDrinkType.COKE).getKind() ,is(DefaultDrinkType.COKE));
		assertTrue(target_.refund().equals(new CoinNumber(4, 0)));

		assertThat(target_.buy(Coin.FIVE_HUNDRED, DefaultDrinkType.COKE).getKind() ,is(DefaultDrinkType.COKE));
		assertTrue(target_.refund().equals(new CoinNumber(4, 0)));

		assertNull(target_.buy(Coin.FIVE_HUNDRED, DefaultDrinkType.COKE));
		assertTrue(target_.refund().equals(new CoinNumber(0, 1)));
	}

	/***
	 * 在庫以上買うとnull
	 */
	@Test
	public void test_在庫以上買う() {
		IntStream.range(0, 5).forEach((i) -> assertThat(target_.buy(Coin.ONE_HUNDRED, DefaultDrinkType.COKE).getKind(), is(DefaultDrinkType.COKE)));
		assertNull(target_.buy(Coin.ONE_HUNDRED, DefaultDrinkType.COKE));
	}
}
