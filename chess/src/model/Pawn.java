package model;

import java.util.ArrayList;
import java.util.List;

//Bauer
public class Pawn extends Figure{

	int FIELDSPACE = 2;
	int XCORD = 1;
	int YCORD = 0;
	boolean firstMove = true;
	
	public Pawn(int x, int y, char color) {
		setField(x,y);
		setColor(color);
		
	}

	public boolean getFirstMove() {
		return firstMove;
	}


	public void setFirstMove(boolean firstMove) {
		this.firstMove = firstMove;
	}

	@Override
	public List<Integer[]> possibleFields() {
		List<Integer[]> fields = new ArrayList<Integer[]>();
		Integer[] f = new Integer[FIELDSPACE];
		Integer[] f2 = new Integer[FIELDSPACE];
		f[YCORD] = y + 1;
		f[XCORD] = x;
		fields.add(f);
		if(getFirstMove()) {
			f2[XCORD] = x;
			f2[YCORD] = y + 2;
			fields.add(f2);
		} 
		return fields;
	}
}
