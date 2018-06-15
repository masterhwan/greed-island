package card.game.manager;

import org.junit.Before;
import org.junit.Test;

import card.game.card.Card;
import card.game.exception.IllegalCardException;

public class ManagerCardTest {
	private ManagerCard managerCard;

	@Before
	public void setUp() {
		managerCard = new ManagerCard();
	}

	@Test
	public void createCard() throws Exception {
		managerCard.add(Card.create(1));
	}

	@Test(expected = IllegalCardException.class)
	public void createCard_faild() throws Exception {
		managerCard.add(Card.create(1));
		managerCard.add(Card.create(1));
		managerCard.add(Card.create(1));
		managerCard.add(Card.create(1));
	}
}
