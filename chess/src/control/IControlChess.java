package control;

import model.IFigure;
import model.Player;

public interface IControlChess {
	
	boolean checkChess(Player p, IFigure lastMovedFigure, ControlColidate col, Player p2);

}
