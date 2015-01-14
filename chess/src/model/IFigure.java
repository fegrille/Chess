/**
 * 
 */
package model;

import java.util.List;

/**
 * @author fegrille
 *
 */
public interface IFigure {
	
	/**
	 * 
	 */
	void possibleFields();
	
	/**
	 * 
	 * @return
	 */
	int[] getField();
	
	/**
	 * 
	 * @param yKord
	 * @param xKord
	 */
	void setField(int yKord, int xKord);
	
	/**
	 * 
	 * @param c
	 */
	void setColor(char c);
	
	/**
	 * 
	 * @return
	 */
	char getColor();
	
	/**
	 * 
	 * @return
	 */
	int getX();
	
	/**
	 * 
	 * @param x
	 */
	void setX(int x);
	
	/**
	 * 
	 * @return
	 */
	int getY();
	
	/**
	 * 
	 * @param y
	 */
	void setY(int y);
	
	/**
	 * 
	 * @return
	 */
	List<List<Integer[]>> getPosFields();
	
	/**
	 * 
	 * @param posFields
	 */
	void setPosFields(List<List<Integer[]>> posFields);
	
	/**
	 * 
	 * @return
	 */
	String returnName();

}
