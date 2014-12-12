package model;

import java.util.ArrayList;
import java.util.List;

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
	public void possibleFields() {
		setPosFields(new ArrayList<Integer[]>());
		isFigureBlack();
		isFigureWhite();
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
			getPosFields().add(f);
			leftUpFieldBlack();
			rightUpFieldBlack();
			isFirstMoveBlack();
		}
	}

	private void rightUpFieldWhite() {
		if((getX() + 1) <= ChessConstants.MAXAXIS) {
			Integer[] f = new Integer[ChessConstants.FIGUREFIELDSIZE];
			f[ChessConstants.YKORD] = getY() + 1;
			f[ChessConstants.XKORD] = getX() + 1;
			getPosFields().add(f);
		}
	}

	private void leftUpFieldWhite() {
		if((getX() - 1) >= ChessConstants.MINAXIS) {
			Integer[] f = new Integer[ChessConstants.FIGUREFIELDSIZE];
			f[ChessConstants.YKORD] = getY() + 1;
			f[ChessConstants.XKORD] = getX() - 1;
			getPosFields().add(f);
		}
	}
	
	private void rightUpFieldBlack() {
		if((getX() + 1) <= ChessConstants.MAXAXIS) {
			Integer[] f = new Integer[ChessConstants.FIGUREFIELDSIZE];
			f[ChessConstants.YKORD] = getY() - 1;
			f[ChessConstants.XKORD] = getX() + 1;
			getPosFields().add(f);
		}
	}

	private void leftUpFieldBlack() {
		if((getX() - 1) >= ChessConstants.MINAXIS) {
			Integer[] f = new Integer[ChessConstants.FIGUREFIELDSIZE];
			f[ChessConstants.YKORD] = getY() - 1;
			f[ChessConstants.XKORD] = getX() - 1;
			getPosFields().add(f);
		}
	}

	private void isFirstMoveBlack() {
		Integer[] f2 = new Integer[ChessConstants.FIGUREFIELDSIZE];
		if(getFirstMove()) {
			f2[ChessConstants.XKORD] = getX();
			f2[ChessConstants.YKORD] = getY() - 2;
			getPosFields().add(f2);
		}
	}
	
	public void possibleFieldsWhite() {
		Integer[] f = new Integer[ChessConstants.FIGUREFIELDSIZE];
		if((getY() + 1) <= ChessConstants.MAXAXIS) {
			f[ChessConstants.YKORD] = getY() + 1;
			f[ChessConstants.XKORD] = getX();
			getPosFields().add(f);
			leftUpFieldWhite();
			rightUpFieldWhite();
			isFirstMoveWhite(); 
		}
	}

	private void isFirstMoveWhite() {
		Integer[] f2 = new Integer[ChessConstants.FIGUREFIELDSIZE];
		if(getFirstMove()) {
			f2[ChessConstants.XKORD] = getX();
			f2[ChessConstants.YKORD] = getY() + 2;
			getPosFields().add(f2);
		}
	}
}
