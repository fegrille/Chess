package control;

import java.util.ArrayList;
import java.util.List;

import model.Field;
import model.Figure;
import model.IFigure;
import model.Player;


public class ControlGame implements Subject {

	private ArrayList<Observer> observers;
	private ControlEndGame controlEG;
	private Player currentPlayer;
	private Player playerOpponent;
	private boolean turnFin;


	public ControlGame() {
		observers = new ArrayList<Observer>();
		controlEG = new ControlEndGame();
	}
	
	@Override
	public void register(Observer newObserver) {
		observers.add(newObserver);
		
	}

	@Override
	public void unregister(Observer deleteObserver) {
		observers.remove(deleteObserver);
		
	}

	@Override
	public void notifyObserver() {
		for(Observer observer : observers) {
			observer.update(getCurrentPlayer(), getPlayerOpponent());
		}
		
	}
	
	public void start() {
		gameHandling();
	}

	
	private void gameHandling() {
		Field field = new Field();
		Player p1 = new Player('w', field);
		Player p2 = new Player('b', field);
		setCurrentPlayer(p1);
		setPlayerOpponent(p2);
		while(!getControlEG().getWin()) {
			notifyObserver();
			while(!isTurnFin()) {
				continue;
			}
			setTurnFin(false);
			if(getCurrentPlayer().equals(p1)){
				setCurrentPlayer(p2);
				setPlayerOpponent(p1);
			} else {
				setCurrentPlayer(p1);
				setPlayerOpponent(p2);
			}
		}
	}
	
	public void figureChosen(Player currentPl, Player otherPlayer, Figure chosenFig, int[] newField) {
		for(IFigure f : currentPl.getFigureList()) {
			if(f.equals(chosenFig)) {
				moveFigure(currentPl, otherPlayer, chosenFig, newField);
				break;
			}
		}
	}
	
	private void moveFigure(Player currentPl, Player otherPlayer, IFigure chosenFig, int[] newField) {
		for(IFigure f : otherPlayer.getFigureList()) {
			if(f.getField().equals(newField)) {
				otherPlayer.getFigureList().remove(f);
				break;
			}
		}
		for(IFigure f : currentPl.getFigureList()) {
			if(f.equals(chosenFig)) {
				f.setField(newField[0], newField[1]);
			}
		}
	}
	
	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	public void setCurrentPlayer(Player currentPlayer) {
		this.currentPlayer = currentPlayer;
	}

	public Player getPlayerOpponent() {
		return playerOpponent;
	}

	public void setPlayerOpponent(Player playerOpponent) {
		this.playerOpponent = playerOpponent;
	}

	public boolean isTurnFin() {
		return turnFin;
	}

	public void setTurnFin(boolean turnFin) {
		this.turnFin = turnFin;
	}
	
	public ControlEndGame getControlEG() {
		return controlEG;
	}

	public void setControlEG(ControlEndGame controlEG) {
		this.controlEG = controlEG;
	}
	// Evtl Extra klasse mit den Daten, von denen sich TUI und Gui Daten holen und die an Subject schicken
}
