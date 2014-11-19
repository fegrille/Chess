package control;

import model.Figure;
import model.figures.Bishop;
import model.figures.Knight;
import model.figures.Pawn;
import model.figures.Queen;
import model.figures.Rook;

public class ControlPawn {
	
	private Figure newFig;
	
	public Figure getNewFig() {
		return newFig;
	}


	public void setNewFig(Figure newFig) {
		this.newFig = newFig;
	}


	public boolean checkEndfield(Pawn pawn) {
		boolean endField = false;
		setNewFig(pawn);
		if(getNewFig().getColor() == 'w' && getNewFig().getY() == 8) {
			endField = true;
		} else if(getNewFig().getColor() == 'b'&& getNewFig().getY() == 1) {
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