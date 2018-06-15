package card.game.player;

import java.util.ArrayList;
import java.util.List;

import card.game.card.Card;
import card.game.exception.IllegalCardException;
import card.game.manager.ManagerCard;

public class Player {
	private String name;
	private List<Card> appointedCards = new ArrayList<>();
	private List<Card> freeCards = new ArrayList<>();

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
		ManagerCard.add(card);
		add(card);
	}

	private void add(Card card) {
		if (card.isAppointed()) {
			appointedCards.add(card);
			return;
		}
		freeCards.add(card);
	}

	public boolean getCards() {
		return appointedCards.isEmpty();
	}

	public List<Card> book() {
		return appointedCards;
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

	public Card spell(String name) {
		for (Card card : appointedCards) {
			if (card.isVaildSpell(name)) {
				return card;
			}
		}
		throw new IllegalCardException(name + " 카드가 존재하지 않습니다.");
	}
}
