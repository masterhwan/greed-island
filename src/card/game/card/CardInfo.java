package card.game.card;

import card.game.exception.IllegaCardInfoException;

public enum CardInfo {
	ONE(1, "safari of room", Rank.SS, 3, "test");

	private int no;
	private String name;
	private Rank rank;
	private int maxCount;
	private String discription;

	private CardInfo(int no, String name, Rank rank, int maxCount, String discription) {
		this.no = no;
		this.name = name;
		this.rank = rank;
		this.maxCount = maxCount;
		this.discription = discription;
	}

	public static CardInfo findCard(int no) {
		CardInfo[] cards = values();
		for (CardInfo index : cards) {
			if (index.no == no) {
				return index;
			}
		}
		throw new IllegaCardInfoException("존재하지 않는 카드 입니다.");
	}

	public String getName() {
		return this.name;
	}

	public Rank getRank() {
		return this.rank;
	}

	public int getMaxCount() {
		return maxCount;
	}

	public String getDiscription() {
		return discription;
	}

	public int getNo() {
		return no;
	}
}
