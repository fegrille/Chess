package model;

import java.util.ArrayList;

public class Queen extends Figure{
	
	private IMoves move = new Moves();
	
	public Queen(int y, int x, char color) {
		setField(y,x);
		setColor(color);
	}
	
	@Override
	public void possibleFields() {
		move.setFields(new ArrayList<Integer[]>());
		move.movesQueen(getY(), getX());
		setPosFields(move.getFields());
	}
	
}
