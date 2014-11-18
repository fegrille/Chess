package model.figures;

import java.util.ArrayList;
import java.util.List;

import model.Figure;
import model.Moves;

//Turm
public class Rook extends Figure{

	private Moves move = new Moves();
	
	public Rook(int y, int x, char color) {
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

		return fields;
	}

}
