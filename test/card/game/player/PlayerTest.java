package card.game.player;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import card.game.card.Card;
import card.game.exception.IllegalCardException;
import card.game.exception.InvalidPlayerException;

public class PlayerTest {
	private Player player;
	private List<Card> cards;

	@Before
	public void setup() {
		player = new Player(Type.PLAYER);
	}

	@Test
	public void create() {
		verifyUser(Player.create(Type.PLAYER));
	}

	@Test(expected = InvalidPlayerException.class)
	public void createNPC() {
		verifyUser(Player.create(Type.NPC));
	}

	@Test(expected = InvalidPlayerException.class)
	public void createMonster() {
		verifyUser(Player.create(Type.MONSTER));
	}

	private void verifyUser(Player player) {
		assertEquals(player, this.player);
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
