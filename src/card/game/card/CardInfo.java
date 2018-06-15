package card.game.card;

import card.game.exception.IllegalCardException;

public enum CardInfo {
	ONE(1, "한 평의 밀림", Rank.SS, 3, "test", true), ONETHOUSAND_THREE(1003, "방벽", Rank.G, 400, "test",
			false), ONETHOUSAND_SEVEN(1007, "절도", Rank.C, 50, "test", false);

	private int no;
	private String name;
	private Rank rank;
	private int maxCount;
	private String discription;
	private boolean appointed;

	private CardInfo(int no, String name, Rank rank, int maxCount, String discription, boolean appointed) {
		this.no = no;
		this.name = name;
		this.rank = rank;
		this.maxCount = maxCount;
		this.discription = discription;
		this.appointed = appointed;
	}

	public static CardInfo findCard(int no) {
		CardInfo[] cards = values();
		for (CardInfo index : cards) {
			if (index.no == no) {
				return index;
			}
		}
		throw new IllegalCardException(no + "번 카드는 존재하지 않습니다.");
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

	public boolean getAppointed() {
		return appointed;
	}

	public static CardInfo findCard(String cardName) {
		CardInfo[] cards = values();
		for (CardInfo card : cards) {
			if (card.name.equals(cardName)) {
				return card;
			}
		}
		throw new IllegalCardException(cardName + " 카드는 존재하지 않습니다.");
	}
}
