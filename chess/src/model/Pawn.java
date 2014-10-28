package model;

import java.util.ArrayList;
import java.util.List;

//Bauer
public class Pawn implements Figure{
	
	int x;
	int y;
	boolean firstMove = true;
	
	
	public boolean getFirstMove() {
		return firstMove;
	}


	public void setFirstMove(boolean firstMove) {
		this.firstMove = firstMove;
	}


	//TODO Find out the possible Field where the Figure can go to
	@Override
	public List<Integer[]> possibleFields() {
		List<Integer[]> fields = new ArrayList<Integer[]>();
		Integer[] field = new Integer[2];
		field[1] = y;
		field[2] = x + 1;
		fields.add(field);
		if(getFirstMove()) {
			field[2] = x + 2;
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
		this.x = xKord;
		this.y = yKord;
		
	}

}
