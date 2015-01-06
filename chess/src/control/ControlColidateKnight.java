package control;

import java.util.List;

import model.IFigure;
import model.Player;

public class ControlColidateKnight {
	
	private ColidatingFields coli = new ColidatingFields();
	private List<List<Integer[]>> fields;
	private List<IFigure> figureList;
	private int c;
	
	public int getC() {
		return c;
	}

	public void setC(int counter) {
		this.c = counter;
	}

	public List<List<Integer[]>> getFields() {
		return fields;
	}

	public void setFields(List<List<Integer[]>> fields) {
		this.fields = fields;
	}

	public List<IFigure> getFigureList() {
		return figureList;
	}

	public void setFigureList(List<IFigure> figureList) {
		this.figureList = figureList;
	}

	public ColidatingFields getColi() {
		return coli;
	}

	public void colidateOwnFigureKnight(IFigure f, Player p) {
		setFigureList(p.getFigureList());
		getColi().setFigureList(getFigureList());
		getColi().unmovedFigures(f);
		setFields(f.getPosFields());
		checkColidateField();
		f.setPosFields(getFields());
	}

	private void checkColidateField() {
		for(int i = 0; i < getFields().size(); i++) {
			checkEntriesForColidate(i);
		}
		
	}

	private void checkEntriesForColidate(int i) {
		for(setC(0); getC() < getFields().get(i).size(); setC(getC() + 1)) {
			checkColidateKnight(i);
		}
	}

	private void checkColidateKnight(int i) {
		Integer[] field = getFields().get(i).get(getC());
		if(getColi().colidate(field)) {
			getFields().get(i).remove(getC());
			setC(getC() - 1);
		}
	}
	

}
