package model;

import java.util.ArrayList;
import java.util.List;

//Bauer
public class Pawn extends Figure{

	private boolean firstMove = true;
	
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
		Integer[] f = new Integer[ChessConstants.FIGUREFIELDSIZE];
		Integer[] f2 = new Integer[ChessConstants.FIGUREFIELDSIZE];
		f[ChessConstants.YKORD] = y + 1;
		f[ChessConstants.XKORD] = x;
		fields.add(f);
		if(getFirstMove()) {
			f2[ChessConstants.XKORD] = x;
			f2[ChessConstants.YKORD] = y + 2;
			fields.add(f2);
		} 
		return fields;
	}
}
