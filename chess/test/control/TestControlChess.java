package control;

import static org.junit.Assert.*;

import model.Field;
import model.Figure;
import model.IFigure;
import model.Player;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestControlChess {

	private ControlChess controlChess;
	
	private Player p1;
	private Player p2;
	private IFigure lastMovedFigure;
	private ControlColidate col;
	private Field f;

	@Before
	public void setUp() throws Exception {
		controlChess = new ControlChess();
		col = new ControlColidate();
		f = new Field();
		p1 = new Player('w',f);
		p2 = new Player('b',f);
		lastMovedFigure = new Figure();
	}

	@After
	public void tearDown() throws Exception {
		controlChess = null;
		col = null;
		f = null;
		p1 = null;
		p2 = null;
		lastMovedFigure = null;
	}

	@Test
	public void testCheckChess() {
		boolean testChess = true;
		lastMovedFigure = p2.getFigureList().get(14); //Queen
		lastMovedFigure.setField(5, 5);
		p1.getFigureList().get(p1.getFigureList().size() - 1).setField(3, 5);
		col.colidate(p1, p2);
		controlChess.checkChess(p1, lastMovedFigure, col, p2);
		assertEquals(controlChess.isChess(), testChess);
	}

	@Test
	public void testIsChess() {
		controlChess.setChess(true);
		boolean TestChess = controlChess.isChess();
		assertTrue(TestChess);
	}

	@Test
	public void testSetChess() {
		boolean testChess = true;
		controlChess.setChess(true);
		assertEquals(controlChess.isChess(), testChess);
	}

}
