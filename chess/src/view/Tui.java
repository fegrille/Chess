package view;

import java.util.Scanner;
import java.util.logging.Logger;

import model.Figure;
import model.Player;
import control.ControlGame;
import control.Observer;
import control.Subject;

public class Tui implements Observer, Runnable {

	private ControlGame controlGame;
	private Player currentPlayer;
	private Player currentOpponent;
	private UIMethods uiMethods;
	
	private String newLine = System.getProperty("line.separator");
	
	private Logger logger = Logger.getLogger("view.tui");
	
	public Tui(ControlGame controlGame) {
		uiMethods = new UIMethods();
		this.controlGame = controlGame;
		controlGame.register(this);
	}
	
	@Override
	public void update(Player currentPlayer, Player currentOpponent) {
		setCurrentPlayer(currentPlayer);
		setCurrentOpponent(currentOpponent);
		printTUI();
	}

	@Override
	public void run() {
		Scanner scan = new Scanner(System.in);
		String s;
		Figure f = null;
		int[] field = null;
		while(true) {
			while(checkFigure(s = scan.next())) {
				continue;
			}
			//setFigure
			uiMethods.selectFigure(s);
			//update Text
			while(checkField(s = scan.next())) {
				continue;
			}
			//setField
			uiMethods.selectField(s);
			controlGame.figureChosen(getCurrentPlayer(), getCurrentOpponent(), f, field);
		}
	}
	
	private boolean checkFigure(String string) {
		// TODO Auto-generated method stub
		return false;
	}
	
	private boolean checkField(String string) {
		// TODO Auto-generated method stub
		return false;
	}

	public void printTUI() {	
		logger.info(newLine + "Please select Figure!");
	}

	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	public void setCurrentPlayer(Player currentPlayer) {
		this.currentPlayer = currentPlayer;
	}

	public Player getCurrentOpponent() {
		return currentOpponent;
	}

	public void setCurrentOpponent(Player currentOpponent) {
		this.currentOpponent = currentOpponent;
	}
	
}
