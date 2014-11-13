package model;

import java.util.ArrayList;
import java.util.List;

//Pferd
public class Knight extends Figure{
	
	public Knight(int x, int y, char color) {
		setField(y,x);
		setColor(color);
	}
	
	@Override
	public List<Integer[]> possibleFields() {
		List<Integer[]> fields = new ArrayList<Integer[]>();
		fields = topFields(fields);
		fields = buttomFields(fields);
		fields = rightFields(fields);
		fields = leftFields(fields);
		return fields;
	}
	
	public List<Integer[]> topFields(List<Integer[]> fields) {
		Integer[] f = new Integer[ChessConstants.FIGUREFIELDSIZE];
		int y = getY();
		int x = getX();
		if((y + 2) <= ChessConstants.MAXAXIS) {
			if((x + 1) <= ChessConstants.MAXAXIS) {
				f[ChessConstants.YKORD] = y + 2;
				f[ChessConstants.XKORD] = x + 1;
				fields.add(f);
			}
			if((x - 1) >= ChessConstants.MINAXIS) {
				f[ChessConstants.YKORD] = y + 2;
				f[ChessConstants.XKORD] = x - 1;
				fields.add(f);
			}
		}
		return fields;
	}
	
	public List<Integer[]> leftFields(List<Integer[]> fields) {
		Integer[] f = new Integer[ChessConstants.FIGUREFIELDSIZE];
		int y = getY();
		int x = getX();
		if((x - 2) >= ChessConstants.MINAXIS) {
			if((y + 1) <= ChessConstants.MAXAXIS) {
				f[ChessConstants.YKORD] = y + 1;
				f[ChessConstants.XKORD] = x - 2;
				fields.add(f);
			}
			if((y - 1) >= ChessConstants.MINAXIS) {
				f[ChessConstants.YKORD] = y - 1;
				f[ChessConstants.XKORD] = x - 2;
				fields.add(f);
			}
		}
		return fields;
	}
	
	public List<Integer[]> buttomFields(List<Integer[]> fields) {
		Integer[] f = new Integer[ChessConstants.FIGUREFIELDSIZE];
		int y = getY();
		int x = getX();
		if((y - 2) >= ChessConstants.MINAXIS) {
			if((x + 1) <= ChessConstants.MAXAXIS) {
				f[ChessConstants.YKORD] = y - 2;
				f[ChessConstants.XKORD] = x + 1;
				fields.add(f);
			}
			if((x - 1) >= ChessConstants.MINAXIS) {
				f[ChessConstants.YKORD] = y - 2;
				f[ChessConstants.XKORD] = x - 1;
				fields.add(f);
			}
		}
		return fields;
	}
	
	public List<Integer[]> rightFields(List<Integer[]> fields) {
		Integer[] f = new Integer[ChessConstants.FIGUREFIELDSIZE];
		int y = getY();
		int x = getX();
		if((x + 2) <= ChessConstants.MAXAXIS) {
			if((y + 1) <= ChessConstants.MAXAXIS) {
				f[ChessConstants.YKORD] = y + 1;
				f[ChessConstants.XKORD] = x + 2;
				fields.add(f);
			}
			if((y - 1) >= ChessConstants.MINAXIS) {
				f[ChessConstants.YKORD] = y - 1;
				f[ChessConstants.XKORD] = x + 2;
				fields.add(f);
			}
		}
		return fields;
	}

}
