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
//	
//	@Test
//	public void testCheckNoEndFieldWhite() {
//		testFigure.setField(1, 1);
//		if(!test.checkEndfield(testFigure)) {
//			right = true;
//		}
//		assertTrue(right);
//	}
//	
//	@Test
//	public void testCheckEndFieldBlack() {
//		testFigure.setField(1, 1);
//		testFigure.setColor('b');
//		if(test.checkEndfield(testFigure)) {
//			right = true;
//		}
//		assertTrue(right);
//	}
//	
//	@Test
//	public void testCheckNoEndFieldBlack() {
//		testFigure.setColor('b');
//		if(!test.checkEndfield(testFigure)) {
//			right = true;
//		}
//		assertTrue(right);
//	}
	
//	@Test
//	public void testChangeFigureBishop() {
//		testFigure = test.changeFigure("Bishop");
//		if(testFigure instanceof Bishop) {
//			right = true;
//		}
//		assertTrue(right);
//	}
//	
//	@Test
//	public void testChangeFigureKnight() {
//		testFigure = test.changeFigure("Knight");
//		if(testFigure instanceof Knight) {
//			right = true;
//		}
//		assertTrue(right);
//	}
//	
//	@Test
//	public void testChangeFigureQueen() {
//		testFigure = test.changeFigure("Queen");
//		if(testFigure instanceof Queen) {
//			right = true;
//		}
//		assertTrue(right);
//	}
//	
//	@Test
//	public void testChangeFigureRook() {
//		testFigure = test.changeFigure("Rook");
//		if(testFigure instanceof Rook) {
//			right = true;
//		}
//		assertTrue(right);
//	}
	
	

}
