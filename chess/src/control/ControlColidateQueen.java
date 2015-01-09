package control;

import model.IFigure;
import model.Player;

public class ControlColidateQueen {
	
	private ColidatingFields coli = new ColidatingFields();

	public ColidatingFields getColi() {
		return coli;
	}

	public void colidateQueen(IFigure f, Player p, Player p2) {
		getColi().colidateOwnQueen(f, p);
		getColi().colidateOtherQueen(f, p2);
	}

}
