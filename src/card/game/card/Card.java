package card.game.card;

import java.util.List;

public class Card {
	private CardList card;

	public Card(CardList cardInfo) {
		this.card = cardInfo;
	}

	public Card() {
	}

	public static Card create() {
		return new Card();
	}

	public static Card create(int no) {
		return new Card(CardList.findCard(no));
	}

	public static Card create(String cardName) {
		return new Card(CardList.findCard(cardName));
	}

	public void add(List<Card> appointCards) {
		appointCards.set(card.getNo(), this);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((card == null) ? 0 : card.hashCode());
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
		Card other = (Card) obj;
		if (card != other.card)
			return false;
		return true;
	}

	public String getName() {
		return card.getName();
	}

	public boolean isCardNumber(Card card) {
		return this.card.getNo() == card.card.getNo();
	}

	public int getMaxCount() {
		return card.getMaxCount();
	}

	public boolean isAppointed() {
		return card.getAppointed();
	}
}
