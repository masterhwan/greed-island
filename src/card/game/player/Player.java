package card.game.player;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import card.game.book.Book;
import card.game.card.Card;
import card.game.manager.ManagerCard;

public class Player {
	private static final Logger log = LoggerFactory.getLogger(Player.class);
	private String name;
	private Book book = new Book();

	public Player() {
	}

	public Player(String name) {
		this.name = name;
	}

	public static Player create() {
		return new Player();
	}

	public static Player create(String name) {
		return new Player(name);
	}

	public void gain(String cardName) {
		Card card = Card.create(cardName);
		log.debug("gain" + card);
		ManagerCard.add(card);
		add(card);
	}

	private void add(Card card) {
		log.debug("add" + card);
		log.debug("book" + book);
		book.add(card);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public boolean haveCards() {
		return book.isEmpty();
	}

	public List<Card> book() {
		return book.book();
	}
}
