package control;

import model.IFigure;
import model.Player;
/**
 * 
 * @author Felix
 *
 */
public class ControlColidateQueen implements IControlColidateQueen{
	
	private ColidatingFields coli;
	
	public ControlColidateQueen() {
		coli = new ColidatingFields();
	}

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
	@Override
	public void colidateQueen(IFigure f, Player p, Player p2) {
		getColi().colidateOwnQueen(f, p);
		getColi().colidateOtherQueen(f, p2);
	}

}
