package model;

import java.util.HashMap;
import java.util.Map;

public class Field {
	
	private Map<Integer, Map<Integer,Figure>> fields = new HashMap<Integer, Map<Integer,Figure>>();
	
	private Integer[] numbers = {ChessConstants.XKORDONE,ChessConstants.XKORDTWO,ChessConstants.XKORDTHREE,ChessConstants.XKORDFOUR,ChessConstants.XKORDFIVE,ChessConstants.XKORDSIX,ChessConstants.XKORDSEVEN,ChessConstants.XKORDEIGHT};
	private Figure empty = new Figure();
	
	public Map<Integer, Map<Integer,Figure>> getFields() {
		return this.fields;
	}
	
	public void buildField() {
		Map<Integer,Figure> field;
		for(int i = 0; i < numbers.length; i++) {
			field = new HashMap<Integer,Figure>();
			field = initializeXAxis(field);
			getFields().put(numbers[i], field);
		}
	}
	
	public void initializeField(Figure figure) {
		int yKord = figure.getY();
		int xKord = figure.getX();
		System.out.println(this.fields.keySet().toString());
		System.out.println(this.fields.get(yKord).keySet().toString());
		getFields().get(yKord).put(xKord, figure);
	}
	
	public Map<Integer,Figure> initializeXAxis(Map<Integer,Figure> field) {
		for(int a = 0; a < numbers.length; a++) {
			field.put(numbers[a], empty);
		}
		return field;
	}
}
