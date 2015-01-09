package model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import model.Queen;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestQueen {

	Queen test;
	Queen test1;
	Queen test2;
	Queen test3;
	boolean testright;
	
	@Before
	public void setup() {
		test = new Queen(1,1,'b');
		test1 = new Queen(1,8,'b');
		test2 = new Queen(8,1,'b');
		test3 = new Queen(8,8,'b');
		testright = false;
		
	}
	
	@Test
	public void testPossibleMoves() {
		List<List<Integer[]>> testfield = new ArrayList<List<Integer[]>>();
		List<List<Integer[]>> testfield1 = new ArrayList<List<Integer[]>>();
		List<List<Integer[]>> testfield2 = new ArrayList<List<Integer[]>>();
		List<List<Integer[]>> testfield3 = new ArrayList<List<Integer[]>>();
		test.possibleFields();
		testfield = test.getPosFields();
		test1.possibleFields();
		testfield1 = test1.getPosFields();
		test2.possibleFields();
		testfield2 = test2.getPosFields();
		test3.possibleFields();
		testfield3 = test3.getPosFields();
		if(testfield.size() == 8 && testfield1.size() == 8 && testfield2.size() == 8 && testfield3.size() == 8) {
			testright = true;
		}
		assertTrue(testright);
	}
	
	
	@After
	public void tearDown() {
		test = null;
	}

}
