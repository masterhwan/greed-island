package card.game.player;

public enum Type {
	PLAYER('p'), NPC('n'), MONSTER('m');

	private char represetation;

	private Type(char representation) {
		this.represetation = representation;
	}
}
