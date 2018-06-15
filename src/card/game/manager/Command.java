package card.game.manager;

public enum Command {
	BOOK;

	public static boolean check(String command) {
		return command.equals(valueOf(command));
	}

}
