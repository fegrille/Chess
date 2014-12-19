package model;

import java.util.HashMap;
import java.util.Map;

public class Field implements IField{
	
	private Map<Integer, Map<Integer, IFigure>> fields = new HashMap<Integer, Map<Integer,IFigure>>();
	
	private Integer[] numbers = {ChessConstants.XKORDONE,ChessConstants.XKORDTWO,ChessConstants.XKORDTHREE,ChessConstants.XKORDFOUR,ChessConstants.XKORDFIVE,ChessConstants.XKORDSIX,ChessConstants.XKORDSEVEN,ChessConstants.XKORDEIGHT};
	private Figure empty = new Figure();
	
	public Field () {
		buildField();
	}
	
	public Map<Integer, Map<Integer,IFigure>> getFields() {
		return this.fields;
	}
	
	private void buildField() {
		Map<Integer,IFigure> field;
		for(int i = 0; i < numbers.length; i++) {
			field = new HashMap<Integer,IFigure>();
			field = initializeXAxis(field);
			getFields().put(numbers[i], field);
		}
	}
	
	public void initializeField(IFigure figure) {
		int yKord = figure.getY();
		int xKord = figure.getX();
		getFields().get(yKord).put(xKord, figure);
	}
	
	private Map<Integer,IFigure> initializeXAxis(Map<Integer,IFigure> field) {
		for(int a = 0; a < numbers.length; a++) {
			field.put(numbers[a], empty);
		}
		return field;
	}
}
