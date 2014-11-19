package control;

import model.Figure;
import model.figures.Bishop;
import model.figures.Knight;
import model.figures.Pawn;
import model.figures.Queen;
import model.figures.Rook;

public class ControlPawn {
	
	public boolean checkEndfield(Pawn pawn) {
		boolean endField = false;
		if(pawn.getColor() == 'w' && pawn.getY() == 8) {
			endField = true;
		} else if(pawn.getColor() == 'b'&& pawn.getY() == 1) {
			endField = true;
		}
		return endField;
	}


	public Figure changeFigure(Pawn pawn, String choise) {
		Figure newFig = null;
		if(choise.equals("Bishop")) {
			newFig = new Bishop(pawn.getX(), pawn.getY(), pawn.getColor());
		} else if(choise.equals("Knight")) {
			newFig = new Knight(pawn.getX(), pawn.getY(), pawn.getColor());
		} else if(choise.equals("Queen")) {
			newFig = new Queen(pawn.getX(), pawn.getY(), pawn.getColor());
		} else if(choise.equals("Rook")) {
			newFig = new Rook(pawn.getX(), pawn.getY(), pawn.getColor());
		}
		return newFig;
	}
}