package model;

import java.util.ArrayList;
import java.util.List;

//Turm
public class Rook extends Figure{

	private Moves move = new Moves();
	
	public Rook(int x, int y, char color) {
		setField(x,y);
		setColor(color);
	}
	
	@Override
	public List<Integer[]> possibleFields() {
		List<Integer[]> fields = new ArrayList<Integer[]>();
		fields = move.moveUpFields(fields, getY(), getX());
		fields = move.moveDownFields(fields, getY(), getX());
		fields = move.moveLeftFields(fields, getY(), getX());
		fields = move.moveRightFields(fields, getY(), getX());

		return fields;
	}

}
