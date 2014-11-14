package model;

import java.util.ArrayList;
import java.util.List;

/**
 * This class contains everything that is special for the bishop figure
 * @author fegrille
 */
public class Bishop extends Figure{
	
	private Moves move = new Moves();
	
	/**
	 * Constructor to initialize bishop
	 * @param y - y-cords of the figure
	 * @param x - x-cords of the figure
	 * @param color - color of the player
	 */
	public Bishop(int y, int x, char color) {
		setField(y,x);
		setColor(color);
	}
	
	/**
	 * Method to get the fields where the bishop figure can go to
	 */
	@Override
	public List<Integer[]> possibleFields() {
		List<Integer[]> fields = new ArrayList<Integer[]>();
		fields = move.moveRightUp(fields, getY(), getX());
		fields = move.moveLeftUp(fields, getY(), getX());
		fields = move.moveRightDown(fields, getY(), getX());
		fields = move.moveLeftDown(fields, getY(), getX());
		return fields;
	}	

}
