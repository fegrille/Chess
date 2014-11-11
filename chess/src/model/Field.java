package model;

import java.util.HashMap;
import java.util.Map;

public class Field {
	
	public Map<String, Map<Integer,Figure>> fields = new HashMap<String, Map<Integer,Figure>>();
	
	String[] letters = {"A","B","C","D","E","F","G","H"};
	Integer[] numbers = {1,2,3,4,5,6,7,8};
	Figure empty = null;
	
	public void buildField() {
		for(int i = 0; i < letters.length; i++) {
			Map<Integer,Figure> field = new HashMap<Integer,Figure>();
			for(int a = 0; a < numbers.length; a++) {
				field.put(numbers[a], empty);
			}
			fields.put(letters[i], field);
		}
	}
	
	public void initializeField(Figure figure) {
		Integer yKord = figure.getField()[0];
		Integer xKord = figure.getField()[1];
		fields.get(yKord).replace(xKord, empty, figure);
	}
}
