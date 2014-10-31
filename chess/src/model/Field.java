package model;

import java.util.HashMap;
import java.util.Map;

public class Field {
	
	public Map<String, Map<Integer,String>> fields = new HashMap<>();
	
	// TODO list with "A","B","C","D","E","F","G","H"
	String[] letters = new String[8];
	// TODO list with 1,2,3,4,5,6,7,8
	Integer[] numbers = new Integer[8];
	String black = "b";
	String white = "w";
	String empty = null;
	
	//TODO For loop for the letters and a for loop with numbers for every letter - all fields are empty
	// then use initializeFields to set the start fields to black or white
	public void buildField() {
		
	}
	
	//TODO Sets the black and white start fields with the specific string
	// A [1-8] and B [1-8] for white and G [1-8] and H [1-8] for black
	public void initializeFields() {
		
	}

}
