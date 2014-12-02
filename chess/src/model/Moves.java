package model;

import java.util.ArrayList;
import java.util.List;

public class Moves {
	
	private List<Integer[]> fields;
	
	public Moves() {
		fields = new ArrayList<Integer[]>();
	}
	
	public List<Integer[]> getFields() {
		return fields;
	}

	public void setFields(List<Integer[]> fields) {
		this.fields = fields;
	}

	public void moveUpFields(int yKord, int xKord) {
		for(int i = (yKord + 1); i <= ChessConstants.MAXAXIS; i++) {
			Integer[] field = new Integer[ChessConstants.FIGUREFIELDSIZE];
			field[ChessConstants.YKORD] = i;
			field[ChessConstants.XKORD] = xKord;
			getFields().add(field);
		}
	}
	
	public void moveDownFields(int yKord, int xKord) {
		for(int i = (yKord - 1); i >= ChessConstants.MINAXIS; i--) {
			Integer[] field = new Integer[ChessConstants.FIGUREFIELDSIZE];
			field[ChessConstants.YKORD] = i;
			field[ChessConstants.XKORD] = xKord;
			getFields().add(field);
		}
	}
	
	public void moveLeftFields(int yKord, int xKord) {
		for(int i = (xKord - 1); i >= ChessConstants.MINAXIS; i--) {
			Integer[] field = new Integer[ChessConstants.FIGUREFIELDSIZE];
			field[ChessConstants.YKORD] = yKord;
			field[ChessConstants.XKORD] = i;
			getFields().add(field);
		}
	}
	
	public void moveRightFields(int yKord, int xKord) {
		for(int i = (xKord + 1); i <= ChessConstants.MAXAXIS; i++) {
			Integer[] field = new Integer[ChessConstants.FIGUREFIELDSIZE];
			field[ChessConstants.YKORD] = yKord;
			field[ChessConstants.XKORD] = i;
			getFields().add(field);
		}
	}
	
	public void moveRightUp(int yKord, int xKord) {
		int y = yKord + 1;
		int x = xKord + 1;
		while(y <= ChessConstants.MAXAXIS && x <= ChessConstants.MAXAXIS) {
			Integer[] field = new Integer[ChessConstants.FIGUREFIELDSIZE];
			field[ChessConstants.YKORD] = y;
			field[ChessConstants.XKORD] = x;
			getFields().add(field);
			y++;
			x++;
		}
	}
	
	public void moveLeftUp(int yKord, int xKord) {
		int y = yKord + 1;
		int x = xKord - 1;
		while(y <= ChessConstants.MAXAXIS && x >= ChessConstants.MINAXIS) {
			Integer[] field = new Integer[ChessConstants.FIGUREFIELDSIZE];
			field[ChessConstants.YKORD] = y;
			field[ChessConstants.XKORD] = x;
			getFields().add(field);
			y++;
			x--;
		}
	}
	
	public void moveRightDown(int yKord, int xKord) {
		int y = yKord - 1;
		int x = xKord + 1;
		while(y >= ChessConstants.MINAXIS && x <= ChessConstants.MAXAXIS) {
			Integer[] field = new Integer[ChessConstants.FIGUREFIELDSIZE];
			field[ChessConstants.YKORD] = y;
			field[ChessConstants.XKORD] = x;
			getFields().add(field);
			y--;
			x++;
		}
	}
	
	public void moveLeftDown(int yKord, int xKord) {
		int y = yKord - 1;
		int x = xKord - 1;
		while(y >= ChessConstants.MINAXIS && x >= ChessConstants.MINAXIS) {
			Integer[] field = new Integer[ChessConstants.FIGUREFIELDSIZE];
			field[ChessConstants.YKORD] = y;
			field[ChessConstants.XKORD] = x;
			getFields().add(field);
			y--;
			x--;
		}
	}
	
	public Figure moveFigure(Figure f, int yKord, int xKord) {
		f.setX(xKord);
		f.setY(yKord);
		return f;
	}

}
