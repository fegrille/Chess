package control;

import model.Figure;
import model.Player;

public class ControlChess {
	
	boolean chess = false;
	int[] kingField = {};

	public boolean checkChess(Player p, Figure lastMovedFigure, ControlColidate col, Player p2) {
		getKingField(p);
		checkFigures(lastMovedFigure, col, p, p2);
		return isChess();
	}

	private void getKingField(Player p) {
		Figure king = p.getFigureList().get(p.getFigureList().size() - 1);
		setKingField(king.getField());
	}

	private void checkFigures(Figure lastMovedFigure, ControlColidate col, Player p, Player p2) {
		for(Integer[] field : col.colidate(lastMovedFigure, lastMovedFigure.possibleFields(), p2, p)) {
			compareField(field);
		}
	}
	
	private void compareField(Integer[] field) {
		if(getKingField()[0] == field[0] && getKingField()[1] ==  field[1]) {
			setChess(true);
		}
	}

	private int[] getKingField() {
		return kingField;
	}

	private void setKingField(int[] kingField) {
		this.kingField = kingField;
	}

	public boolean isChess() {
		return chess;
	}

	public void setChess(boolean chess) {
		this.chess = chess;
	}
}
