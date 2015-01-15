package model;

import java.util.ArrayList;

/**
 * 
 * @author Felix
 *
 */
public class Queen extends Figure{
	
	private IMoves move;
	
	/**
	 * 
	 * @param y
	 * @param x
	 * @param color
	 */
	public Queen(int y, int x, char color) {
		move = new Moves();
		setField(y,x);
		setColor(color);
	}
	
	/**
	 * 
	 */
	@Override
	public void possibleFields() {
		move.setFields(new ArrayList<Integer[]>());
		move.movesQueen(getY(), getX());
		setPosFields(move.getFieldList());
	}
	
	/**
	 * 
	 */
	public String returnName() {
		return "Queen";
	}
}
