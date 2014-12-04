package control;

import java.util.List;

import model.Figure;
import model.Player;

public class ControlChess {
	
	private boolean chess = false;
	private int[] kingField = {};

	public boolean checkChess(Player p, Figure lastMovedFigure, ControlColidate col, Player p2) {
		setChess(false);
		getKingField(p);
		checkFigures(lastMovedFigure, col, p, p2);
		return isChess();
	}

	private void getKingField(Player p) {
		Figure king = p.getFigureList().get(p.getFigureList().size() - 1);
		setKingField(king.getField());
	}

	private void checkFigures(Figure lastMovedFigure, ControlColidate col, Player p, Player p2) {
		List<Integer[]> finalFields = col.colidate(lastMovedFigure, lastMovedFigure.possibleFields(), p2, p);
		for(Integer[] field : finalFields) {
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

	private void setKingField(int[] kf) {
		this.kingField = kf;
	}

	public boolean isChess() {
		return chess;
	}

	public void setChess(boolean chess) {
		this.chess = chess;
	}
}
