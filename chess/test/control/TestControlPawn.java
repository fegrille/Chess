package control;

import static org.junit.Assert.*;
import model.Bishop;
import model.Figure;
import model.Knight;
import model.Pawn;
import model.Queen;
import model.Rook;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import control.ControlPawn;

public class TestControlPawn {
	
	ControlPawn test;
	Figure testFigure;
	boolean right;

	@Before
	public void setUp() throws Exception {
		test = new ControlPawn();
		testFigure = new Pawn(8,8,'w');
		right = false;
	}

	@After
	public void tearDown() throws Exception {
		test = null;
	}
	
//	@Test
//	public void testCheckEndFieldWhite() {
//		if(test.checkEndfield(testFigure)) {
//			right = true;
//		}
//		assertTrue(right);
//	}
}
