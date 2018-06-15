package card.game.player;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import card.game.card.Card;
import card.game.exception.IllegalCardException;

public class PlayerTest {
	private Player player;
	private List<Card> cards;

	@Before
	public void setup() {
		player = new Player();
	}

	@Test
	public void create() {
		verifyUser(player, Player.create());
	}

	private void verifyUser(Player oldPlayer, Player newPlayer) {
		assertEquals(oldPlayer, newPlayer);
	}

	@Test
	public void gain() throws Exception {
		player.gain("한 평의 밀림");
		assertFalse(player.getCards());
	}

	@Test(expected = IllegalCardException.class)
	public void gain_faild() throws Exception {
		player.gain("한 평의 해안");
		assertFalse(player.getCards());
	}

	@Test
	public void spell() throws Exception {
		player.gain("한 평의 밀림");
		player.gain("방벽");
		player.gain("절도");
		cards = player.book();
		verifySpell(Card.create("절도"), player.spell("절도"));
	}

	@Test(expected = IllegalCardException.class)
	public void spell_failed() throws Exception {
		player.gain("한 평의 밀림");
		player.gain("방벽");
		player.gain("절도");
		cards = player.book();
		verifySpell(Card.create("절도"), player.spell("바보"));
	}

	private void verifySpell(Card gameSpell, Card userSpell) {
		assertEquals(gameSpell, userSpell);
	}
}
