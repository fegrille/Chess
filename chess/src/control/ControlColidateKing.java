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
	
	public List<Integer[]> colidateOwnFigureKing(Figure f, List<Integer[]> pf, Player p) {
		setFigureList(p.getFigureList());
		getColi().setFigureList(getFigureList());
		getColi().unmovedFigures(f);
		setFigureList(getColi().getFigureList());
		setPossibleFields(pf);
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
		for(int i = 0; i < getPossibleFields().size(); i++) {
			checkColidateOtherFigureKing(i,p);
		}
	}
	
	private void checkColidateOtherFigureKing(int i, Player p) {
		if(getColi().colidate(getPossibleFields().get(i))) {
			blockedField(i, p);
		}
		
	}

	private void blockedField(int i, Player p) {
		isFieldBlocked(p,getPossibleFields().get(i)[0], getPossibleFields().get(i)[1]);
		if(isBlocked()) {
			getPossibleFields().remove(i);
		}
	}
	
	private void isFieldBlocked(Player p, int y, int x) {
		for(Figure f : p.getFigureList()) {
			if(f instanceof Pawn) {
				isFieldBlockedByPawn(f,y,x);
			}
			isAPossibleField(f.possibleFields(),y,x);
		}
	}
	
	private void isFieldBlockedByPawn(Figure f, int y,
			int x) {
		setPossibleFields2(f.possibleFields());
		for(setCounter(0); getCounter() < getPossibleFields2().size(); setCounter(getCounter() + 1)) {
			Integer[] field = getPossibleFields2().get(getCounter());
			isPFInFrontOfPawn(f, getPossibleFields2(), field);
			isPfInFrontOfPawnFirstMove(f, field);
		}
		isAPossibleField(getPossibleFields2(),y,x);
	}

	private void isPfInFrontOfPawnFirstMove(Figure f, Integer[] field) {
		if(field[0] == f.getY() + 2){
			getPossibleFields2().remove(getCounter());
			setCounter(getCounter() - 1);
		}
	}

	private void isPFInFrontOfPawn(Figure f, List<Integer[]> pf, Integer[] field) {
		if(field[0] == f.getY() + 1){
			getPossibleFields2().remove(getCounter());
			setCounter(getCounter() - 1);
		}
	}

	private void isAPossibleField(List<Integer[]> pf, int y, int x) {
		for(int i = 0; i < pf.size(); i++) {
			checkBlock(pf, y, x, i);
		}
	}
	
	private void checkBlock(List<Integer[]> pf, int y, int x, int i) {
		if(pf.get(i)[0] == y && pf.get(i)[1] == x) {
			setBlocked(true);
		}
	}
}
