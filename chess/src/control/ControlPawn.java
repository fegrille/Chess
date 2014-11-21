package control;

import model.Bishop;
import model.ChessConstants;
import model.Figure;
import model.Knight;
import model.Pawn;
import model.Queen;
import model.Rook;

public class ControlPawn {
	
	private Figure newFig = null;
	private boolean endField = false;
	
	public boolean isEndField() {
		return endField;
	}

	public void setEndField(boolean endField) {
		this.endField = endField;
	}

	public Figure getNewFig() {
		return newFig;
	}

	public void setNewFig(Figure newFig) {
		this.newFig = newFig;
	}

	public boolean checkEndfield(Figure pawn) {
		setNewFig(pawn);
		int y = getNewFig().getY();
		int color = getNewFig().getColor();
		checkEndFieldWhite(y, color);
		checkEndFieldBlack(endField, y, color);
		return isEndField();
	}

	private void checkEndFieldWhite(int y, int color) {
		if(color == 'w' && y == ChessConstants.MAXAXIS) {
			setEndField(true);
		}
	}

	private void checkEndFieldBlack(boolean endField, int y, int color) {
		if(color == 'b'&& y == ChessConstants.MINAXIS) {
			setEndField(true);
		}
	}

	public Figure changeFigure(String choice) {
		setBishop(choice);
		setKnight(choice);
		setQueen(choice);
		setRook(choice);
		return getNewFig();
	}
	
	private void setBishop(String choice) {
		if(choice.equals("Bishop")) {
			setNewFig(new Bishop(getNewFig().getX(), getNewFig().getY(), getNewFig().getColor()));
		}
	}
	
	private void setKnight(String choice) {
		if(choice.equals("Knight")) {
			setNewFig(new Knight(getNewFig().getX(), getNewFig().getY(), getNewFig().getColor()));
		}
	}
	
	private void setQueen(String choice) {
		if(choice.equals("Queen")) {
			setNewFig(new Queen(getNewFig().getX(), getNewFig().getY(), getNewFig().getColor()));
		}
	}
	
	private void setRook(String choice) {
		if(choice.equals("Rook")) {
			setNewFig(new Rook(getNewFig().getX(), getNewFig().getY(), getNewFig().getColor()));
		}
	}
}