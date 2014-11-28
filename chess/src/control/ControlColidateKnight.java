package control;

import java.util.List;

import model.Figure;
import model.Player;

public class ControlColidateKnight {
	
	private ColidatingFields coli = new ColidatingFields();
	private List<Integer[]> fields;
	private List<Figure> figureList;
	
	public List<Integer[]> getFields() {
		return fields;
	}

	public void setFields(List<Integer[]> fields) {
		this.fields = fields;
	}

	public List<Figure> getFigureList() {
		return figureList;
	}

	public void setFigureList(List<Figure> figureList) {
		this.figureList = figureList;
	}

	public ColidatingFields getColi() {
		return coli;
	}

	public List<Integer[]> colidateOwnFigureKnight(Figure f, List<Integer[]> pf, Player p) {
		setFigureList(p.getFigureList());
		getColi().setFigureList(getFigureList());
		getColi().unmovedFigures(f);
		setFigureList(getColi().getFigureList());
		setFields(pf);
		checkColidateOwn();
		return getFields();
	}
	
	private void checkColidateOwn() {
		for(int i = 0; i < getFields().size(); i++) {
			checkColidateOwnFigureKnight(i);
		}
	}
	
	private void checkColidateOwnFigureKnight(int i) {
		if(getColi().colidate(getFields().get(i))) {
			getFields().remove(i);
		}
	}

}
