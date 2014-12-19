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
	
	void possibleFields();
	
	int[] getField();
	
	void setField(int yKord, int xKord);
	
	void setColor(char c);
	
	char getColor();
	
	int getX();
	
	void setX(int x);
	
	int getY();
	
	void setY(int y);
	
	List<Integer[]> getPosFields();
	
	void setPosFields(List<Integer[]> posFields);

}
