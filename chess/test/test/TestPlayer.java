package test;

import static org.junit.Assert.*;
import model.Player;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestPlayer {
	
	Player test;
	boolean testright;

	@Before
	public void setUp() throws Exception {
		test = new Player('b');
		testright = false;
	}

	@After
	public void tearDown() throws Exception {
		test = null;
	}

	@Test
	public void testInitializeFigures() {
		test.initializeFigures();
		if(test.getFigureList().size() == 16) {
			testright = true;
		}
		assertTrue(testright);
	}

}
