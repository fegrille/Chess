package model;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Felix
 *
 */
public class Knight extends Figure{

	/**
	 * 
	 * @param y
	 * @param x
	 * @param color
	 */
	public Knight(int y, int x, char color) {
		setField(y,x);
		setColor(color);
	}

	/**
	 * 
	 */
	@Override
	public void possibleFields() {
		setPosFields(new ArrayList<List<Integer[]>>());
		topFields();
		buttomFields();
		leftFields();
		rightFields();
		
	}
	
	/**
	 * 
	 */
	public void topFields() {
		List<Integer[]> fields = new ArrayList<Integer[]>();
		getPosFields().add(fields);
		int y = getY();
		int x = getX();
		if((y + 2) <= ChessConstants.MAXAXIS) {
			isXCordUnderMaxAxisTop(y, x);
			isXCordAboveMinAxisTop(y, x);
		}
	}

	/**
	 * 
	 * @param y
	 * @param x
	 */
	private void isXCordAboveMinAxisTop(int y, int x) {
		Integer[] f = new Integer[ChessConstants.FIGUREFIELDSIZE];
		if((x - 1) >= ChessConstants.MINAXIS) {
			f[ChessConstants.YKORD] = y + 2;
			f[ChessConstants.XKORD] = x - 1;
			getPosFields().get(0).add(f);
		}
	}

	/**
	 * 
	 * @param y
	 * @param x
	 */
	private void isXCordUnderMaxAxisTop(int y, int x) {
		Integer[] f = new Integer[ChessConstants.FIGUREFIELDSIZE];
		if((x + 1) <= ChessConstants.MAXAXIS) {
			f[ChessConstants.YKORD] = y + 2;
			f[ChessConstants.XKORD] = x + 1;
			getPosFields().get(0).add(f);
		}
	}
	
	/**
	 * 
	 */
	public void leftFields() {
		List<Integer[]> fields = new ArrayList<Integer[]>();
		getPosFields().add(fields);
		int y = getY();
		int x = getX();
		if((x - 2) >= ChessConstants.MINAXIS) {
			isYCordUnderMaxAxisLeft(y, x);
			isYCordAboveMinAxisLeft(y, x);
		}
	}

	/**
	 * 
	 * @param y
	 * @param x
	 */
	private void isYCordAboveMinAxisLeft(int y, int x) {
		Integer[] f = new Integer[ChessConstants.FIGUREFIELDSIZE];
		if((y - 1) >= ChessConstants.MINAXIS) {
			f[ChessConstants.YKORD] = y - 1;
			f[ChessConstants.XKORD] = x - 2;
			getPosFields().get(2).add(f);
		}
	}

	/**
	 * 
	 * @param y
	 * @param x
	 */
	private void isYCordUnderMaxAxisLeft(int y, int x) {
		Integer[] f = new Integer[ChessConstants.FIGUREFIELDSIZE];
		if((y + 1) <= ChessConstants.MAXAXIS) {
			f[ChessConstants.YKORD] = y + 1;
			f[ChessConstants.XKORD] = x - 2;
			getPosFields().get(2).add(f);
		}
	}
	
	/**
	 * 
	 */
	public void buttomFields() {
		List<Integer[]> fields = new ArrayList<Integer[]>();
		getPosFields().add(fields);
		int y = getY();
		int x = getX();
		if((y - 2) >= ChessConstants.MINAXIS) {
			isXCordUnderMaxAxisButtom(y, x);
			isXCordAboveMinAxisButtom(y, x);
		}
	}

	/**
	 * 
	 * @param y
	 * @param x
	 */
	private void isXCordAboveMinAxisButtom(int y, int x) {
		Integer[] f = new Integer[ChessConstants.FIGUREFIELDSIZE];
		if((x - 1) >= ChessConstants.MINAXIS) {
			f[ChessConstants.YKORD] = y - 2;
			f[ChessConstants.XKORD] = x - 1;
			getPosFields().get(1).add(f);
		}
	}

	/**
	 * 
	 * @param y
	 * @param x
	 */
	private void isXCordUnderMaxAxisButtom(int y, int x) {
		Integer[] f = new Integer[ChessConstants.FIGUREFIELDSIZE];
		if((x + 1) <= ChessConstants.MAXAXIS) {
			f[ChessConstants.YKORD] = y - 2;
			f[ChessConstants.XKORD] = x + 1;
			getPosFields().get(1).add(f);
		}
	}
	
	/**
	 * 
	 */
	public void rightFields() {
		List<Integer[]> fields = new ArrayList<Integer[]>();
		getPosFields().add(fields);
		int y = getY();
		int x = getX();
		if((x + 2) <= ChessConstants.MAXAXIS) {
			isYCordUnderMaxAxisRight(y, x);
			isYCordAboveMinAxisRight(y, x);
		}
	}

	/**
	 * 
	 * @param y
	 * @param x
	 */
	private void isYCordAboveMinAxisRight(int y, int x) {
		Integer[] f = new Integer[ChessConstants.FIGUREFIELDSIZE];
		if((y - 1) >= ChessConstants.MINAXIS) {
			f[ChessConstants.YKORD] = y - 1;
			f[ChessConstants.XKORD] = x + 2;
			getPosFields().get(ChessConstants.LISTELEFOUR).add(f);
		}
	}

	/**
	 * 
	 * @param y
	 * @param x
	 */
	private void isYCordUnderMaxAxisRight(int y, int x) {
		Integer[] f = new Integer[ChessConstants.FIGUREFIELDSIZE];
		if((y + 1) <= ChessConstants.MAXAXIS) {
			f[ChessConstants.YKORD] = y + 1;
			f[ChessConstants.XKORD] = x + 2;
			getPosFields().get(ChessConstants.LISTELEFOUR).add(f);
		}
	}

	/**
	 * 
	 */
	public String returnName() {
		return "Knight";
	}
}
