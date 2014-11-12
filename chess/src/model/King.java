package model;

import java.util.ArrayList;
import java.util.List;

public class King extends Figure{
	
	public King(int x, int y, char color) {
		setField(x,y);
		setColor(color);
	}
	
	//TODO Find out the possible Field where the Figure can go to
	@Override
	public List<Integer[]> possibleFields() {
		List<Integer[]> fields = new ArrayList<Integer[]>();
		fields.add(addField(getX()+1, getY()));
		
		fields.add(addField(getX()+1,getY()-1));
		
		fields.add(addField(getX(),getY()-1));
		
		fields.add(addField(getX()-1,getY()-1));
		
		fields.add(addField(getX()-1,getY()));
		
		fields.add(addField(getX()-1,getY()+1));
		
		fields.add(addField(getX(),getY()+1));
		
		fields.add(addField(getX()+1,getY()+1));
		
		fields = removeNullFields(fields);
		
		return fields;
	}
	
	private Integer[] addField(int x, int y) {
		Integer[] field = new Integer[ChessConstants.FIGUREFIELDSIZE];
		if(x > ChessConstants.MAXAXIS || x < 1 || y > ChessConstants.MAXAXIS || y < 1) {
			return null;
		}
		field[0] = y;
		field[1] = x;
		return field;
	}
	
	private List<Integer[]> removeNullFields(List<Integer[]> fields) {
		int size = fields.size();
		for(int i = 0; i < size; i++) {
			if(fields.get(i) == null) {
				fields.remove(i);
				i--;
				size = fields.size();
			}
		}
		return fields;
	}

}
