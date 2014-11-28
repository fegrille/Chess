package control;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import model.ChessConstants;
import model.Field;
import model.Figure;
import model.King;
import model.Player;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestControlColidateKing {
	
	Player p1;
	Player p2;
	Figure king;
	ControlColidateKing cK;
	boolean right;
	Field f;
	List<Integer[]> pf;

	@Before
	public void setUp() throws Exception {
		cK = new ControlColidateKing();
		king = new King(ChessConstants.MINAXIS,ChessConstants.KINGXKORDS,'w');
		p1 = new Player('w');
		p2 = new Player('b');
		f = new Field();
		pf = new ArrayList<Integer[]>();
		f.buildField();
		p1.initializeFigures(f);
		p2.initializeFigures(f);
		right = false;
	}

	@After
	public void tearDown() throws Exception {
		p1 = null;
		p2 = null;
	}

	@Test
	public void testColidateOwnFiguresKing() {
		pf = king.possibleFields();
		pf = cK.colidateOwnFigureKing(king, pf, p1);
		if(pf.size() == 0) {
			right = true;
		}
		assertTrue(right);
	}

}
