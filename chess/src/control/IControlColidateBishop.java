/**
 * 
 */
package control;

import model.IFigure;
import model.Player;

/**
 * @author Felix
 *
 */
public interface IControlColidateBishop {
	
	ColidatingFields getColi();
	
	void colidateBishop(IFigure f, Player p, Player p2);

}
