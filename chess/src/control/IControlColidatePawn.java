package control;

import model.IFigure;
import model.Player;

public interface IControlColidatePawn {
	
	void colidateOtherFigurePawn(IFigure f, Player p2);
	
	void colidateOwnFigurePawn(IFigure f, Player p);

}
