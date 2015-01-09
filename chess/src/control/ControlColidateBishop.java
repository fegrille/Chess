package control;

import model.IFigure;
import model.Player;

public class ControlColidateBishop {
	
	private ColidatingFields coli = new ColidatingFields();

	public ColidatingFields getColi() {
		return coli;
	}

	public void colidateBishop(IFigure f, Player p, Player p2) {
		getColi().colidateOwnFigure(f, p);
		getColi().colidateOtherFigure(f, p2);
	}

}
