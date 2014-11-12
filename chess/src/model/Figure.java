package model;

import java.util.List;

public class Figure {
	
	private int x;
	private int y;
	private char color;
	
	public List<Integer[]> possibleFields() {
		return null;
	}
	
	public int[] getField() {
		int[] field = new int[2];
		field[0] = getY();
		field[1] = getX();
		return field;
	}
	
	public void setField(int xKord, int yKord) {
		setX(xKord);
		setY(yKord);
	}
	
	public void setColor(char c) {
		this.color = c;
	}
	
	public char getColor() {
		return this.color;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}
	

	public void setY(int y) {
		this.y = y;
	}
}
