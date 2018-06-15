package card.game.card;

public class Card {
	private int no;
	private String name;
	private Rank rank;
	private int maxCount;
	private String discription;
	private boolean appointed;

	public Card(int no, String name, Rank rank, int max_count, String discription) {
		this.no = no;
		this.name = name;
		this.rank = rank;
		this.maxCount = max_count;
		this.discription = discription;
	}

	public Card(CardInfo cardInfo) {
		this.no = cardInfo.getNo();
		this.name = cardInfo.getName();
		this.rank = cardInfo.getRank();
		this.maxCount = cardInfo.getMaxCount();
		this.discription = cardInfo.getDiscription();
		this.appointed = cardInfo.getAppointed();
	}

	public static Card create(int no) {
		return new Card(CardInfo.findCard(no));
	}

	public String getName() {
		return name;
	}

	public int getMaxCount() {
		return maxCount;
	}

	public boolean isCardNumber(Card card) {
		return this.no == card.no;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (appointed ? 1231 : 1237);
		result = prime * result + ((discription == null) ? 0 : discription.hashCode());
		result = prime * result + maxCount;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + no;
		result = prime * result + ((rank == null) ? 0 : rank.hashCode());
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
		if (appointed != other.appointed)
			return false;
		if (discription == null) {
			if (other.discription != null)
				return false;
		} else if (!discription.equals(other.discription))
			return false;
		if (maxCount != other.maxCount)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (no != other.no)
			return false;
		if (rank != other.rank)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Card [no=" + no + ", name=" + name + ", rank=" + rank + ", maxCount=" + maxCount + ", discription="
				+ discription + ", appointed=" + appointed + "]";
	}

}
