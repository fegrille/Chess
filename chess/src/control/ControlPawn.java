package control;

import model.Bishop;
import model.ChessConstants;
import model.Figure;
import model.Knight;
import model.Queen;
import model.Rook;
/**
 * 
 * @author Felix
 *
 */
public class ControlPawn {
	
	private Figure newFig = null;
	private boolean endField = false;
	
	/**
	 * 
	 * @return
	 */
	public boolean isEndField() {
		return endField;
	}

	/**
	 * 
	 * @param endField
	 */
	public void setEndField(boolean endField) {
		this.endField = endField;
	}

	/**
	 * 
	 * @return
	 */
	public Figure getNewFig() {
		return newFig;
	}

	/**
	 * 
	 * @param newFig
	 */
	public void setNewFig(Figure newFig) {
		this.newFig = newFig;
	}

	/**
	 * 
	 * @param pawn
	 * @return
	 */
	public boolean checkEndfield(Figure pawn) {
		setNewFig(pawn);
		int y = getNewFig().getY();
		int color = getNewFig().getColor();
		checkEndFieldWhite(y, color);
		checkEndFieldBlack(y, color);
		return isEndField();
	}

	/**
	 * 
	 * @param y
	 * @param color
	 */
	private void checkEndFieldWhite(int y, int color) {
		if(color == 'w' && y == ChessConstants.MAXAXIS) {
			setEndField(true);
		}
	}

	/**
	 * 
	 * @param y
	 * @param color
	 */
	private void checkEndFieldBlack(int y, int color) {
		if(color == 'b'&& y == ChessConstants.MINAXIS) {
			setEndField(true);
		}
	}

	/**
	 * 
	 * @param choice
	 * @return
	 */
	public Figure changeFigure(String choice) {
		setBishop(choice);
		setKnight(choice);
		setQueen(choice);
		setRook(choice);
		return getNewFig();
	}
	
	/**
	 * 
	 * @param choice
	 */
	private void setBishop(String choice) {
		if(choice.equals("Bishop")) {
			setNewFig(new Bishop(getNewFig().getX(), getNewFig().getY(), getNewFig().getColor()));
		}
	}
	/**
	 * 
	 * @param choice
	 */
	private void setKnight(String choice) {
		if(choice.equals("Knight")) {
			setNewFig(new Knight(getNewFig().getX(), getNewFig().getY(), getNewFig().getColor()));
		}
	}
	
	/**
	 * 
	 * @param choice
	 */
	private void setQueen(String choice) {
		if(choice.equals("Queen")) {
			setNewFig(new Queen(getNewFig().getX(), getNewFig().getY(), getNewFig().getColor()));
		}
	}
	
	/**
	 * 
	 * @param choice
	 */
	private void setRook(String choice) {
		if(choice.equals("Rook")) {
			setNewFig(new Rook(getNewFig().getX(), getNewFig().getY(), getNewFig().getColor()));
		}
	}
}