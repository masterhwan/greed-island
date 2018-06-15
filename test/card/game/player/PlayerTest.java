package card.game.player;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import card.game.exception.InvalidPlayerException;

public class PlayerTest {
	private static final Logger log = LoggerFactory.getLogger(PlayerTest.class);

	private Player player;

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
}
