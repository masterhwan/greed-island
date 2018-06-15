package card.game.manager;

public class ManagerPlayer {

	public boolean isCommand(String command) {
		return Command.check(command);
	}

}
