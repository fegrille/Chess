package test;

import static org.junit.Assert.*;

import java.util.List;

import model.Pawn;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestPawn {
	
	Pawn test;
	
	@Before
	public void setup() {
		test = new Pawn();
	}
	@Test
	public void testGetField() {
		int[] testfield = new int[2];
		int[] position = {1,1};
		boolean same = false;
		test.setField(1, 1);
		testfield = test.getField();
		if(position[0] == testfield[0] && position[1] == position[1]) {
			same = true;
		}
		assertTrue(same);
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
		test.setField(1, 1);
		boolean testRight = false;
		List<Integer[]> testList = test.possibleFields();
		Integer[] firstField = testList.get(0);
		Integer[] secondField = testList.get(1);
		int yKord = test.getField()[0];
		if(firstField[0] == yKord + 1 && secondField[0] == yKord + 2) {
			testRight = true;
		}
		assertTrue(testRight);
	}
	
	@Test
	public void testPossibleFieldNoFirstMove(){
		test.setFirstMove(false);
		test.setField(1, 1);
		boolean testRight = false;
		List<Integer[]> testList = test.possibleFields();
		Integer[] firstField = testList.get(0);
		int yKord = test.getField()[0];
		if(firstField[0] == yKord + 1) {
			testRight = true;
		}
		assertTrue(testRight);
	}
	
	@After
	public void tearDown() {
		test = null;
	}
	

}
