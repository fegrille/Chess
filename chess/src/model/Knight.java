package model;

import java.util.ArrayList;
import java.util.List;

//Pferd
public class Knight extends Figure{
	
	private List<Integer[]> fields;

	public Knight(int x, int y, char color) {
		setFields(new ArrayList<Integer[]>());
		setField(y,x);
		setColor(color);
	}
	
	public List<Integer[]> getFields() {
		return fields;
	}

	public void setFields(List<Integer[]> fields) {
		this.fields = fields;
	}

	@Override
	public List<Integer[]> possibleFields() {
		setFields(new ArrayList<Integer[]>());
		topFields();
		buttomFields();
		rightFields();
		leftFields();
		return getFields();
	}
	
	public void topFields() {
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
			fields.add(f);
		}
	}

	private void isXCordUnderMaxAxisTop(Integer[] f, int y, int x) {
		if((x + 1) <= ChessConstants.MAXAXIS) {
			f[ChessConstants.YKORD] = y + 2;
			f[ChessConstants.XKORD] = x + 1;
			fields.add(f);
		}
	}
	
	public void leftFields() {
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
			fields.add(f);
		}
	}

	private void isYCordUnderMaxAxisLeft(Integer[] f, int y, int x) {
		if((y + 1) <= ChessConstants.MAXAXIS) {
			f[ChessConstants.YKORD] = y + 1;
			f[ChessConstants.XKORD] = x - 2;
			fields.add(f);
		}
	}
	
	public void buttomFields() {
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
			fields.add(f);
		}
	}

	private void isXCordUnderMaxAxisButtom(Integer[] f, int y, int x) {
		if((x + 1) <= ChessConstants.MAXAXIS) {
			f[ChessConstants.YKORD] = y - 2;
			f[ChessConstants.XKORD] = x + 1;
			fields.add(f);
		}
	}
	
	public void rightFields() {
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
			fields.add(f);
		}
	}

	private void isYCordUnderMaxAxisRight(Integer[] f, int y, int x) {
		if((y + 1) <= ChessConstants.MAXAXIS) {
			f[ChessConstants.YKORD] = y + 1;
			f[ChessConstants.XKORD] = x + 2;
			fields.add(f);
		}
	}

}
