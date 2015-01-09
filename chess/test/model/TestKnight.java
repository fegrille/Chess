package model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import model.Knight;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestKnight {

	Knight test;
	Knight test1;
	Knight test2;
	Knight test3;
	boolean testright;
	
	@Before
	public void setup() {
		test = new Knight(1,1,'b');
		test1 = new Knight(1,8,'b');
		test2 = new Knight(8,1,'b');
		test3 = new Knight(8,8,'b');
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
		if(testfield.get(0).size() == 1 && testfield.get(3).size() == 1 && testfield1.get(0).size() == 1 && testfield1.get(2).size() == 1 
				&& testfield2.get(1).size() == 1 && testfield2.get(3).size() == 1 && testfield3.get(1).size() == 1 && testfield3.get(2).size() == 1) {
			testright = true;
		}
		assertTrue(testright);
	}
	
	
	@After
	public void tearDown() {
		test = null;
	}

}
