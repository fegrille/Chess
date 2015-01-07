package control;


import view.Gui;
import view.Tui;

public final class StartGame {
	
	private StartGame() {
		
	}

	public static void main(String[] args) {
		ControlGame controlGame = new ControlGame();
		Tui tui = new Tui(controlGame);
		//Gui gui = new Gui(controlGame);
		controlGame.start();
	}

}
