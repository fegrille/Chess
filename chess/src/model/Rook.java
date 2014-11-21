package model;

import java.util.List;

//Turm
public class Rook extends Figure{

	private Moves move = new Moves();
	
	public Rook(int y, int x, char color) {
		setField(y,x);
		setColor(color);
	}
	
	@Override
	public List<Integer[]> possibleFields() {
		move.moveUpFields(getY(), getX());
		move.moveDownFields(getY(), getX());
		move.moveLeftFields(getY(), getX());
		move.moveRightFields(getY(), getX());

		return move.getFields();
	}

}
