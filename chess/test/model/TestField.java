package model;

import model.Field;

import org.junit.After;
import org.junit.Before;

public class TestField {
	
	Field test;
	boolean testright;

	@Before
	public void setUp() {
		test = new Field();
		testright = false;
	}
	
	@After
	public void tearDown() {
		test = null;
	}

}
