package model;

import static org.junit.Assert.*;
import model.Figure;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestFigure {
	
	IFigure test;

	@Before
	public void setUp() {
		test = new Figure();
		test.setColor('w');
	}
	@Test
	public void testPossibleField() {
		boolean right = false;
		test.possibleFields();
		if(test.getPosFields() == null) {
			right = true;
		}
		assertTrue(right);
	}
	
	@Test
	public void testReturnName() {
		boolean testright = false;
		String name = test.returnName();
		if(name.equals("")) {
			testright = true;
		}
		assertTrue(testright);
	}
	
	@After
	public void tearDown() {
		test = null;
	}

}
