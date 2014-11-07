package test;

import static org.junit.Assert.*;
import model.Figure;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FigureTest {
	
	Figure test;

	@Before
	public void setUp() {
		test = new Figure();
	}
	@Test
	public void testPossibleField() {
		boolean right = false;
		if(test.possibleFields() == null) {
			right = true;
		}
		assertTrue(right);
	}
	
	@After
	public void tearDown() {
		test = null;
	}

}
