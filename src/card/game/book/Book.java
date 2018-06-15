package card.game.book;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import card.game.card.Card;
import card.game.player.Player;

public class Book {
	private static final Logger log = LoggerFactory.getLogger(Player.class);

	private List<Card> cards = new ArrayList<>();
	private List<Card> appointCards = new ArrayList<>();
	private List<Card> freeCards = new ArrayList<>();

	public Book() {
		initialize();
	}

	public void initialize() {
		appointCardsInitialize();
		freeCardsInitialize();
		mergeCards();
	}

	private void mergeCards() {
		cards.addAll(appointCards);
		cards.addAll(100, freeCards);
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
		return cards.size();
	}

	public void add(Card card) {
		log.debug("book" + card);
		if (card.isAppointed()) {
			addAppointedCard(card);
			return;
		}
		addFreeCards(card);
	}

	private boolean addFreeCards(Card card) {
		return freeCards.add(card);
	}

	private void addAppointedCard(Card card) {
		card.add(appointCards);
	}

	public List<Card> book() {
		return cards;
	}

	public boolean isEmpty() {
		return appointCards.isEmpty() || freeCards.isEmpty();
	}
}
