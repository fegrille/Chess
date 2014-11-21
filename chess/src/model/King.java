package model;

import java.util.ArrayList;
import java.util.List;

public class King extends Figure{
	
	private List<Integer[]> fields;
	private int counter;

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
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
		Integer[] posField = new Integer[ChessConstants.FIGUREFIELDSIZE];
		if(x > ChessConstants.MAXAXIS || x < 1 || y > ChessConstants.MAXAXIS || y < 1) {
			posField = null;
		} else {
			posField[0] = y;
			posField[1] = x;
		}
		getFields().add(posField);
	}
	
	private void removeNullFields() {
		for(setCounter(0); getCounter() < getFields().size(); setCounter(getCounter() + 1)) {
			removeField();
		}
	}

	private void removeField() {
		if(getFields().get(getCounter()) == null) {
			getFields().remove(getCounter());
			setCounter(getCounter() - 1);
		}
	}

}
