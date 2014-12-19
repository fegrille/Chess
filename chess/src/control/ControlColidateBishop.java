package control;

import java.util.List;

import model.IFigure;
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

	public void colidateBishop(IFigure f, Player p, Player p2) {
		getColi().colidateOwnFigureDiagonal(f,p);
		getColi().colidateOtherFigureDiagonal(f,p2);
	}

}
