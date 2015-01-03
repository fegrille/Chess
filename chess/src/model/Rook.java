package model;

import java.util.ArrayList;

//Turm
public class Rook extends Figure{

	private IMoves move = new Moves();
	
	public Rook(int y, int x, char color) {
		setField(y,x);
		setColor(color);
	}
	
	@Override
	public void possibleFields() {
		move.setFields(new ArrayList<Integer[]>());
		move.movesRook(getY(), getX());
		setPosFields(move.getFieldList());
	}

}
