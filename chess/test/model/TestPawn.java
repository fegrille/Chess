package model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import model.Pawn;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestPawn {
	
	Pawn test;
	boolean testright;
	
	@Before
	public void setup() {
		test = new Pawn(1,1,'w');
		testright = false;
		
	}
	@Test
	public void testGetField() {
		int[] testfield = new int[2];
		int[] position = {1,1};
		test.setField(1, 1);
		testfield = test.getField();
		if(position[0] == testfield[0] && position[1] == position[1]) {
			testright = true;
		}
		assertTrue(testright);
	}
	
	@Test
	public void testGetFirstMove() {
		boolean firstmove = test.getFirstMove();
		assertTrue(firstmove);
	}
	
	@Test
	public void testSetFirstMove() {
		boolean firstmove = false;
		test.setFirstMove(firstmove);
		assertEquals(firstmove, test.getFirstMove());
	}
	
	@Test
	public void testPossibleFieldsFirstMove() {
		test.setFirstMove(true);
		test.possibleFields();
		List<List<Integer[]>> testfield = new ArrayList<List<Integer[]>>();
		testfield = test.getPosFields();
		if(testfield.size() == 2 && testfield.get(0).size() == 2) {
			testright = true;
		}
		assertTrue(testright);
	}
	
	@Test
	public void testPossibleFieldNoFirstMove(){
		test.setFirstMove(false);
		test.possibleFields();
		List<List<Integer[]>> testfield = new ArrayList<List<Integer[]>>();
		testfield = test.getPosFields();
		if(testfield.size() == 2 && testfield.get(0).size() == 1) {
			testright = true;
		}
		assertTrue(testright);
	}
	
	@Test
	public void testNoPossibleFields() {
		test.setFirstMove(false);
		test.setField(8, 8);
		test.possibleFields();
		List<List<Integer[]>> testfield = new ArrayList<List<Integer[]>>();
		testfield = test.getPosFields();
		if(testfield.size() == 2 && testfield.get(0).isEmpty() && testfield.get(1).isEmpty()) {
			testright = true;
		}
		assertTrue(testright);
	}
	
	@Test 
	public void testBlackFirstMove() {
		test.setColor('b');
		test.setField(8, 8);
		test.possibleFields();
		List<List<Integer[]>> testfield = new ArrayList<List<Integer[]>>();
		testfield = test.getPosFields();
		if(testfield.size() == 2 && testfield.get(0).size() == 2) {
			testright = true;
		}
		assertTrue(testright);
	}
	
	@Test
	public void testBlackNoFirstMove() {
		test.setFirstMove(false);
		test.setColor('b');
		test.setField(8, 8);
		test.possibleFields();
		List<List<Integer[]>> testfield = new ArrayList<List<Integer[]>>();
		testfield = test.getPosFields();
		if(testfield.size() == 2 && testfield.get(0).size() == 1) {
			testright = true;
		}
		assertTrue(testright);
	}
	
	@Test
	public void testNoPossibleFieldsBlack() {
		test.setFirstMove(false);
		test.setColor('b');
		test.setField(1, 1);
		test.possibleFields();
		List<List<Integer[]>> testfield = new ArrayList<List<Integer[]>>();
		testfield = test.getPosFields();
		if(testfield.size() == 2 && testfield.get(0).isEmpty() && testfield.get(1).isEmpty()) {
			testright = true;
		}
		assertTrue(testright);
	}
	
	
	
	@Test
	public void testGetColor() {
		if(test.getColor() == 'w') {
			testright = true;
		}
		assertTrue(testright);
	}
	
	@Test
	public void testSetX() {
		test.setX(2);
		if(test.getX() == 2) {
			testright = true;
		}
		assertTrue(testright);
	}
	
	@Test
	public void testSetY() {
		test.setY(2);
		if(test.getY() == 2) {
			testright = true;
		}
		assertTrue(testright);
	}
	
	@Test
	public void testLeftUpFieldBlack() {
		test.setColor('b');
		test.setField(8, 1);
		test.setFirstMove(false);
		test.possibleFields();
		List<List<Integer[]>> testfield = new ArrayList<List<Integer[]>>();
		testfield = test.getPosFields();
		if(testfield.size() == 2  && testfield.get(1).size() == 1) {
			testright = true;
		}
		assertTrue(testright);
	}
	
	@Test
	public void testLeftUpFieldWhite() {
		test.setField(1, 8);
		test.setFirstMove(false);
		test.possibleFields();
		List<List<Integer[]>> testfield = new ArrayList<List<Integer[]>>();
		testfield = test.getPosFields();
		if(testfield.size() == 2 && testfield.get(1).size() == 1) {
			testright = true;
		}
		assertTrue(testright);
	}
	
	@Test
	public void testReturnName() {
		String name = test.returnName();
		if(name.equals("Pawn")) {
			testright = true;
		}
		assertTrue(testright);
	}
	
	@After
	public void tearDown() {
		test = null;
	}
	

}
