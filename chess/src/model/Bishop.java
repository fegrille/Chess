package model;

import java.util.ArrayList;
import java.util.List;

//Läufer
public class Bishop extends Figure{
	
	private Moves move = new Moves();
	
	public Bishop(int x, int y, char color) {
		setField(x,y);
		setColor(color);
	}
	
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
