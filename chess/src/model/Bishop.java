package model;

import java.util.List;

//Läufer
public class Bishop extends Figure{
	
	public Bishop(int x, int y, char color) {
		setField(x,y);
		setColor(color);
	}
	
	//TODO Find out the possible Field where the Figure can go to
	@Override
	public List<Integer[]> possibleFields() {
		return null;
		
		
	}

}
