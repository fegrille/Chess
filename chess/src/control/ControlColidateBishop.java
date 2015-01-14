package control;

import model.IFigure;
import model.Player;
/**
 * 
 * @author Felix
 *
 */
public class ControlColidateBishop {
	
	private ColidatingFields coli = new ColidatingFields();

	/**
	 * 
	 * @return
	 */
	public ColidatingFields getColi() {
		return coli;
	}

	/**
	 * 
	 * @param f
	 * @param p
	 * @param p2
	 */
	public void colidateBishop(IFigure f, Player p, Player p2) {
		getColi().colidateOwnFigure(f, p);
		getColi().colidateOtherFigure(f, p2);
	}

}
