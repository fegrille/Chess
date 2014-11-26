package model;

import static org.junit.Assert.*;
import model.Figure;
import model.Moves;
import model.Pawn;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestMoves {
	
	Moves test;
	boolean testright;

	@Before
	public void setUp() throws Exception {
		test = new Moves();
		testright = false;
	}

	@Test
	public void testMoveFigure() {
		Figure testFigure = new Pawn(1,1,'w');
		testFigure = test.moveFigure(testFigure, 2, 2);
		if(testFigure.getField()[0] == 2 && testFigure.getField()[1] == 2) {
			testright = true;
		}
		assertTrue(testright);
	}
	
	
	
	@After
	public void tearDown() {
		test = null;
	}

}
