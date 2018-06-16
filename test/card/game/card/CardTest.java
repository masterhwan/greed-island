package card.game.card;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import card.game.exception.IllegalCardException;

public class CardTest {
	private Card card;

	@Test
	public void create() throws Exception {
		verifyCard(Card.create(1), Card.create("한 평의 밀림"));
	}

	@Test(expected = IllegalCardException.class)
	public void create_faild() throws Exception {
		verifyCard(Card.create(10001), Card.create(10001));
	}

	private void verifyCard(Card card1, Card card2) {
		assertEquals(card2, card1);
	}
}
