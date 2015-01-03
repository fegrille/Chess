package control;

import java.util.List;

import model.IFigure;
import model.Player;

public class ControlColidateKnight {
	
	private ColidatingFields coli = new ColidatingFields();
	private List<List<Integer[]>> fields;
	private List<IFigure> figureList;
	private int counter;
	
	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
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
		setFigureList(getColi().getFigureList());
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
		for(int j = 0; i < getFields().get(i).size(); i++) {
			checkColidateKnight(i, j);
		}
	}

	private void checkColidateKnight(int i, int j) {
		if(getColi().colidate(getFields().get(i).get(j))) {
			getFields().get(i).remove(j);
		}
	}
	

}
