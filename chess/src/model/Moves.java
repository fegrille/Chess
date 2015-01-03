package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Moves implements IMoves {
	
	private List<Integer[]> fields;
	private List<List<Integer[]>> fieldList;
	private int xKord;
	private int yKord;
	
	/**
	 * 
	 * @return
	 */
	private int getxKord() {
		return xKord;
	}

	/**
	 * 
	 * @param xKord
	 */
	private void setxKord(int xKord) {
		this.xKord = xKord;
	}
	
	/**
	 * 
	 * @return
	 */
	private int getyKord() {
		return yKord;
	}

	/**
	 * 
	 * @param yKord
	 */
	private void setyKord(int yKord) {
		this.yKord = yKord;
	}

	public Moves() {
		fields = new ArrayList<Integer[]>();
	}
	
	public List<Integer[]> getFields() {
		return fields;
	}

	public void setFields(List<Integer[]> fields) {
		this.fields = fields;
	}
	
	public void movesQueen(int yKord, int xKord) {
		setFieldList(new ArrayList<>());
		setyKord(yKord);
		setxKord(xKord);
		moveUpFields();
		moveDownFields();
		moveLeftFields();
		moveRightFields();
		moveRightUp();
		moveRightDown();
		moveLeftUp();
		moveLeftDown();
		
		
	}
	
	public void movesBishop(int yKord, int xKord) {
		setFieldList(new ArrayList<>());
		setyKord(yKord);
		setxKord(xKord);
		moveRightUp();
		moveRightDown();
		moveLeftUp();
		moveLeftDown();
		
		
	}
	
	public void movesRook(int yKord, int xKord) {
		setFieldList(new ArrayList<>());
		setyKord(yKord);
		setxKord(xKord);
		moveUpFields();
		moveDownFields();
		moveLeftFields();
		moveRightFields();
	}
	
	/**
	 * 
	 */
	private void moveUpFields() {
		setFields(new ArrayList<Integer[]>());
		for(int i = (getyKord() + 1); i <= ChessConstants.MAXAXIS; i++) {
			Integer[] field = new Integer[ChessConstants.FIGUREFIELDSIZE];
			field[ChessConstants.YKORD] = i;
			field[ChessConstants.XKORD] = getxKord();
			getFields().add(field);
		}
		getFieldList().add(getFields());
	}
	
	/**
	 * 
	 */
	private void moveDownFields() {
		setFields(new ArrayList<Integer[]>());
		for(int i = (getyKord() - 1); i >= ChessConstants.MINAXIS; i--) {
			Integer[] field = new Integer[ChessConstants.FIGUREFIELDSIZE];
			field[ChessConstants.YKORD] = i;
			field[ChessConstants.XKORD] = getxKord();
			getFields().add(field);
		}
		getFieldList().add(getFields());
	}
	
	/**
	 * 
	 */
	private void moveLeftFields() {
		setFields(new ArrayList<Integer[]>());
		for(int i = (getxKord() - 1); i >= ChessConstants.MINAXIS; i--) {
			Integer[] field = new Integer[ChessConstants.FIGUREFIELDSIZE];
			field[ChessConstants.YKORD] = getyKord();
			field[ChessConstants.XKORD] = i;
			getFields().add(field);
		}
		getFieldList().add(getFields());
	}
	
	/**
	 * 
	 */
	private void moveRightFields() {
		setFields(new ArrayList<Integer[]>());
		for(int i = (getxKord() + 1); i <= ChessConstants.MAXAXIS; i++) {
			Integer[] field = new Integer[ChessConstants.FIGUREFIELDSIZE];
			field[ChessConstants.YKORD] = getyKord();
			field[ChessConstants.XKORD] = i;
			getFields().add(field);
		}
		getFieldList().add(getFields());
	}
	
	/**
	 * 
	 */
	private void moveRightUp() {
		setFields(new ArrayList<Integer[]>());
		int y = getyKord() + 1;
		int x = getxKord() + 1;
		while(isInsideMaxAxis(y, x)) {
			Integer[] field = new Integer[ChessConstants.FIGUREFIELDSIZE];
			field[ChessConstants.YKORD] = y;
			field[ChessConstants.XKORD] = x;
			getFields().add(field);
			y++;
			x++;
		}
		getFieldList().add(getFields());
	}

	/**
	 * @param y
	 * @param x
	 * @return
	 */
	private boolean isInsideMaxAxis(int y, int x) {
		return y <= ChessConstants.MAXAXIS && x <= ChessConstants.MAXAXIS;
	}
	
	/**
	 * 
	 */
	private void moveLeftUp() {
		setFields(new ArrayList<Integer[]>());
		int y = getyKord() + 1;
		int x = getxKord() - 1;
		while(isInsideMaxAndMinAxis(y, x)) {
			Integer[] field = new Integer[ChessConstants.FIGUREFIELDSIZE];
			field[ChessConstants.YKORD] = y;
			field[ChessConstants.XKORD] = x;
			getFields().add(field);
			y++;
			x--;
		}
		getFieldList().add(getFields());
	}

	/**
	 * @param y
	 * @param x
	 * @return
	 */
	private boolean isInsideMaxAndMinAxis(int y, int x) {
		return y <= ChessConstants.MAXAXIS && x >= ChessConstants.MINAXIS;
	}
	
	/**
	 * 
	 */
	private void moveRightDown() {
		setFields(new ArrayList<Integer[]>());
		int y = getyKord() - 1;
		int x = getxKord() + 1;
		while(isInsideMinAndMaxAxis(y, x)) {
			Integer[] field = new Integer[ChessConstants.FIGUREFIELDSIZE];
			field[ChessConstants.YKORD] = y;
			field[ChessConstants.XKORD] = x;
			getFields().add(field);
			y--;
			x++;
		}
		getFieldList().add(getFields());
		
	}

	/**
	 * @param y
	 * @param x
	 * @return
	 */
	private boolean isInsideMinAndMaxAxis(int y, int x) {
		return y >= ChessConstants.MINAXIS && x <= ChessConstants.MAXAXIS;
	}
	
	/**
	 * 
	 */
	private void moveLeftDown() {
		setFields(new ArrayList<Integer[]>());
		int y = getyKord() - 1;
		int x = getxKord() - 1;
		while(isInsideMinAxis(y, x)) {
			Integer[] field = new Integer[ChessConstants.FIGUREFIELDSIZE];
			field[ChessConstants.YKORD] = y;
			field[ChessConstants.XKORD] = x;
			getFields().add(field);
			y--;
			x--;
		}
		getFieldList().add(getFields());
	}

	/**
	 * @param y
	 * @param x
	 * @return
	 */
	private boolean isInsideMinAxis(int y, int x) {
		return y >= ChessConstants.MINAXIS && x >= ChessConstants.MINAXIS;
	}
	
	public void moveFigure(IFigure f, int yKord, int xKord) {
		f.setX(xKord);
		f.setY(yKord);
	}

	public List<List<Integer[]>> getFieldList() {
		return fieldList;
	}

	public void setFieldList(List<List<Integer[]>> fieldList) {
		this.fieldList = fieldList;
	}

}
