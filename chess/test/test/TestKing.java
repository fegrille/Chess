package test;

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
	boolean testright;
	
	@Before
	public void setup() {
		test = new King(1,1,'b');
		test2 = new King(2,2,'b');
		testright = false;
		
	}
	
	@Test
	public void testPossibleMoves() {
		List<Integer[]> testfield = new ArrayList<Integer[]>();
		List<Integer[]> testfield2 = new ArrayList<Integer[]>();
		testfield = test.possibleFields();
		testfield2 = test2.possibleFields();
		if(testfield.size() == 3 && testfield2.size() == 8) {
			testright = true;
		}
		assertTrue(testright);
	}
	
	
	@After
	public void tearDown() {
		test = null;
		testright = false;
	}

}
