package model;

import static org.junit.Assert.*;
import model.Field;
import model.Player;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestPlayer {
	
	IPlayer test;
	IPlayer test2;
	boolean testright;
	IField f;

	@Before
	public void setUp() throws Exception {
		f = new Field();
		test = new Player('b',f);
		test2 = new Player('w', f);
		testright = false;
		
	}

	@After
	public void tearDown() throws Exception {
		test = null;
	}

	@Test
	public void testInitializeFiguresBlack() {
		if(test.getFigureList().size() == 16) {
			testright = true;
		}
		assertTrue(testright);
	}
	
	@Test
	public void testInitializeFiguresWhite() {
		if(test2.getFigureList().size() == 16) {
			testright = true;
		}
		assertTrue(testright);
		
	}
	
	@Test
	public void testGetColor() {
		if(test.getCol() == 'b'){
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
