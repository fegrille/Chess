package model;

import java.util.ArrayList;
import java.util.List;

//Pferd
public class Knight extends Figure{

	public Knight(int y, int x, char color) {
		setField(y,x);
		setColor(color);
	}

	@Override
	public void possibleFields() {
		setPosFields(new ArrayList<List<Integer[]>>());
		topFields();
		buttomFields();
		rightFields();
		leftFields();
	}
	
	public void topFields() {
		List<Integer[]> fields = new ArrayList<>();
		getPosFields().add(fields);
		Integer[] f = new Integer[ChessConstants.FIGUREFIELDSIZE];
		int y = getY();
		int x = getX();
		if((y + 2) <= ChessConstants.MAXAXIS) {
			isXCordUnderMaxAxisTop(f, y, x);
			isXCordAboveMinAxisTop(f, y, x);
		}
	}

	private void isXCordAboveMinAxisTop(Integer[] f, int y, int x) {
		if((x - 1) >= ChessConstants.MINAXIS) {
			f[ChessConstants.YKORD] = y + 2;
			f[ChessConstants.XKORD] = x - 1;
			getPosFields().get(0).add(f);
		}
	}

	private void isXCordUnderMaxAxisTop(Integer[] f, int y, int x) {
		if((x + 1) <= ChessConstants.MAXAXIS) {
			f[ChessConstants.YKORD] = y + 2;
			f[ChessConstants.XKORD] = x + 1;
			getPosFields().get(0).add(f);
		}
	}
	
	public void leftFields() {
		List<Integer[]> fields = new ArrayList<>();
		getPosFields().add(fields);
		Integer[] f = new Integer[ChessConstants.FIGUREFIELDSIZE];
		int y = getY();
		int x = getX();
		if((x - 2) >= ChessConstants.MINAXIS) {
			isYCordUnderMaxAxisLeft(f, y, x);
			isYCordAboveMinAxisLeft(f, y, x);
		}
	}

	private void isYCordAboveMinAxisLeft(Integer[] f, int y, int x) {
		if((y - 1) >= ChessConstants.MINAXIS) {
			f[ChessConstants.YKORD] = y - 1;
			f[ChessConstants.XKORD] = x - 2;
			getPosFields().get(3).add(f);
		}
	}

	private void isYCordUnderMaxAxisLeft(Integer[] f, int y, int x) {
		if((y + 1) <= ChessConstants.MAXAXIS) {
			f[ChessConstants.YKORD] = y + 1;
			f[ChessConstants.XKORD] = x - 2;
			getPosFields().get(3).add(f);
		}
	}
	
	public void buttomFields() {
		List<Integer[]> fields = new ArrayList<>();
		getPosFields().add(fields);
		Integer[] f = new Integer[ChessConstants.FIGUREFIELDSIZE];
		int y = getY();
		int x = getX();
		if((y - 2) >= ChessConstants.MINAXIS) {
			isXCordUnderMaxAxisButtom(f, y, x);
			isXCordAboveMinAxisButtom(f, y, x);
		}
	}

	private void isXCordAboveMinAxisButtom(Integer[] f, int y, int x) {
		if((x - 1) >= ChessConstants.MINAXIS) {
			f[ChessConstants.YKORD] = y - 2;
			f[ChessConstants.XKORD] = x - 1;
			getPosFields().get(1).add(f);
		}
	}

	private void isXCordUnderMaxAxisButtom(Integer[] f, int y, int x) {
		if((x + 1) <= ChessConstants.MAXAXIS) {
			f[ChessConstants.YKORD] = y - 2;
			f[ChessConstants.XKORD] = x + 1;
			getPosFields().get(1).add(f);
		}
	}
	
	public void rightFields() {
		List<Integer[]> fields = new ArrayList<>();
		getPosFields().add(fields);
		Integer[] f = new Integer[ChessConstants.FIGUREFIELDSIZE];
		int y = getY();
		int x = getX();
		if((x + 2) <= ChessConstants.MAXAXIS) {
			isYCordUnderMaxAxisRight(f, y, x);
			isYCordAboveMinAxisRight(f, y, x);
		}
	}

	private void isYCordAboveMinAxisRight(Integer[] f, int y, int x) {
		if((y - 1) >= ChessConstants.MINAXIS) {
			f[ChessConstants.YKORD] = y - 1;
			f[ChessConstants.XKORD] = x + 2;
			getPosFields().get(2).add(f);
		}
	}

	private void isYCordUnderMaxAxisRight(Integer[] f, int y, int x) {
		if((y + 1) <= ChessConstants.MAXAXIS) {
			f[ChessConstants.YKORD] = y + 1;
			f[ChessConstants.XKORD] = x + 2;
			getPosFields().get(2).add(f);
		}
	}

}
