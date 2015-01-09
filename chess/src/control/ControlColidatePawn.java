package control;

import java.util.List;

import model.IFigure;
import model.Player;

public class ControlColidatePawn {
	
	private ColidatingFields coli = new ColidatingFields();
	private List<List<Integer[]>> fields;
	private int c;
	
	public int getC() {
		return c;
	}

	public void setC(int c1) {
		this.c = c1;
	}

	public ColidatingFields getColi() {
		return coli;
	}

	public List<List<Integer[]>> getFields() {
		return fields;
	}
	
	public void setFields(List<List<Integer[]>> fields) {
		this.fields = fields;
	}
	
	public void colidateOtherFigurePawn(IFigure f, Player p2) {
		getColi().colidateInFrontPawn(f,p2);
		checkColiateSideFieldsOther();
	}

	private void checkColiateSideFieldsOther() {
		for(setC(0); getC() < getFields().get(1).size(); setC(getC() + 1)) {
			checkColidationOther();
		}
	}

	private void checkColidationOther() {
		if(!getColi().colidate(getFields().get(1).get(getC()))) {
			getFields().get(1).remove(getC());
			setC(getC() - 1);
		}
		
	}

	public void colidateOwnFigurePawn(IFigure f, Player p) {
		setFields(f.getPosFields());
		getColi().colidateInFrontPawn(f,p);
		colidateSideFieldsOwn();
		f.setPosFields(getColi().getFields());
	}

	private void colidateSideFieldsOwn() {
		for(setC(0); getC() < getFields().get(1).size(); setC(getC() + 1)) {
			checkColidationOwn();
		}
	}

	private void checkColidationOwn() {
		if(getColi().colidate(getFields().get(1).get(getC()))) {
			getFields().get(1).remove(getC());
			setC(getC() - 1);
		}
	}

}
