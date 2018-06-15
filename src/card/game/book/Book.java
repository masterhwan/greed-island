package card.game.book;

import java.util.ArrayList;
import java.util.List;

import card.game.card.Card;

public class Book {

	private List<Card> appointCards = new ArrayList<>();
	private List<Card> freeCards = new ArrayList<>();

	public void initialize() {
		appointCardsInitialize();
		freeCardsInitialize();
	}

	private void appointCardsInitialize() {
		for (int i = 0; i < 100; i++) {
			appointCards.add(Card.create());
		}
	}

	private void freeCardsInitialize() {
		for (int i = 0; i < 45; i++) {
			freeCards.add(Card.create());
		}
	}

	public int getAppointCardsSize() {
		return appointCards.size();
	}

	public int freeCardsSize() {
		return freeCards.size();
	}

	public int bookSize() {
		appointCards.addAll(100, freeCards);
		return appointCards.size();
	}

}
