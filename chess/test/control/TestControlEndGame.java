package control;

import static org.junit.Assert.*;
import model.Field;
import model.Figure;
import model.IFigure;
import model.Player;

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
		lastMovedFigure = p2.getFigureList().get(14); //Queen
		lastMovedFigure.possibleFields();
		test.controlWin(p1, p2, col, lastMovedFigure);
		assertEquals(test.getWin(), testWin);
	}
	
	@Test
	//Method for King escape
	public void testCheckPossibleFieldsKingCanMove() {
		lastMovedFigure = p2.getFigureList().get(14); //Queen
		lastMovedFigure.setField(5, 5);
		IFigure k = p1.getFigureList().get(p1.getFigureList().size() - 1);
		k.setField(3, 5);
		col.colidate(p1, p2);
		boolean escape = false;
		test.controlWin(p1, p2, col, lastMovedFigure);
		assertEquals(test.isKingCantMove(), escape);
	}
	
	@Test
	//Method for King escape
	public void testCheckPossibleFieldsKingCantMove() {
		lastMovedFigure = p2.getFigureList().get(14); //Queen
		lastMovedFigure.setField(5, 5);
		IFigure t = p2.getFigureList().get(8);
		t.setField(3, 1);
		IFigure k = p1.getFigureList().get(p1.getFigureList().size() - 1);
		k.setField(4, 5);
		IFigure badP = p2.getFigureList().get(15);
		badP.setField(6, 5);
		col.colidate(p1, p2);
		boolean escape = true;
		test.controlWin(p1, p2, col, lastMovedFigure);
		assertEquals(test.isKingCantMove(), escape);
	}
	
	@Test
	//Method for block Queen, Queen above king
	public void testCheckBlockQueenCanBlockOver() {
		lastMovedFigure = p2.getFigureList().get(14); //Queen
		lastMovedFigure.setField(5, 5);
		IFigure t = p1.getFigureList().get(8);
		t.setField(4, 1);
		IFigure k = p1.getFigureList().get(p1.getFigureList().size() - 1);
		k.setField(3, 5);
		col.colidate(p1, p2);
		boolean escape = false;
		test.controlWin(p1, p2, col, lastMovedFigure);
		assertEquals(test.isCantBlockBadFigure(), escape);
	}
	
	@Test
	//Method for block Queen, Queen Right Up king
	public void testCheckBlockQueenCanBlockRightUp() {
		lastMovedFigure = p2.getFigureList().get(14); //Queen
		lastMovedFigure.setField(5, 7);
		IFigure t = p1.getFigureList().get(8);
		t.setField(4, 1);
		IFigure k = p1.getFigureList().get(p1.getFigureList().size() - 1);
		k.setField(3, 5);
		col.colidate(p1, p2);
		boolean escape = false;
		test.controlWin(p1, p2, col, lastMovedFigure);
		assertEquals(test.isCantBlockBadFigure(), escape);
	}

	
	@Test
	//Method for block Rook
	public void testCheckBlockRookCanBlockAbove() {
		lastMovedFigure = p2.getFigureList().get(8); //Rook
		lastMovedFigure.setField(5, 5);
		IFigure t = p1.getFigureList().get(8);
		t.setField(4, 1);
		IFigure k = p1.getFigureList().get(p1.getFigureList().size() - 1);
		k.setField(3, 5);
		col.colidate(p1, p2);
		boolean escape = false;
		test.controlWin(p1, p2, col, lastMovedFigure);
		assertEquals(test.isCantBlockBadFigure(), escape);
	}
	
	@Test
	//Method for block Rook, Rook left of king
	public void testCheckBlockRookCanBlockLeft() {
		lastMovedFigure = p2.getFigureList().get(8); //Rook
		lastMovedFigure.setField(4, 1);
		IFigure t = p1.getFigureList().get(8);
		t.setField(5, 2);
		IFigure k = p1.getFigureList().get(p1.getFigureList().size() - 1);
		k.setField(4, 5);
		col.colidate(p1, p2);
		boolean escape = false;
		test.controlWin(p1, p2, col, lastMovedFigure);
		assertEquals(test.isCantBlockBadFigure(), escape);
	}
	
	@Test
	//Method for block Rook
	public void testCheckBlockRookCanBlockUnder() {
		lastMovedFigure = p2.getFigureList().get(8); //Rook
		lastMovedFigure.setField(3, 5);
		IFigure t = p1.getFigureList().get(8);
		t.setField(4, 1);
		IFigure k = p1.getFigureList().get(p1.getFigureList().size() - 1);
		k.setField(5, 5);
		col.colidate(p1, p2);
		boolean escape = false;
		test.controlWin(p1, p2, col, lastMovedFigure);
		assertEquals(test.isCantBlockBadFigure(), escape);
	}
	
	@Test
	//Method for block Rook, Rook left of king
	public void testCheckBlockRookCanBlockRight() {
		lastMovedFigure = p2.getFigureList().get(8); //Rook
		lastMovedFigure.setField(4, 5);
		IFigure t = p1.getFigureList().get(8);
		t.setField(5, 2);
		IFigure k = p1.getFigureList().get(p1.getFigureList().size() - 1);
		k.setField(4, 1);
		col.colidate(p1, p2);
		boolean escape = false;
		test.controlWin(p1, p2, col, lastMovedFigure);
		assertEquals(test.isCantBlockBadFigure(), escape);
	}

	@Test
	//Method for block Bishop up Left
	public void testCheckBlockBishopCanBlockUpLeft() {
		lastMovedFigure = p2.getFigureList().get(13); //Bishop
		lastMovedFigure.setField(5, 3);
		IFigure t = p1.getFigureList().get(8);
		t.setField(4, 1);
		IFigure k = p1.getFigureList().get(p1.getFigureList().size() - 1);
		k.setField(3, 5);
		col.colidate(p1, p2);
		boolean escape = false;
		test.controlWin(p1, p2, col, lastMovedFigure);
		assertEquals(test.isCantBlockBadFigure(), escape);
	}
	
	@Test
	//Method for block Bishop up Right
	public void testCheckBlockBishopCanBlockUpRight() {
		lastMovedFigure = p2.getFigureList().get(13); //Bishop
		lastMovedFigure.setField(5, 7);
		IFigure t = p1.getFigureList().get(8);
		t.setField(4, 1);
		IFigure k = p1.getFigureList().get(p1.getFigureList().size() - 1);
		k.setField(3, 5);
		col.colidate(p1, p2);
		boolean escape = false;
		test.controlWin(p1, p2, col, lastMovedFigure);
		assertEquals(test.isCantBlockBadFigure(), escape);
	}
	
	@Test
	//Method for block Bishop down Right
	public void testCheckBlockBishopCanBlockDownRight() {
		lastMovedFigure = p2.getFigureList().get(13); //Bishop
		lastMovedFigure.setField(3, 5);
		IFigure t = p1.getFigureList().get(8);
		t.setField(4, 1);
		IFigure k = p1.getFigureList().get(p1.getFigureList().size() - 1);
		k.setField(5, 3);
		col.colidate(p1, p2);
		boolean escape = false;
		test.controlWin(p1, p2, col, lastMovedFigure);
		assertEquals(test.isCantBlockBadFigure(), escape);
	}
	
	@Test
	//Method for block Bishop
	public void testCheckBlockBishopCanBlockDownLeft() {
		lastMovedFigure = p2.getFigureList().get(13); //Bishop
		lastMovedFigure.setField(3, 3);
		IFigure t = p1.getFigureList().get(8);
		t.setField(4, 1);
		IFigure k = p1.getFigureList().get(p1.getFigureList().size() - 1);
		k.setField(5, 5);
		col.colidate(p1, p2);
		boolean escape = false;
		test.controlWin(p1, p2, col, lastMovedFigure);
		assertEquals(test.isCantBlockBadFigure(), escape);
	}
	
	@Test
	//Method for killing bad Figure
	public void testKillBadFigureCanKill() {
		lastMovedFigure = p2.getFigureList().get(13); //Bishop
		lastMovedFigure.setField(5, 3);
		IFigure t = p1.getFigureList().get(8);
		t.setField(5, 1);
		IFigure k = p1.getFigureList().get(p1.getFigureList().size() - 1);
		k.setField(3, 5);
		col.colidate(p1, p2);
		boolean escape = true;
		test.controlWin(p1, p2, col, lastMovedFigure);
		assertEquals(test.isCanKillBadFigure(), escape);
	}


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
