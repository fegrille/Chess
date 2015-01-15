package control;

import model.IFigure;
import model.Player;

public interface IControlEndGame {
	
	/**
	 * Controls win conditions
	 * @param pl
	 * @param plOpp
	 * @param col
	 * @param lastMovedFigure
	 */
	void controlWin(Player pl, Player plOpp, ControlColidate col, IFigure lastMovedFigure);
}
