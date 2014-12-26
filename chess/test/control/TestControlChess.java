package control;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import model.ChessConstants;
import model.Field;
import model.Figure;
import model.IFigure;
import model.King;
import model.Player;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestControlChess {

	private ControlChess controlChess;
	private boolean chess;
	private int[] kingField = {1,1};

	@Before
	public void setUp() throws Exception {
		controlChess = new ControlChess();
		chess = false;
	}

	@After
	public void tearDown() throws Exception {

	}

	@Test
	public void testCheckChess() {
	
	}

	@Test
	private void testGetKingField(Player p) {

	}

	@Test
	private void testCheckFigures(IFigure lastMovedFigure, ControlColidate col, Player p, Player p2) {

	}

	@Test
	private void testCompareField() {

	}

	@Test
	private void testGetKingField() {

	}

	@Test
	private void testSetKingField() {
		int[] testKingField = {1,1};
		//controlChess.setK
	}

	@Test
	public void testIsChess() {
		controlChess.setChess(true);
		boolean TestChess = controlChess.isChess();
		assertTrue(TestChess);
		
	}

	@Test
	public void testSetChess() {
		boolean TestChess = true;
		controlChess.setChess(true);
		assertEquals(controlChess.isChess(), TestChess);
	}

}
