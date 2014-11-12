package model;

import java.util.ArrayList;
import java.util.List;

//Turm
public class Rook extends Figure{

	public Rook(int x, int y, char color) {
		setField(x,y);
		setColor(color);
	}
	
	@Override
	public List<Integer[]> possibleFields() {
		List<Integer[]> fields = new ArrayList<Integer[]>();
		fields = moveUpFields(fields);
		fields = moveDownFields(fields);
		fields = moveLeftFields(fields);
		fields = moveRightFields(fields);

		return fields;
	}
	
	private List<Integer[]> moveUpFields(List<Integer[]> fields) {
		Integer[] field = new Integer[ChessConstants.FIGUREFIELDSIZE];
		for(int i = getY(); i <= ChessConstants.MAXAXIS; i++) {
			field[ChessConstants.YKORD] = i + 1;
			field[ChessConstants.XKORD] = getX();
			fields.add(field);
		}
		return fields;
	}
	
	private List<Integer[]> moveDownFields(List<Integer[]> fields) {
		Integer[] field = new Integer[ChessConstants.FIGUREFIELDSIZE];
		for(int i = getY(); i >= 1; i--) {
			field[ChessConstants.YKORD] = i - 1;
			field[ChessConstants.XKORD] = getX();
			fields.add(field);
		}
		return fields;
	}
	
	private List<Integer[]> moveLeftFields(List<Integer[]> fields) {
		Integer[] field = new Integer[ChessConstants.FIGUREFIELDSIZE];
		for(int i = getX(); i >= 1; i--) {
			field[ChessConstants.YKORD] = getY();
			field[ChessConstants.XKORD] = i - 1;
			fields.add(field);
		}
		return fields;
	}
	
	private List<Integer[]> moveRightFields(List<Integer[]> fields) {
		Integer[] field = new Integer[ChessConstants.FIGUREFIELDSIZE];
		for(int i = getX(); i <= ChessConstants.MAXAXIS; i++) {
			field[ChessConstants.YKORD] = getY();
			field[ChessConstants.XKORD] = i + 1;
			fields.add(field);
		}
		return fields;
	}

}
