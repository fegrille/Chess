/**
 * 
 */
package control;

import model.IFigure;

/**
 * @author Felix
 *
 */
public interface IControlPawn {
	
	/**
	 * Check if a pawn is one the other side of the field and transform it
	 * @param pawn
	 * @return
	 */
	boolean checkEndfield(IFigure pawn);

}
