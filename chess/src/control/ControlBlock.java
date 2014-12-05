package control;

import model.Bishop;
import model.Figure;
import model.Player;
import model.Queen;
import model.Rook;

public class ControlBlock {
	
	public void isRook(Player pl, Player plOpp, ControlColidate col, Figure lastMovedFigure) {
		if(lastMovedFigure instanceof Rook) {
			
		}
	}
	
	public void isBishop(Player pl, Player plOpp, ControlColidate col, Figure lastMovedFigure) {
		if(lastMovedFigure instanceof Bishop) {
			
		}
	}
	
	public void isQueen(Player pl, Player plOpp, ControlColidate col, Figure lastMovedFigure) {
		if(lastMovedFigure instanceof Queen) {
			
		}
	}
}
