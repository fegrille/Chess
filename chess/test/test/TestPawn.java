package test;

import static org.junit.Assert.*;

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
		List<Integer[]> testList = test.possibleFields();
		Integer[] firstField = testList.get(0);
		Integer[] secondField = testList.get(1);
		int yKord = test.getField()[0];
		if(firstField[0] == yKord + 1 && secondField[0] == yKord + 2) {
			testright = true;
		}
		assertTrue(testright);
	}
	
	@Test
	public void testPossibleFieldNoFirstMove(){
		test.setFirstMove(false);
		List<Integer[]> testList = test.possibleFields();
		Integer[] firstField = testList.get(0);
		int yKord = test.getField()[0];
		if(firstField[0] == yKord + 1) {
			testright = true;
		}
		assertTrue(testright);
	}
	
	@Test
	public void testNoPossibleFields() {
		test.setFirstMove(false);
		test.setField(8, 8);
		List<Integer[]> testList = test.possibleFields();
		if(testList.isEmpty()) {
			testright = true;
		}
		assertTrue(testright);
	}
	
	@Test 
	public void testPossibleFieldsBlack() {
		test.setColor('b');
		test.setField(8, 8);
		List<Integer[]> testList = test.possibleFields();
		Integer[] firstField = testList.get(0);
		Integer[] secondField = testList.get(1);
		int yKord = test.getField()[0];
		if(firstField[0] == yKord - 1 && secondField[0] == yKord - 2) {
			testright = true;
		}
		assertTrue(testright);
	}
	
	@Test
	public void testNoPossibleFieldsBlack() {
		test.setFirstMove(false);
		test.setColor('b');
		test.setField(1, 1);
		List<Integer[]> testList = test.possibleFields();
		if(testList.isEmpty()) {
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
	
	@After
	public void tearDown() {
		test = null;
	}
	

}
