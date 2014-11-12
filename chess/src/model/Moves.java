package model;

import java.util.List;

public class Moves {
	
	public List<Integer[]> moveUpFields(List<Integer[]> fields, int yKord, int xKord) {
		Integer[] field = new Integer[ChessConstants.FIGUREFIELDSIZE];
		for(int i = yKord; i <= ChessConstants.MAXAXIS; i++) {
			field[ChessConstants.YKORD] = i + 1;
			field[ChessConstants.XKORD] = xKord;
			fields.add(field);
		}
		return fields;
	}
	
	public List<Integer[]> moveDownFields(List<Integer[]> fields, int yKord, int xKord) {
		Integer[] field = new Integer[ChessConstants.FIGUREFIELDSIZE];
		for(int i = yKord; i >= 1; i--) {
			field[ChessConstants.YKORD] = i - 1;
			field[ChessConstants.XKORD] = xKord;
			fields.add(field);
		}
		return fields;
	}
	
	public List<Integer[]> moveLeftFields(List<Integer[]> fields, int yKord, int xKord) {
		Integer[] field = new Integer[ChessConstants.FIGUREFIELDSIZE];
		for(int i = xKord; i >= 1; i--) {
			field[ChessConstants.YKORD] = yKord;
			field[ChessConstants.XKORD] = i - 1;
			fields.add(field);
		}
		return fields;
	}
	
	public List<Integer[]> moveRightFields(List<Integer[]> fields, int yKord, int xKord) {
		Integer[] field = new Integer[ChessConstants.FIGUREFIELDSIZE];
		for(int i = xKord; i <= ChessConstants.MAXAXIS; i++) {
			field[ChessConstants.YKORD] = yKord;
			field[ChessConstants.XKORD] = i + 1;
			fields.add(field);
		}
		return fields;
	}
	
	public List<Integer[]> moveRightUp(List<Integer[]> fields, int yKord, int xKord) {
		Integer[] field = new Integer[ChessConstants.FIGUREFIELDSIZE];
		int y = yKord;
		int x = xKord;
		while(y <= ChessConstants.MAXAXIS && x <= ChessConstants.MAXAXIS) {
			field[ChessConstants.YKORD] = y + 1;
			field[ChessConstants.XKORD] = x + 1;
			fields.add(field);
			y++;
			x++;
		}
		return fields;
	}
	
	public List<Integer[]> moveLeftUp(List<Integer[]> fields, int yKord, int xKord) {
		Integer[] field = new Integer[ChessConstants.FIGUREFIELDSIZE];
		int y = yKord;
		int x = xKord;
		while(y <= ChessConstants.MAXAXIS && x >= ChessConstants.MINAXIS) {
			field[ChessConstants.YKORD] = y + 1;
			field[ChessConstants.XKORD] = x - 1;
			fields.add(field);
			y++;
			x--;
		}
		return fields;
	}
	
	public List<Integer[]> moveRightDown(List<Integer[]> fields, int yKord, int xKord) {
		Integer[] field = new Integer[ChessConstants.FIGUREFIELDSIZE];
		int y = yKord;
		int x = xKord;
		while(y >= ChessConstants.MINAXIS && x <= ChessConstants.MAXAXIS) {
			field[ChessConstants.YKORD] = y - 1;
			field[ChessConstants.XKORD] = x + 1;
			fields.add(field);
			y--;
			x++;
		}
		return fields;
	}
	
	public List<Integer[]> moveLeftDown(List<Integer[]> fields, int yKord, int xKord) {
		Integer[] field = new Integer[ChessConstants.FIGUREFIELDSIZE];
		int y = yKord;
		int x = xKord;
		while(y <= ChessConstants.MINAXIS && x <= ChessConstants.MINAXIS) {
			field[ChessConstants.YKORD] = y - 1;
			field[ChessConstants.XKORD] = x - 1;
			fields.add(field);
			y--;
			x--;
		}
		return fields;
	}

}
