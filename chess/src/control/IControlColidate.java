/**
 * 
 */
package control;

import model.Player;

/**
 * @author Felix
 *
 */
public interface IControlColidate {
	
	/**
	 * Updates possible fields of every figure
	 * @param p
	 * @param p2
	 */
	void colidate(Player p, Player p2);

}
