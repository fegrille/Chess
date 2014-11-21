package model;

import java.util.ArrayList;
import java.util.List;

//Bauer
public class Pawn extends Figure{

	private boolean firstMove = true;
	private List<Integer[]> fields;

	public Pawn(int y, int x, char color) {
		setField(y,x);
		setColor(color);
		
	}
	
	public List<Integer[]> getFields() {
		return fields;
	}

	public void setFields(List<Integer[]> fields) {
		this.fields = fields;
	}
	public boolean getFirstMove() {
		return firstMove;
	}


	public void setFirstMove(boolean firstMove) {
		this.firstMove = firstMove;
	}

	@Override
	public List<Integer[]> possibleFields() {
		setFields(new ArrayList<Integer[]>());
		isFigureBlack();
		isFigureWhite();
		return getFields();
	}
	
	public void isFigureBlack() {
		if(getColor() == 'b') {
			possibleFieldsBlack();
		}
	}
	
	public void isFigureWhite() {
		if(getColor() == 'w') {
			possibleFieldsWhite();
		}
	}
	
	public void possibleFieldsBlack() {
		Integer[] f = new Integer[ChessConstants.FIGUREFIELDSIZE];
		if((getY() - 1) >= ChessConstants.MINAXIS) {
			f[ChessConstants.YKORD] = getY() - 1;
			f[ChessConstants.XKORD] = getX();
			getFields().add(f);
			isFirstMoveBlack(); 
		}
	}

	private void isFirstMoveBlack() {
		Integer[] f2 = new Integer[ChessConstants.FIGUREFIELDSIZE];
		if(getFirstMove()) {
			f2[ChessConstants.XKORD] = getX();
			f2[ChessConstants.YKORD] = getY() - 2;
			getFields().add(f2);
		}
	}
	
	public void possibleFieldsWhite() {
		Integer[] f = new Integer[ChessConstants.FIGUREFIELDSIZE];
		if((getY() + 1) <= ChessConstants.MAXAXIS) {
			f[ChessConstants.YKORD] = getY() + 1;
			f[ChessConstants.XKORD] = getX();
			getFields().add(f);
			isFirstMoveWhite(); 
		}
	}

	private void isFirstMoveWhite() {
		Integer[] f2 = new Integer[ChessConstants.FIGUREFIELDSIZE];
		if(getFirstMove()) {
			f2[ChessConstants.XKORD] = getX();
			f2[ChessConstants.YKORD] = getY() + 2;
			getFields().add(f2);
		}
	}
}
