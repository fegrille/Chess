package model;

import java.util.List;

public interface Figure {
	
	public List<Integer[]> possibleFields();
	
	public int[] getField();
	
	public void setField(int xKord, int yKord);

}
