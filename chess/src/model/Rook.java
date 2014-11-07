package model;

import java.util.ArrayList;
import java.util.List;

//Turm
public class Rook extends Figure{

	int x;
	int y;
	
	//TODO Find out the possible Field where the Figure can go to
	@Override
	public List<Integer[]> possibleFields() {
		List<Integer[]> fields = new ArrayList<Integer[]>();
		Integer[] field = new Integer[ChessConstants.FIGUREFIELDSIZE];
		for(int i = x; i <= 8; i++) {
			field[ChessConstants.YKORD] = y;
			field[ChessConstants.XKORD] = i + 1;
			fields.add(field);
		}
		
		for(int i = y; i <= 8; i++) {
			field[ChessConstants.YKORD] = i + 1;
			field[ChessConstants.XKORD] = x;
			fields.add(field);
		}
		
		for(int i = x; i >= 1; i--) {
			field[ChessConstants.YKORD] = y;
			field[ChessConstants.XKORD] = i - 1;
			fields.add(field);
		}
		
		for(int i = y; i >= 1; i--) {
			field[ChessConstants.YKORD] = i - 1;
			field[ChessConstants.XKORD] = x;
			fields.add(field);
		}

		return fields;
	}

}
