/**
 * 
 */
package model;

import java.util.List;

/**
 * @author fegrille
 *
 */
public interface IPlayer {
	
	/**
	 * Method to return a list with all figures on the field from the player
	 * @return
	 */
	List<Figure> getFigureList();
	
	/**
	 * Method to set the figure list of the player
	 * @param figureList
	 */
	void setFigureList(List<Figure> figureList);
	
	/**
	 * Method to get the color of the player (black or white)
	 * @return Returns the color of the player
	 */
	char getCol();

}
