package card.game.player;

import card.game.exception.InvalidPlayerException;

public class Player {
	private Type type;
	private String name;

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

}
