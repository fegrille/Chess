package control;

import model.IFigure;
import model.Player;

public interface IColidatingfields {
	
	/**
	 * Makes a copy of the figure list of the current player 
	 * and removes the figure that will be moves
	 * @param f
	 */
	void unmovedFigures(IFigure f);
	
	/**
	 * Controls for colidation and returns true if a field colidates
	 * @param posF
	 * @return
	 */
	boolean colidate(Integer[] posF);
	
	/**
	 * Checks colidate with own figures and removes field if they colidate
	 * It is used by bishop and rook because they nearly have the same
	 * kind of check their fields
	 * @param f
	 * @param p
	 */
	void colidateOwnFigure(IFigure f, Player p);
	
	/**
	 * Checks colidate with other figures and removes field if they colidate
	 * It is used by bishop and rook because they nearly have the same
	 * kind of check their fields
	 * @param f
	 * @param p
	 */
	void colidateOtherFigure(IFigure f, Player p);
	
	/**
	 * Check fields in front of a pawn and removes them
	 * This method will be used by both black and white pawns
	 * @param f
	 * @param p
	 */
	void colidateInFrontPawn(IFigure f, Player p);
	
	/**
	 * Checks colidation with own figures of queen
	 * Extra method because queen has 8 directions to move
	 */
	void colidateOwnQueen(IFigure f, Player p);
	
	/**
	 * Checks colidation with other figures of queen
	 * Extra method because queen has 8 directions to move
	 */
	void colidateOtherQueen(IFigure f, Player p);
}
