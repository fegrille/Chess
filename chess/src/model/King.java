package model;

import java.util.ArrayList;
import java.util.List;

public class King extends Figure{
	
	private int counter;

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public King(int y, int x, char color) {
		setField(y,x);
		setColor(color);
	}
	
	@Override
	public void possibleFields() {
		setPosFields(new ArrayList<List<Integer[]>>());
		
		addField(getX()+1, getY());
		
		addField(getX()+1,getY()-1);
		
		addField(getX(),getY()-1);
		
		addField(getX()-1,getY()-1);
		
		addField(getX()-1,getY());
		
		addField(getX()-1,getY()+1);
		
		addField(getX(),getY()+1);
		
		addField(getX()+1,getY()+1);
		
		removeNullFields();
	}
	
	private void addField(int x, int y) {
		List<Integer[]> fields = new ArrayList<>();
		Integer[] posField = new Integer[ChessConstants.FIGUREFIELDSIZE];
		if(checkCordinsideAxis(x) || checkCordinsideAxis(y)) {
			posField = null;
		} else {
			posField[0] = y;
			posField[1] = x;
		}
		fields.add(posField);
		getPosFields().add(fields);
	}

	private boolean checkCordinsideAxis(int axis) {
		return axis > ChessConstants.MAXAXIS || axis < ChessConstants.MINAXIS;
	}
	
	private void removeNullFields() {
		for(setCounter(0); getCounter() < getPosFields().size(); setCounter(getCounter() + 1)) {
			removeField();
		}
	}

	private void removeField() {
		if(getPosFields().get(getCounter()) == null) {
			getPosFields().remove(getCounter());
			setCounter(getCounter() - 1);
		}
	}

}
