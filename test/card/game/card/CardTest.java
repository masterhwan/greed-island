package card.game.card;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import card.game.exception.IllegalCardException;

public class CardTest {
	private Card card;

	@Before
	public void setUp() {
		card = new Card(1, "safari of room", Rank.SS, 3, "test");
	}

	@Test
	public void create() throws Exception {
		verifyCard(Card.create(1), card);
	}

	@Test(expected = IllegalCardException.class)
	public void create_faild() throws Exception {
		verifyCard(Card.create(10001), card);
	}

	private void verifyCard(Card card1, Card card2) {
		assertEquals(card2, card1);
	}
}
