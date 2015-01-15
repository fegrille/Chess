package control;

import model.IFigure;
import model.Player;

public interface IControlColidateKing {
	
	void colidateOwnFigureKing(IFigure f, Player p);
	
	void colidateOtherFigureKing(IFigure f, Player p);

}
