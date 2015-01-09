package control;

import java.util.List;

import model.IFigure;
import model.King;
import model.Pawn;
import model.Player;

public class ControlColidateKing {
	
	private ColidatingFields coli = new ColidatingFields();
	private List<IFigure> figureList;
	private List<List<Integer[]>> possibleFields;
	private List<List<Integer[]>> possibleFields2;
	private boolean blocked = false;
	private int c;
	
	public int getC() {
		return c;
	}

	public void setC(int counterFields) {
		this.c = counterFields;
	}

	public List<List<Integer[]>> getPossibleFields2() {
		return possibleFields2;
	}

	public void setPossibleFields2(List<List<Integer[]>> possibleFields) {
		this.possibleFields2 = possibleFields;
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
	public List<IFigure> getFigureList() {
		return figureList;
	}

	public void setFigureList(List<IFigure> figureList) {
		this.figureList = figureList;
	}
	
	public List<List<Integer[]>> getPossibleFields() {
		return possibleFields;
	}

	public void setPossibleFields(List<List<Integer[]>> possibleFields) {
		this.possibleFields = possibleFields;
	}
	
	public void colidateOwnFigureKing(IFigure f, Player p) {
		setFigureList(p.getFigureList());
		getColi().setFigureList(getFigureList());
		getColi().unmovedFigures(f);
		setPossibleFields(f.getPosFields());
		checkColidateOwn();
		f.setPosFields(getPossibleFields());
	}
	private void checkColidateOwn() {
		for(int i = 0; i < getPossibleFields().size(); i++) {
			checkFieldsOwn(i);
		}
	}

	private void checkFieldsOwn(int i) {
		for(setC(0); getC() < getPossibleFields().get(i).size(); setC(getC() + 1)) {
			checkForNullOwn(i, getC());
		}
	}

	private void checkForNullOwn(int i, int j) {
		if(getPossibleFields().get(i).get(j) != null) {
			checkColidateOwnFigureKing(i , j);
		} else {
			getPossibleFields().get(i).remove(j);
			setC(getC() - 1);
		}
	}
	
	private void checkColidateOwnFigureKing(int i, int j) {
		if(getColi().colidate(getPossibleFields().get(i).get(j))) {
			getPossibleFields().get(i).remove(j);
			setC(getC() - 1);
		}
	}
	
	public void colidateOtherFigureKing(IFigure f, Player p) {
		setFigureList(p.getFigureList());
		getColi().setFigureList(getFigureList());
		setPossibleFields(f.getPosFields());
		checkColidateOther(p);
		f.setPosFields(getPossibleFields());
	}
	private void checkColidateOther(Player p) {
		for(int a = 0; a < getPossibleFields().size(); a++) {
			checkFieldsOther(p, a);
		}
	}

	private void checkFieldsOther(Player p, int a) {
		for(setC(0); getC() < getPossibleFields().get(a).size(); setC(getC() + 1)){
			blockedField(p,a,getC());
		}
	}

	private void blockedField(Player p, int a, int t) {
		setBlocked(false);
		isFieldBlocked(p,getPossibleFields().get(a).get(t)[0], getPossibleFields().get(a).get(t)[1]);
		if(isBlocked()) {
			getPossibleFields().get(a).remove(getC());
			setC(getC() - 1);
		}
	}
	
	private void isFieldBlocked(Player p, int y, int x) {
		for(int i = 0; i < p.getFigureList().size(); i++) {
			IFigure f = p.getFigureList().get(i);
			checkForKing(y,x,f);
		}
	}

	private void checkForKing(int y, int x, IFigure f) {
		if(f instanceof King) {
			checkFigureType(y, x, f);
		} else {
			f.possibleFields();
			checkFigureType(y, x, f);
		}
		
	}

	private void checkFigureType(int y, int x, IFigure f) {
		if(f instanceof Pawn) {
			isFieldBlockedByPawn(f,y,x);
		} else {
			setPossibleFields2(f.getPosFields());
			isAPossibleField(y,x);
		}
	}
	
	private void isFieldBlockedByPawn(IFigure f, int y, int x) {
		setPossibleFields2(f.getPosFields());
		for(int i = 0; i < getPossibleFields2().get(1).size(); i++) {
			checkBlock(getPossibleFields2().get(1).get(i),y, x);
		}
	}

	private void isAPossibleField(int y, int x) {
		for(int i = 0; i < getPossibleFields2().size(); i++) {
			getFieldForCheckBlock(y, x, i);
		}
	}

	private void getFieldForCheckBlock(int y, int x, int i) {
		for(int b = 0; b < getPossibleFields2().get(i).size(); b++) {
			checkBlock(getPossibleFields2().get(i).get(b), y, x);
		}
	}
	
	private void checkBlock(Integer[] pf, int y, int x) {
		if(pf != null && pf[0] == y && pf[1] == x) {
			setBlocked(true);
		}
	}
}
