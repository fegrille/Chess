package view;


import control.ControlGame;

public final class StartGame {
	
	private StartGame() {
		
	}

	public static void main(String[] args) {
		ControlGame controlGame = new ControlGame();
		Thread t1 = new Thread(new Tui(controlGame));
		// Set up logging through log4j
		t1.start();
//		Tui tui = new Tui(controlGame);
//		//Gui gui = new Gui(controlGame);
//		tui.run();
		controlGame.start();
	}

}
