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
		List<Integer[]> testfield = new ArrayList<Integer[]>();
		List<Integer[]> testfield1 = new ArrayList<Integer[]>();
		List<Integer[]> testfield2 = new ArrayList<Integer[]>();
		List<Integer[]> testfield3 = new ArrayList<Integer[]>();
		test.possibleFields();
		testfield = test.getPosFields();
		test1.possibleFields();
		testfield1 = test1.getPosFields();
		test2.possibleFields();
		testfield2 = test2.getPosFields();
		test3.possibleFields();
		testfield3 = test3.getPosFields();
		if(testfield.size() == 2 && testfield1.size() == 2 && testfield2.size() == 2 && testfield3.size() == 2) {
			testright = true;
		}
		assertTrue(testright);
	}
	
	
	@After
	public void tearDown() {
		test = null;
	}

}
