package model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import model.King;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestKing {

	King test;
	King test2;
	King test3;
	boolean testright;
	
	@Before
	public void setup() {
		test = new King(1,1,'b');
		test2 = new King(2,2,'b');
		test3 = new King(8,8,'b');
		testright = false;
		
	}
	
	@Test
	public void testPossibleMoves() {
		List<List<Integer[]>> testfield = new ArrayList<>();
		List<List<Integer[]>> testfield2 = new ArrayList<>();
		List<List<Integer[]>> testfield3 = new ArrayList<>();
		test.possibleFields();
		testfield = test.getPosFields();
		test2.possibleFields();
		testfield2 = test2.getPosFields();
		test3.possibleFields();
		testfield3 = test3.getPosFields();
		if(testfield.size() == 8 && testfield2.size() == 8 && testfield3.size() == 8) {
			testright = true;
		}
		assertTrue(testright);
	}
	
	
	@After
	public void tearDown() {
		test = null;
	}

}
