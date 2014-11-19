package model;

import java.util.ArrayList;
import java.util.List;

public class Queen extends Figure{
	
	private Moves move = new Moves();
	
	public Queen(int y, int x, char color) {
		setField(y,x);
		setColor(color);
	}
	
	@Override
	public List<Integer[]> possibleFields() {
		List<Integer[]> fields = new ArrayList<Integer[]>();
		fields = move.moveUpFields(fields, getY(), getX());
		fields = move.moveDownFields(fields, getY(), getX());
		fields = move.moveLeftFields(fields, getY(), getX());
		fields = move.moveRightFields(fields, getY(), getX());
		fields = move.moveRightUp(fields, getY(), getX());
		fields = move.moveLeftUp(fields, getY(), getX());
		fields = move.moveRightDown(fields, getY(), getX());
		fields = move.moveLeftDown(fields, getY(), getX());

		return fields;
	}
	
}
