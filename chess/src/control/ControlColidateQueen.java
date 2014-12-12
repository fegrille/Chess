package control;

import java.util.List;

import model.Figure;
import model.Player;

public class ControlColidateQueen {
	
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

	public void colidateQueen(Figure f, Player p, Player p2) {
		setFields(getColi().colidateOwnFigureHorVer(f,f.getPosFields(),p));
		setFields(getColi().colidateOtherFigureHorVer(f,getFields(),p2));
		setFields(getColi().colidateOwnFigureDiagonal(f,getFields(),p));
		setFields(getColi().colidateOtherFigureDiagonal(f,getFields(),p2));
		f.setPosFields(getFields());
	}

}
