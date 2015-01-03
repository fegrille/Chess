package control;

import java.util.List;

import model.IFigure;
import model.Player;

public class ControlColidatePawn {
	
	private ColidatingFields coli = new ColidatingFields();
	private List<List<Integer[]>> fields;
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

	public List<List<Integer[]>> getFields() {
		return fields;
	}
	
	public void setFields(List<List<Integer[]>> fields) {
		this.fields = fields;
	}
	
	public void colidateOtherFigurePawn(IFigure f, Player p2) {
		getColi().colidateInFrontPawn(f,p2);
	}

	public void colidateOwnFigurePawn(IFigure f, Player p) {
		setFigureList(p.getFigureList());
		setFigureList(getColi().getFigureList());
		setFields(f.getPosFields());
		getColi().colidateInFrontPawn(f,p);
		colidateSideFields();
		f.setPosFields(getColi().getFields());
	}

	private void colidateSideFields() {
		for(int i = 0; i < getFields().get(1).size(); i++) {
			if(getColi().colidate(getFields().get(1).get(i))) {
				getColi().getFields().get(1).remove(i);
			}
		}
	}

}
