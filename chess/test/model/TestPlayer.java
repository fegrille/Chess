package model;

import static org.junit.Assert.*;
import model.Field;
import model.Player;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestPlayer {
	
	Player test;
	boolean testright;
	Field f;

	@Before
	public void setUp() throws Exception {
		test = new Player('b');
		testright = false;
		f = new Field();
	}

	@After
	public void tearDown() throws Exception {
		test = null;
	}

	@Test
	public void testInitializeFiguresBlack() {
		f.buildField();
		test.initializeFigures(f);
		if(test.getFigureList().size() == 16) {
			testright = true;
		}
		assertTrue(testright);
	}
	
	@Test
	public void testInitializeFiguresWhite() {
		test.setCol('w');
		f.buildField();
		test.initializeFigures(f);
		if(test.getFigureList().size() == 16) {
			testright = true;
		}
		assertTrue(testright);
		
	}
	
	@Test
	public void testGetColor() {
		test.setCol('w');
		if(test.getCol() == 'w'){
			testright = true;
		}
		assertTrue(testright);
	}
	
	@Test
	public void testSetFigureList() {
		test.setFigureList(null);
		if(test.getFigureList() == null) {
			testright = true;
		}
		assertTrue(testright);
	}

}
