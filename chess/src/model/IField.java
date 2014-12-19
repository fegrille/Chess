/**
 * 
 */
package model;

import java.util.Map;

/**
 * @author fegrille
 *
 */
public interface IField {
	
	/**
	 * Method that returns the field
	 * @return Returns the field as a map containing another map as value
	 */
	Map<Integer, Map<Integer,Figure>> getFields();
	
	/**
	 * This method initialize the field where the figure stands with the figure
	 * Only have to be called after starting the game
	 * @param figure - figure that should be binded on a field
	 */
	void initializeField(Figure figure);

}
