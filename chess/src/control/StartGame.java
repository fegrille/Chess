package control;

import view.Gui;
import view.Tui;

public class StartGame {

	public static void main(String[] args) {
		Tui tui = new Tui();
		Gui gui = new Gui();
		
		tui.start();
		gui.start();
	}

}
