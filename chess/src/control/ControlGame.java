package control;

import java.util.ArrayList;
import java.util.List;

import model.Field;
import model.IFigure;
import model.Player;


public class ControlGame implements Subject {

	private List<Observer> observers;
	private ControlEndGame controlEG;
	private Player currentPlayer;
	private Player playerOpponent;
	private List<IFigure> possiFigures;
	private List<Integer[]> possiFields;
	private String task = "";
	private String choise = "";
	private IFigure chosenFigure;
	private Integer[] chosenField;
	private ControlColidate col;


	public ControlGame() {
		observers = new ArrayList<Observer>();
		controlEG = new ControlEndGame();
		col = new ControlColidate();
		chosenFigure = null;
		chosenField = null;
		possiFigures = null;
		possiFields = null;
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
			observer.update(getPossiFigures(), getPossiFields(), getTask());
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
			setTask("figure");
			setPossiFigures(getCurrentPlayer().getFigureList());
			notifyObserver();
			while(!checkFigureChoise(getChoise())) {
				continue;
			}
			setChosenFigure(Integer.parseInt(getChoise()));
			setPossiFields(getChosenFigure());
			setChoise("");
			setTask("field");
			notifyObserver();
			while(!checkFieldChoise(getChoise())) {
				continue;
			}
			setChosenField(Integer.parseInt(getChoise()));
			setChoise("");
			moveFigure(getCurrentPlayer(), getPlayerOpponent(), getChosenFigure(), getChosenField());
			if(getCurrentPlayer().equals(p1)){
				setCurrentPlayer(p2);
				setPlayerOpponent(p1);
			} else {
				setCurrentPlayer(p1);
				setPlayerOpponent(p2);
			}
		}
	}
	
	private void moveFigure(Player currentPl, Player otherPlayer, IFigure chosenFig, Integer[] newField) {
		for(IFigure f : otherPlayer.getFigureList()) {
			if(f.getField()[0] == newField[0] && f.getField()[1] == newField[1]) {
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

	private boolean checkFieldChoise(String choise2) {
		int value = 0;
		try {
			value = Integer.parseInt(choise2);
		} catch (Exception e) {
			return false;
		}
		if(value >= 0 && value < getPossiFields().size()) {
			return true;
		}
		return false;
	}

	private boolean checkFigureChoise(String choise2) {
		int value = 0;
		try {
			value = Integer.parseInt(choise2);
		} catch (Exception e) {
			return false;
		}
		if(value >= 0 && value < getPossiFigures().size()) {
			return true;
		}
		return false;
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
	
	public ControlEndGame getControlEG() {
		return controlEG;
	}

	public void setControlEG(ControlEndGame controlEG) {
		this.controlEG = controlEG;
	}

	public String getChoise() {
		return choise;
	}

	public void setChoise(String choise) {
		this.choise = choise;
	}

	public IFigure getChosenFigure() {
		return chosenFigure;
	}

	public void setChosenFigure(int index) {
		this.chosenFigure = getPossiFigures().get(index);
	}
	
	public Integer[] getChosenField() {
		return chosenField;
	}

	public void setChosenField(int index) {
		this.chosenField = getPossiFields().get(index);
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public List<IFigure> getPossiFigures() {
		return this.possiFigures;
	}

	public void setPossiFigures(List<IFigure> possiFigures) {
		ArrayList<IFigure> tmpFigures = new ArrayList<IFigure>();
		for(IFigure f : possiFigures) {
			if(checkFigure(f)) {
				tmpFigures.add(f);
			}
		}
		this.possiFigures = tmpFigures;
	}
	
	private boolean checkFigure(IFigure f) {
		f.possibleFields();
		col.colidate(f, getCurrentPlayer(), getPlayerOpponent());
		if(!f.getPosFields().isEmpty()) {
			return true;
		}
		return false;
	}

	public List<Integer[]> getPossiFields() {
		return this.possiFields;
	}

	public void setPossiFields(IFigure fig) {
		List<Integer[]> tmpList = new ArrayList<Integer[]>();
		fig.possibleFields();
		col.colidate(fig, getCurrentPlayer(), getPlayerOpponent());
		for(List<Integer[]> list : fig.getPosFields()) {
			for(Integer[] i : list) {
				tmpList.add(i);
			}
		}
		this.possiFields = tmpList;
	}
}
