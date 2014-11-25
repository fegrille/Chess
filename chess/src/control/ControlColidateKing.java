package control;

import java.util.List;

import model.Figure;
import model.Player;

public class ControlColidateKing {
	
	private ColidatingFields coli = new ColidatingFields();
	private List<Figure> figureList;
	private List<Integer[]> possibleFields;
	private boolean blocked = false;
	
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
		getColi().unmovedFigures(f);
		setPossibleFields(pf);
		checkColidateOwn();
		return getPossibleFields();
	}
	private void checkColidateOwn() {
		for(int i = 0; i < getPossibleFields().size(); i++) {
			checkColidateOwnFigureKing(i);
		}
	}
	
	private void checkColidateOwnFigureKing(int i) {
		if(getColi().colidate(getPossibleFields().get(i))) {
			getPossibleFields().remove(i);
		}
	}
	
	public List<Integer[]> colidateOtherFigureKing(Figure f, List<Integer[]> pf, Player p) {
		setFigureList(p.getFigureList());
		getColi().unmovedFigures(f);
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
			isAPossibleField(f.possibleFields(),y,x);
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
