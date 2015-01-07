package model;

import java.util.List;

public class Figure implements IFigure{
	
	private int x;
	private int y;
	private List<List<Integer[]>> posFields;
	private char color;
	
	public void possibleFields() {
		setPosFields(null);
	}
	
	public int[] getField() {
		int[] field = new int[2];
		field[0] = getY();
		field[1] = getX();
		return field;
	}
	
	public void setField(int yKord, int xKord) {
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

	public List<List<Integer[]>> getPosFields() {
		return posFields;
	}

	public void setPosFields(List<List<Integer[]>> posFields) {
		this.posFields = posFields;
	}
	
	public String returnName() {
		return "";
	}
}
