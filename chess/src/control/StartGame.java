package control;


import view.Gui;
import view.Tui;

public final class StartGame {
	
	private StartGame() {
		
	}

	public static void main(String[] args) {
		ControlGame controlGame = new ControlGame();
		Thread t1 = new Thread(new Tui(controlGame));
		t1.start();
//		Tui tui = new Tui(controlGame);
//		//Gui gui = new Gui(controlGame);
//		tui.run();
		controlGame.start();
	}

}
