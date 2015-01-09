package model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import model.Rook;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestRook {

	Rook test;
	boolean testright;
	
	@Before
	public void setup() {
		test = new Rook(1,1,'b');
		testright = false;
		
	}
	
	@Test
	public void testPossibleMoves() {
		List<List<Integer[]>> testfield = new ArrayList<List<Integer[]>>();
		test.possibleFields();
		testfield = test.getPosFields();
		if(testfield.size() == 4 && testfield.get(0).size() == 7 && testfield.get(3).size() == 7) {
			testright = true;
		}
		assertTrue(testright);
	}
	
	@Test
	public void testReturnName() {
		boolean testright = false;
		String name = test.returnName();
		if(name.equals("Rook")) {
			testright = true;
		}
		assertTrue(testright);
	}
	
	
	@After
	public void tearDown() {
		test = null;
	}

}
