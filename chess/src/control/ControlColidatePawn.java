package control;

import java.util.List;

import model.IFigure;
import model.Player;

public class ControlColidatePawn {
	
	private ColidatingFields coli = new ColidatingFields();
	private List<Integer[]> fields;
	private List<IFigure> figureList;
	private int c1;
	
	public int getC1() {
		return c1;
	}

	public void setC1(int c1) {
		this.c1 = c1;
	}

	public ColidatingFields getColi() {
		return coli;
	}

	public void setColi(ColidatingFields coli) {
		this.coli = coli;
	}
	public List<IFigure> getFigureList() {
		return figureList;
	}

	public void setFigureList(List<IFigure> figureList) {
		this.figureList = figureList;
	}

	public List<Integer[]> getFields() {
		return fields;
	}
	
	public void setFields(List<Integer[]> fields) {
		this.fields = fields;
	}
	
	public void colidateOwnFigurePawn(IFigure f, Player p, Player p2) {
		setFigureList(p.getFigureList());
		getColi().setFigureList(getFigureList());
		getColi().unmovedFigures(f);
		setFigureList(getColi().getFigureList());
		setFields(f.getPosFields());
		checkColidationOwn(f);
		f.setPosFields(getFields());
	}
	
	private void checkColidationOwn(IFigure f) {
		for(setC1(0); getC1() < getFields().size(); setC1(getC1() + 1)) {
			checkColidatePawn(f);
		}
	}
	
	private void checkColidatePawn(IFigure f) {
		if(getColi().colidate(getFields().get(getC1()))) {
			isBlack(f.getColor());
			isWhite(f.getColor());
		}
	}

	private void isWhite(char color) {
		if(color == 'w') {
			coli.removeUp(getC1());
		}
		
	}

	private void isBlack(char color) {
		if(color == 'b') {
			coli.removeDown(getC1());
		}
		
	}

}
