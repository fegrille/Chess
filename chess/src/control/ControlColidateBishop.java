package control;

import java.util.List;

import model.Figure;
import model.Player;

public class ControlColidateBishop {
	
	private ColidatingFields coli = new ColidatingFields();
	private List<Integer[]> fields;
	
	public List<Integer[]> getFields() {
		return fields;
	}

	public void setFields(List<Integer[]> fields) {
		this.fields = fields;
	}

	public ColidatingFields getColi() {
		return coli;
	}

	public void colidateBishop(Figure f, Player p, Player p2) {
		setFields(getColi().colidateOwnFigureDiagonal(f,f.getPosFields(),p));
		setFields(getColi().colidateOtherFigureDiagonal(f,getFields(),p2));
		f.setPosFields(getFields());
	}

}
