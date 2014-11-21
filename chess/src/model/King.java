package model;

import java.util.ArrayList;
import java.util.List;

public class King extends Figure{
	
	private List<Integer[]> fields;
	private Integer[] field;
	
	public Integer[] returnField() {
		return field;
	}

	public void setField(Integer[] field) {
		this.field = field.clone();
	}

	public List<Integer[]> getFields() {
		return fields;
	}

	public void setFields(List<Integer[]> fields) {
		this.fields = fields;
	}

	public King(int y, int x, char color) {
		setField(y,x);
		setColor(color);
	}
	
	@Override
	public List<Integer[]> possibleFields() {
		setFields(new ArrayList<Integer[]>());
		addField(getX()+1, getY());
		
		addField(getX()+1,getY()-1);
		
		addField(getX(),getY()-1);
		
		addField(getX()-1,getY()-1);
		
		addField(getX()-1,getY());
		
		addField(getX()-1,getY()+1);
		
		addField(getX(),getY()+1);
		
		addField(getX()+1,getY()+1);
		
		removeNullFields();
		
		return getFields();
	}
	
	private void addField(int x, int y) {
		setField(new Integer[ChessConstants.FIGUREFIELDSIZE]);
		if(x > ChessConstants.MAXAXIS || x < 1 || y > ChessConstants.MAXAXIS || y < 1) {
			setField(null);
		} else {
			getField()[0] = y;
			getField()[1] = x;
		}
		getFields().add(returnField());
	}
	
	private void removeNullFields() {
		for(int i = 0; i < getFields().size(); i++) {
			if(getFields().get(i) == null) {
				getFields().remove(i);
				i--;
			}
		}
	}

}
