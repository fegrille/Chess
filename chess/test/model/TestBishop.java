package model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import model.Bishop;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestBishop {

	Bishop test;
	boolean testright;
	
	@Before
	public void setup() {
		test = new Bishop(1,1,'b');
		testright = false;
		
	}
	
	@Test
	public void testPossibleMoves() {
		List<List<Integer[]>> testfield = new ArrayList<List<Integer[]>>();
		test.possibleFields();
		testfield = test.getPosFields();
		if(testfield.size() == 4) {
			testright = true;
		}
		assertTrue(testright);
	}
	
	@Test
	public void testReturnName() {
		boolean testright = false;
		String name = test.returnName();
		if(name.equals("Bishop")) {
			testright = true;
		}
		assertTrue(testright);
	}
	
	
	@After
	public void tearDown() {
		test = null;
	}

}
