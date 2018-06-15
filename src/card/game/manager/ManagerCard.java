package card.game.manager;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import card.game.card.Card;
import card.game.exception.IllegalCardException;

public class ManagerCard {
	private static final Logger log = LoggerFactory.getLogger(ManagerCard.class);
	private List<Card> cards = new ArrayList<>();

	public void add(Card card) {
		if (isMaxCount(card)) {
			throw new IllegalCardException(card.getName() + "의 카드화 한도 매수가 초과했습니다.");
		}
		cards.add(card);
	}

	private boolean isMaxCount(Card card) {
		int count = 0;
		log.debug("" + cards.size());
		for (Card index : cards) {
			if (index.isCardNumber(card)) {
				count++;
			}
			if (count >= card.getMaxCount()) {
				return true;
			}
		}
		return false;
	}

}
