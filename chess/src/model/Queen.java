package model;

import java.util.ArrayList;

public class Queen extends Figure{
	
	private Moves move = new Moves();
	
	public Queen(int y, int x, char color) {
		setField(y,x);
		setColor(color);
	}
	
	@Override
	public void possibleFields() {
		move.setFields(new ArrayList<Integer[]>());
		int x = getX();
		int y = getY();
		move.moveUpFields(y, x);
		move.moveDownFields(y, x);
		move.moveLeftFields(y, x);
		move.moveRightFields(y, x);
		move.moveRightUp(y, x);
		move.moveLeftUp(y, x);
		move.moveRightDown(y, x);
		move.moveLeftDown(y, x);
		setPosFields(move.getFields());
	}
	
}
