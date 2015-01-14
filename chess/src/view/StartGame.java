package view;


import control.ControlGame;

public final class StartGame {
	
	private StartGame() {
		
	}

	public static void main(String[] args) {
		ControlGame controlGame = new ControlGame();
		Thread t1 = new Thread(new Tui(controlGame));
		Thread t2 = new Thread(new Gui(controlGame));
		t1.start();
		t2.start();
		controlGame.start();
	}

}
