package model;

import java.util.HashMap;
import java.util.Map;

public class Field {
	
	private Map<String, Map<Integer,Figure>> fields = new HashMap<String, Map<Integer,Figure>>();
	
	private String[] letters = {ChessConstants.YKORDA,ChessConstants.YKORDB,ChessConstants.YKORDC,ChessConstants.YKORDD,ChessConstants.YKORDE,ChessConstants.YKORDF,ChessConstants.YKORDG,ChessConstants.YKORDH};
	private Integer[] numbers = {ChessConstants.XKORDONE,ChessConstants.XKORDTWO,ChessConstants.XKORDTHREE,ChessConstants.XKORDFOUR,ChessConstants.XKORDFIVE,ChessConstants.XKORDSIX,ChessConstants.XKORDSEVEN,ChessConstants.XKORDEIGHT};
	private Figure empty = null;
	
	public void buildField() {
		for(int i = 0; i < letters.length; i++) {
			Map<Integer,Figure> field = new HashMap<Integer,Figure>();
			field = initializeXAxis(field);
			fields.put(letters[i], field);
		}
	}
	
	public void initializeField(Figure figure) {
		Integer yKord = figure.getField()[0];
		Integer xKord = figure.getField()[1];
		fields.get(yKord).put(xKord, figure);
	}
	
	public Map<Integer,Figure> initializeXAxis(Map<Integer,Figure> field) {
		for(int a = 0; a < numbers.length; a++) {
			field.put(numbers[a], empty);
		}
		return field;
	}
}
