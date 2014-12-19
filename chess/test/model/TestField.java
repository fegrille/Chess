package model;

import model.Field;

import org.junit.After;
import org.junit.Before;

public class TestField {
	
	IField test;
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
