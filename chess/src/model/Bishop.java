package model;

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
		move.moveRightUp(getY(), getX());
		move.moveLeftUp(getY(), getX());
		move.moveRightDown(getY(), getX());
		move.moveLeftDown(getY(), getX());
		return move.getFields();
	}	

}
