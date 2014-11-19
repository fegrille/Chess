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
	
	public Figure getNewFig() {
		return newFig;
	}

	public void setNewFig(Figure newFig) {
		this.newFig = newFig;
	}

	public boolean checkEndfield(Figure pawn) {
		boolean endField = false;
		setNewFig(pawn);
		int y = getNewFig().getY();
		int color = getNewFig().getColor();
		if(color == 'w' && y == ChessConstants.MAXAXIS) {
			endField = true;
		} else if(color == 'b'&& y == ChessConstants.MINAXIS) {
			endField = true;
		}
		return endField;
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