package control;

import java.util.List;

import model.Figure;
import model.Pawn;
import model.Player;

public class ControlColidateKing {
	
	private ColidatingFields coli = new ColidatingFields();
	private List<Figure> figureList;
	private List<Integer[]> possibleFields;
	private List<Integer[]> possibleFields2;
	private boolean blocked = false;
	private int counter;
	private int counterFields;
	
	public int getCounterFields() {
		return counterFields;
	}

	public void setCounterFields(int counterFields) {
		this.counterFields = counterFields;
	}

	public List<Integer[]> getPossibleFields2() {
		return possibleFields2;
	}

	public void setPossibleFields2(List<Integer[]> possibleFields) {
		this.possibleFields2 = possibleFields;
	}
	
	public int getCounter() {
		return counter;
	}
	
	public void setCounter(int counter) {
		this.counter = counter;
	}
	
	public boolean isBlocked() {
		return blocked;
	}
	public void setBlocked(boolean blocked) {
		this.blocked = blocked;
	}
	public ColidatingFields getColi() {
		return coli;
	}
	public List<Figure> getFigureList() {
		return figureList;
	}

	public void setFigureList(List<Figure> figureList) {
		this.figureList = figureList;
	}
	
	public List<Integer[]> getPossibleFields() {
		return possibleFields;
	}

	public void setPossibleFields(List<Integer[]> possibleFields) {
		this.possibleFields = possibleFields;
	}
	
	public List<Integer[]> colidateOwnFigureKing(Figure f, Player p) {
		setFigureList(p.getFigureList());
		getColi().setFigureList(getFigureList());
		getColi().unmovedFigures(f);
		setFigureList(getColi().getFigureList());
		setPossibleFields(f.getPosFields());
		checkColidateOwn();
		return getPossibleFields();
	}
	private void checkColidateOwn() {
		for(setCounter(0); getCounter() < getPossibleFields().size(); setCounter(getCounter() + 1)) {
			checkColidateOwnFigureKing(getCounter());
		}
	}
	
	private void checkColidateOwnFigureKing(int i) {
		if(getColi().colidate(getPossibleFields().get(i))) {
			getPossibleFields().remove(i);
			setCounter(getCounter() - 1);
		}
	}
	
	public List<Integer[]> colidateOtherFigureKing(Figure f, List<Integer[]> pf, Player p) {
		setFigureList(p.getFigureList());
		getColi().setFigureList(getFigureList());
		setPossibleFields(pf);
		checkColidateOther(p);
		return getPossibleFields();
	}
	private void checkColidateOther(Player p) {
		for(setCounterFields(0); getCounterFields() < getPossibleFields().size(); setCounterFields(getCounterFields() + 1)) {
			checkColidateOtherFigureKing(p);
		}
	}
	
	private void checkColidateOtherFigureKing(Player p) {
		if(getColi().colidate(getPossibleFields().get(getCounterFields()))) {
			blockedField(p);
		}
		
	}

	private void blockedField(Player p) {
		setBlocked(false);
		isFieldBlocked(p,getPossibleFields().get(getCounterFields())[0], getPossibleFields().get(getCounterFields())[1]);
		if(isBlocked()) {
			getPossibleFields().remove(getCounterFields());
			setCounterFields(getCounterFields() - 1);
		}
	}
	
	private void isFieldBlocked(Player p, int y, int x) {
		for(Figure f : p.getFigureList()) {
			if(f instanceof Pawn) {
				isFieldBlockedByPawn(f,y,x);
			} else {
				isAPossibleField(f.getPosFields(),y,x);
			}
		}
	}
	
	private void isFieldBlockedByPawn(Figure f, int y,
			int x) {
		setPossibleFields2(f.getPosFields());
		for(setCounter(0); getCounter() < getPossibleFields2().size(); setCounter(getCounter() + 1)) {
			Integer[] field = getPossibleFields2().get(getCounter());
			removeFieldsBlack(f,field);
			removeFieldsWhite(f,field);
		}
		isAPossibleField(getPossibleFields2(),y,x);
	}

	private void removeFieldsWhite(Figure f, Integer[] field) {
		isPFInFrontOfPawnWhite(f, field);
		isPfInFrontOfPawnFirstMoveWhite(f, field);
		
	}

	private void isPfInFrontOfPawnFirstMoveWhite(Figure f, Integer[] field) {
		int y = f.getY() + 2;
		if(field[0] == y && field[0] == f.getX()){
			getPossibleFields2().remove(getCounter());
			setCounter(getCounter() - 1);
		}
		
	}

	private void isPFInFrontOfPawnWhite(Figure f, Integer[] field) {
		int y = f.getY() + 1;
		if(field[0] == y && field[0] == f.getX()){
			getPossibleFields2().remove(getCounter());
			setCounter(getCounter() - 1);
		}
		
	}

	private void removeFieldsBlack(Figure f, Integer[] field) {
		isPFInFrontOfPawnBlack(f, field);
		isPfInFrontOfPawnFirstMoveBlack(f, field);
		
	}

	private void isPfInFrontOfPawnFirstMoveBlack(Figure f, Integer[] field) {
		int y = f.getY() - 2;
		if(field[0] == y && field[0] == f.getX()){
			getPossibleFields2().remove(getCounter());
			setCounter(getCounter() - 1);
		}
	}

	private void isPFInFrontOfPawnBlack(Figure f, Integer[] field) {
		int y = f.getY() - 1;
		if(field[0] == y && field[0] == f.getX()){
			getPossibleFields2().remove(getCounter());
			setCounter(getCounter() - 1);
		}
	}

	private void isAPossibleField(List<Integer[]> pf, int y, int x) {
		for(int i = 0; i < pf.size(); i++) {
			checkBlock(pf.get(i), y, x);
		}
	}
	
	private void checkBlock(Integer[] pf, int y, int x) {
		if(pf[0] == y && pf[1] == x) {
			setBlocked(true);
		}
	}
}
