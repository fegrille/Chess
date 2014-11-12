package model;

import java.util.ArrayList;
import java.util.List;

//Turm
public class Rook extends Figure{

	public Rook(int x, int y, char color) {
		setField(x,y);
		setColor(color);
	}
	
	//TODO Find out the possible Field where the Figure can go to
	@Override
	public List<Integer[]> possibleFields() {
		List<Integer[]> fields = new ArrayList<Integer[]>();
		Integer[] field = new Integer[ChessConstants.FIGUREFIELDSIZE];
		for(int i = getX(); i <= 8; i++) {
			field[ChessConstants.YKORD] = getY();
			field[ChessConstants.XKORD] = i + 1;
			fields.add(field);
		}
		
		for(int i = getY(); i <= 8; i++) {
			field[ChessConstants.YKORD] = i + 1;
			field[ChessConstants.XKORD] = getX();
			fields.add(field);
		}
		
		for(int i = getX(); i >= 1; i--) {
			field[ChessConstants.YKORD] = getY();
			field[ChessConstants.XKORD] = i - 1;
			fields.add(field);
		}
		
		for(int i = getY(); i >= 1; i--) {
			field[ChessConstants.YKORD] = i - 1;
			field[ChessConstants.XKORD] = getX();
			fields.add(field);
		}

		return fields;
	}

}
