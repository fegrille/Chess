package model;

import java.util.List;

public class Queen extends Figure{
	
	private Moves move = new Moves();
	
	public Queen(int y, int x, char color) {
		setField(y,x);
		setColor(color);
	}
	
	@Override
	public List<Integer[]> possibleFields() {
		move.moveUpFields(getY(), getX());
		move.moveDownFields(getY(), getX());
		move.moveLeftFields(getY(), getX());
		move.moveRightFields(getY(), getX());
		move.moveRightUp(getY(), getX());
		move.moveLeftUp(getY(), getX());
		move.moveRightDown(getY(), getX());
		move.moveLeftDown(getY(), getX());

		return move.getFields();
	}
	
}
