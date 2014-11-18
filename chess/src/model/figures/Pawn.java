package model.figures;

import java.util.ArrayList;
import java.util.List;

import model.ChessConstants;
import model.Figure;

//Bauer
public class Pawn extends Figure{

	private boolean firstMove = true;
	
	public Pawn(int y, int x, char color) {
		setField(y,x);
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
		if(getColor() == 'b') {
			fields = possibleFieldsBlack(fields);
		} else {
			fields = possibleFieldsWhite(fields);
		}
		return fields;
	}
	
	public List<Integer[]> possibleFieldsBlack(List<Integer[]> fields) {
		Integer[] f = new Integer[ChessConstants.FIGUREFIELDSIZE];
		Integer[] f2 = new Integer[ChessConstants.FIGUREFIELDSIZE];
		if((getY() - 1) >= ChessConstants.MINAXIS) {
			f[ChessConstants.YKORD] = getY() - 1;
			f[ChessConstants.XKORD] = getX();
			fields.add(f);
			if(getFirstMove()) {
				f2[ChessConstants.XKORD] = getX();
				f2[ChessConstants.YKORD] = getY() - 2;
				fields.add(f2);
			} 
		}
		return fields;
	}
	
	public List<Integer[]> possibleFieldsWhite(List<Integer[]> fields) {
		Integer[] f = new Integer[ChessConstants.FIGUREFIELDSIZE];
		Integer[] f2 = new Integer[ChessConstants.FIGUREFIELDSIZE];
		if((getY() + 1) <= ChessConstants.MAXAXIS) {
			f[ChessConstants.YKORD] = getY() + 1;
			f[ChessConstants.XKORD] = getX();
			fields.add(f);
			if(getFirstMove()) {
				f2[ChessConstants.XKORD] = getX();
				f2[ChessConstants.YKORD] = getY() + 2;
				fields.add(f2);
			} 
		}
		return fields;
	}
}
