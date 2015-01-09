package control;

import static org.junit.Assert.*;
import model.Field;
import model.Figure;
import model.IFigure;
import model.Player;
import model.Queen;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import control.ControlEndGame;

public class TestControlEndGame {
	
	private ControlEndGame test;
	private Player p1;
	private Player p2;
	private IFigure lastMovedFigure;
	private ControlColidate col;
	private Field f;


	@Before
	public void setUp() throws Exception {
		test = new ControlEndGame();
		col = new ControlColidate();
		f = new Field();
		p1 = new Player('w',f);
		p2 = new Player('b',f);
		lastMovedFigure = new Figure();
	}

	@After
	public void tearDown() throws Exception {
		test = null;
		col = null;
		f = null;
		p1 = null;
		p2 = null;
		lastMovedFigure = null;
	}
	
	@Test
	public void testControlWin() {
		boolean testWin = false;
		lastMovedFigure = new Queen(5, 5, 'b');
		lastMovedFigure.possibleFields();
		test.controlWin(p1, p2, col, lastMovedFigure);
		assertEquals(test.getWin(), testWin);
	}
	
	@Test
	//Method for King escape
	public void testCheckPossibleFieldsKingCanMove() {
		lastMovedFigure = new Queen(5, 5, 'b');
		lastMovedFigure.possibleFields();
		p1.getFigureList().get(p1.getFigureList().size() - 1).setField(3, 5);
		p1.getFigureList().get(p1.getFigureList().size() - 1).possibleFields();
		boolean escape = false;
		test.controlWin(p1, p2, col, lastMovedFigure);
		assertEquals(test.isKingCantMove(), escape);
	}
	
	/*@Test
	//Method for King escape
	public void testCheckPossibleFieldsKingCantMove() {
		lastMovedFigure = new Queen(4, 5, 'b');
		lastMovedFigure.possibleFields();
		IFigure k = p1.getFigureList().get(p1.getFigureList().size() - 1);
		k.setField(3, 5);
		k.possibleFields();
		col.colidate(k, p1, p2);
		boolean escape = true;
		test.controlWin(p1, p2, col, lastMovedFigure);
		assertEquals(test.isKingCantMove(), escape);
	}
*/
	@Test
	public void testGetWin() {
		test.setWin(true);
		boolean TestChess = test.getWin();
		assertTrue(TestChess);
	}
	
	@Test
	public void testSetChess() {
		boolean testWin = true;
		test.setWin(true);
		assertEquals(test.getWin(), testWin);
	}

}
