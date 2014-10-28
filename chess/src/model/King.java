package model;

import java.util.ArrayList;
import java.util.List;

public class King implements Figure{

	int x;
	int y;
	
	//TODO Find out the possible Field where the Figure can go to
	@Override
	public List<Integer[]> possibleFields() {
		List<Integer[]> fields = new ArrayList<Integer[]>();
		fields.add(addField(x+1, y));
		
		fields.add(addField(x+1,y-1));
		
		fields.add(addField(x,y-1));
		
		fields.add(addField(x-1,y-1));
		
		fields.add(addField(x-1,y));
		
		fields.add(addField(x-1,y+1));
		
		fields.add(addField(x,y+1));
		
		fields.add(addField(x+1,y+1));
		
		return fields;
	}

	@Override
	public int[] getField() {
		int[] field = new int[2];
		field[1] = y;
		field[2] = x;
		return field;
	}

	@Override
	public void setField(int xKord, int yKord) {
		x = xKord;
		y = yKord;
	}
	
	private Integer[] addField(int x, int y) {
		Integer[] field = new Integer[2];
		if(x > 8 || x < 1 || y > 8 || y < 1) {
			return null;
		}
		field[1] = this.y;
		field[2] = this.x;
		return field;
	}

}
