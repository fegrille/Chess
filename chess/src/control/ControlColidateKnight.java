package control;

import java.util.List;

import model.IFigure;
import model.Player;

public class ControlColidateKnight {
	
	private ColidatingFields coli = new ColidatingFields();
	private List<Integer[]> fields;
	private List<IFigure> figureList;
	private int counter;
	
	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public List<Integer[]> getFields() {
		return fields;
	}

	public void setFields(List<Integer[]> fields) {
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
		checkColidateOwn();
		f.setPosFields(getFields());
	}
	
	private void checkColidateOwn() {
		for(setCounter(0); getCounter() < getFields().size(); setCounter(getCounter() + 1)) {
			checkColidateOwnFigureKnight();
		}
	}
	
	private void checkColidateOwnFigureKnight() {
		if(getColi().colidate(getFields().get(getCounter()))) {
			getFields().remove(getCounter());
			setCounter(getCounter() - 1);
		}
	}

}
