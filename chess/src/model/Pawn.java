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
		setPosFields(new ArrayList<List<Integer[]>>());
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
		List<Integer[]> fields = new ArrayList<>();
		List<Integer[]> fields2 = new ArrayList<>();
		getPosFields().add(fields);
		getPosFields().add(fields2);
		Integer[] f = new Integer[ChessConstants.FIGUREFIELDSIZE];
		if((getY() - 1) >= ChessConstants.MINAXIS) {
			f[ChessConstants.YKORD] = getY() - 1;
			f[ChessConstants.XKORD] = getX();
			getPosFields().get(0).add(f);
			isFirstMoveBlack();
			leftUpFieldBlack();
			rightUpFieldBlack();
			
		}
	}

	private void rightUpFieldWhite() {
		if((getX() + 1) <= ChessConstants.MAXAXIS) {
			Integer[] f = new Integer[ChessConstants.FIGUREFIELDSIZE];
			f[ChessConstants.YKORD] = getY() + 1;
			f[ChessConstants.XKORD] = getX() + 1;
			getPosFields().get(1).add(f);
		}
	}

	private void leftUpFieldWhite() {
		if((getX() - 1) >= ChessConstants.MINAXIS) {
			Integer[] f = new Integer[ChessConstants.FIGUREFIELDSIZE];
			f[ChessConstants.YKORD] = getY() + 1;
			f[ChessConstants.XKORD] = getX() - 1;
			getPosFields().get(1).add(f);
		}
	}
	
	private void rightUpFieldBlack() {
		if((getX() + 1) <= ChessConstants.MAXAXIS) {
			Integer[] f = new Integer[ChessConstants.FIGUREFIELDSIZE];
			f[ChessConstants.YKORD] = getY() - 1;
			f[ChessConstants.XKORD] = getX() + 1;
			getPosFields().get(1).add(f);
		}
	}

	private void leftUpFieldBlack() {
		if((getX() - 1) >= ChessConstants.MINAXIS) {
			Integer[] f = new Integer[ChessConstants.FIGUREFIELDSIZE];
			f[ChessConstants.YKORD] = getY() - 1;
			f[ChessConstants.XKORD] = getX() - 1;
			getPosFields().get(1).add(f);
		}
	}

	private void isFirstMoveBlack() {
		Integer[] f2 = new Integer[ChessConstants.FIGUREFIELDSIZE];
		if(getFirstMove()) {
			f2[ChessConstants.XKORD] = getX();
			f2[ChessConstants.YKORD] = getY() - 2;
			getPosFields().get(0).add(f2);
		}
	}
	
	public void possibleFieldsWhite() {
		List<Integer[]> fields = new ArrayList<>();
		List<Integer[]> fields2 = new ArrayList<>();
		getPosFields().add(fields);
		getPosFields().add(fields2);
		Integer[] f = new Integer[ChessConstants.FIGUREFIELDSIZE];
		if((getY() + 1) <= ChessConstants.MAXAXIS) {
			f[ChessConstants.YKORD] = getY() + 1;
			f[ChessConstants.XKORD] = getX();
			getPosFields().get(0).add(f);
			isFirstMoveWhite();
			leftUpFieldWhite();
			rightUpFieldWhite();
			
		}
	}

	private void isFirstMoveWhite() {
		Integer[] f2 = new Integer[ChessConstants.FIGUREFIELDSIZE];
		if(getFirstMove()) {
			f2[ChessConstants.XKORD] = getX();
			f2[ChessConstants.YKORD] = getY() + 2;
			getPosFields().get(0).add(f2);
		}
	}
}
