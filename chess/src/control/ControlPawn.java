package control;

import model.Bishop;
import model.Figure;
import model.Knight;
import model.Pawn;
import model.Queen;
import model.Rook;

public class ControlPawn {
	
	public boolean checkEndfield(Pawn pawn) {
		if(pawn.getColor() == 'w') {
			if(pawn.getY() == 8) {
				return true;
			}
		} else if(pawn.getColor() == 'b') {
			if(pawn.getY() == 1) {
				return true;
			}
		}
		return false;
	}


	public Figure changeFigure(Pawn pawn, String choise) {
		if(choise.equals("Bishop")) {
			return new Bishop(pawn.getX(), pawn.getY(), pawn.getColor());
		} else if(choise.equals("Knight")) {
			return new Knight(pawn.getX(), pawn.getY(), pawn.getColor());
		} else if(choise.equals("Queen")) {
			return new Queen(pawn.getX(), pawn.getY(), pawn.getColor());
		} else if(choise.equals("Rook")) {
			return new Rook(pawn.getX(), pawn.getY(), pawn.getColor());
		}
		return null;
	}
}