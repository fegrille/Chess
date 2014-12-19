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
		f = new Field();
		king = new King(ChessConstants.MINAXIS,ChessConstants.KINGXKORDS,'w');
		p1 = new Player('w',f);
		p2 = new Player('b',f);
		pf = new ArrayList<Integer[]>();
		right = false;
	}

	@After
	public void tearDown() throws Exception {
		p1 = null;
		p2 = null;
	}

	@Test
	public void testColidateOwnFiguresKing() {
		king.possibleFields();
		cK.colidateOwnFigureKing(king, p1);
		pf = king.getPosFields();
		if(pf.size() == 0) {
			right = true;
		}
		assertTrue(right);
	}

}
