package card.game.player;

import java.util.ArrayList;
import java.util.List;

import card.game.card.Card;
import card.game.exception.IllegalCardException;
import card.game.exception.InvalidPlayerException;
import card.game.manager.ManagerCard;

public class Player {
	private Type type;
	private String name;
	private List<Card> cards = new ArrayList<>();

	public Player() {
	}

	public Player(Type type) {
		this.type = type;
	}

	public Player(Type type, String name) {
		this.type = type;
		this.name = name;
	}

	public static Player create(Type type) {
		if (type != Type.PLAYER) {
			throw new InvalidPlayerException("플레이어만 생성할 수 있습니다.");
		}
		return new Player(type);
	}

	public static Player create(Type type, String name) {
		return new Player(type, name);
	}

	public void gain(String cardName) {
		Card card = Card.create(cardName);
		ManagerCard.add(card);
		cards.add(card);
	}

	public boolean getCards() {
		return cards.isEmpty();
	}

	public List<Card> book() {
		return cards;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		if (type != other.type)
			return false;
		return true;
	}

	public Card spell(String name) {
		for (Card card : cards) {
			if (card.isVaildSpell(name)) {
				return card;
			}
		}
		throw new IllegalCardException(name + " 카드가 존재하지 않습니다.");
	}
}
