package model;

import java.util.ArrayList;
import java.util.List;

//Turm
public class Rook implements Figure{

	int x;
	int y;
	
	//TODO Find out the possible Field where the Figure can go to
	@Override
	public List<Integer[]> possibleFields() {
		List<Integer[]> fields = new ArrayList<Integer[]>();
		Integer[] field = new Integer[2];
		for(int i = x; i <= 8; i++) {
			field[1] = y;
			field[2] = i + 1;
			fields.add(field);
		}
		
		for(int i = y; i <= 8; i++) {
			field[1] = i + 1;
			field[2] = x;
			fields.add(field);
		}
		
		for(int i = x; i >= 1; i--) {
			field[1] = y;
			field[2] = i - 1;
			fields.add(field);
		}
		
		for(int i = y; i >= 1; i--) {
			field[1] = i - 1;
			field[2] = x;
			fields.add(field);
		}

		return fields;
	}

	@Override
	public int[] getField() {
		int[] field = new int[2];
		field[1] = y;
		field[2] = x;
		return field;
	}

	@Override
	public void setField(int xKord, int yKord) {
		x = xKord;
		y = yKord;
	}

}
