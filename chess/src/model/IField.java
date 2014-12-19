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
	 * Method that use a map with a map as a value
	 * The key of the first map is a value for Y-Axis and the key of the second map is the X-Axis
	 * and the value is the figure that stands on this field
	 */
	void buildField();
	
	/**
	 * This method initialize the field where the figure stands with the figure
	 * Only have to be called after starting the game
	 * @param figure - figure that should be binded on a field
	 */
	void initializeField(Figure figure);
	
	/**
	 * This method is used by buildField to initialize the X-Axis 
	 * with null as the figure that stands on it
	 * @param field - a new Map for each line of the field
	 * @return Returns the initialized line
	 */
	Map<Integer,Figure> initializeXAxis(Map<Integer,Figure> field);
}
