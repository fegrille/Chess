package model;

import java.util.List;

//Läufer
public class Bishop implements Figure{

	int x;
	int y;
	
	//TODO Find out the possible Field where the Figure can go to
	@Override
	public List<Integer[]> possibleFields() {
		return null;
		
		
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
