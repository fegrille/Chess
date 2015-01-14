package control;

import java.util.List;

import model.IFigure;
import model.Player;
/**
 * 
 * @author Felix
 *
 */
public class ControlChess {
	
	private boolean chess = false;
	private int[] kingField = {};

	/**
	 * 
	 * @param p
	 * @param lastMovedFigure
	 * @param col
	 * @param p2
	 * @return
	 */
	public boolean checkChess(Player p, IFigure lastMovedFigure, ControlColidate col, Player p2) {
		setChess(false);
		getKingField(p);
		checkFigures(lastMovedFigure, col, p, p2);
		return isChess();
	}

	/**
	 * 
	 * @param p
	 */
	private void getKingField(Player p) {
		IFigure king = p.getFigureList().get(p.getFigureList().size() - 1);
		setKingField(king.getField());
	}

	/**
	 * 
	 * @param lastMovedFigure
	 * @param col
	 * @param p
	 * @param p2
	 */
	private void checkFigures(IFigure lastMovedFigure, ControlColidate col, Player p, Player p2) {
		col.colidate(p2, p);
		List<List<Integer[]>> finalFields = lastMovedFigure.getPosFields();
		for(List<Integer[]> fields : finalFields) {
			for(Integer[] field : fields) {
				compareField(field);
			}
		}
	}

	/**
	 * 
	 * @param field
	 */
	private void compareField(Integer[] field) {
		if(getKingField()[0] == field[0] && getKingField()[1] ==  field[1]) {
			setChess(true);
		}
	}

	/**
	 * 
	 * @return
	 */
	private int[] getKingField() {
		return kingField;
	}

	/**
	 * 
	 * @param kf
	 */
	private void setKingField(int[] kf) {
		this.kingField = kf.clone();
	}

	/**
	 * 
	 * @return
	 */
	public boolean isChess() {
		return chess;
	}

	/**
	 * 
	 * @param chess
	 */
	public void setChess(boolean chess) {
		this.chess = chess;
	}
}
