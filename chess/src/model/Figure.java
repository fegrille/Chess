package model;

import java.util.List;

public class Figure {
	
	int x;
	int y;
	char color;
	
	public List<Integer[]> possibleFields() {
		return null;
	}
	
	public int[] getField() {
		int[] field = new int[2];
		field[0] = this.y;
		field[1] = this.x;
		return field;
	}

	public void setField(int xKord, int yKord) {
		x = xKord;
		y = yKord;
	}
	
	public void setColor(char c) {
		this.color = c;
	}
	
	public char getColor() {
		return this.color;
	}

}
