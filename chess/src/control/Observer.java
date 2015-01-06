package control;

import model.Player;

public interface Observer {

	public void update(Player currentPlayer, Player currentOpponent);
}
