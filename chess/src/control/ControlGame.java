package control;

import java.util.ArrayList;
import java.util.List;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

import model.Field;
import model.IFigure;
import model.Pawn;
import model.Player;
import model.Queen;


public class ControlGame implements Subject {
	
	private Injector inj = Guice.createInjector(new ControlModule());
	private List<Observer> observers;
	private ControlEndGame controlEG;
	private Player currentPlayer;
	private Player playerOpponent;
	private List<IFigure> possiFigures;
	private List<Integer[]> possiFields;
	private char task = ' ';
	private String choise = "";
	private IFigure chosenFigure;
	private Integer[] chosenField;
	private ControlColidate col;
	private ControlPawn conPa;

	@Inject
	public ControlGame() {
		observers = new ArrayList<Observer>();
		controlEG = inj.getInstance(ControlEndGame.class);
		col = new ControlColidate();
		chosenFigure = null;
		chosenField = null;
		possiFigures = null;
		possiFields = null;
		conPa = inj.getInstance(ControlPawn.class);
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
			observer.update(getPossiFigures(), getPossiFields(), getTask(), getCurrentPlayer().getFigureList(), getPlayerOpponent().getFigureList());
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
			setTask('f');
			setPossiFigures(getCurrentPlayer().getFigureList());
			notifyObserver();
			while(!checkFigureChoise(getChoise())) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			setChosenFigure(Integer.parseInt(getChoise()));
			setPossiFields(getChosenFigure());
			setChoise("");
			setTask('s');
			notifyObserver();
			while(!checkFieldChoise(getChoise())) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			if(Integer.parseInt(getChoise()) == -1) {
				continue;
			}
			setChosenField(Integer.parseInt(getChoise()));
			setChoise("");
			moveFigure(getCurrentPlayer(), getPlayerOpponent(), getChosenFigure(), getChosenField());
			if(getCurrentPlayer().equals(p1)) {
				setCurrentPlayer(p2);
				setPlayerOpponent(p1);
			} else {
				setCurrentPlayer(p1);
				setPlayerOpponent(p2);
			}
			getControlEG().controlWin(getCurrentPlayer(), getPlayerOpponent(), col, getChosenFigure());
		}
		setTask('w');
		notifyObserver();
	}
	
	private void moveFigure(Player currentPl, Player otherPlayer, IFigure chosenFig, Integer[] newField) {
		for(IFigure f : otherPlayer.getFigureList()) {
			if(f.getField()[0] == newField[0] && f.getField()[1] == newField[1]) {
				otherPlayer.getFigureList().remove(f);
				break;
			}
		}
		
		for(int i = 0; i < currentPl.getFigureList().size(); i++) {
			IFigure f = currentPl.getFigureList().get(i);
			if(f.equals(chosenFig)) {
				if(f instanceof Pawn) {
					((Pawn)f).setFirstMove(false);
				}
				f.setField(newField[0], newField[1]);
				if(conPa.checkEndfield(f) && f instanceof Pawn) {
					currentPl.getFigureList().set(i, new Queen(f.getY(), f.getX(), f.getColor()));
				}
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
		if(value >= 0 && value < getPossiFields().size() || value == -1) {
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

	public char getTask() {
		return task;
	}

	public void setTask(char task) {
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
		col.colidate(getCurrentPlayer(), getPlayerOpponent());
		for(List<Integer[]> l : f.getPosFields()) {
			if(l.size() != 0) {
				return true;
			}
		}
		return false;
	}

	public List<Integer[]> getPossiFields() {
		return this.possiFields;
	}

	public void setPossiFields(IFigure fig) {
		List<Integer[]> tmpList = new ArrayList<Integer[]>();
		fig.possibleFields();
		col.colidate(getCurrentPlayer(), getPlayerOpponent());
		for(List<Integer[]> list : fig.getPosFields()) {
			for(Integer[] i : list) {
				tmpList.add(i);
			}
		}
		this.possiFields = tmpList;
	}
}
