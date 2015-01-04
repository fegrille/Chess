package control;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import model.Field;
import model.IFigure;
import model.Player;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestControlColidateKing {
	
	Player p1;
	Player p2;
	ControlColidateKing cK;
	boolean right;
	Field f;
	List<List<Integer[]>> pf;

	@Before
	public void setUp() throws Exception {
		cK = new ControlColidateKing();
		f = new Field();
		p1 = new Player('w',f);
		p2 = new Player('b',f);
		pf = new ArrayList<List<Integer[]>>();
		right = false;
	}

	@After
	public void tearDown() throws Exception {
		p1 = null;
		p2 = null;
	}

	@Test
	public void testColidateOwnFiguresKing() {
		IFigure king = p1.getFigureList().get(15);
		king.possibleFields();
		cK.colidateOwnFigureKing(king, p1);
		pf = king.getPosFields();
		right = true;
		for(int i = 0; i < pf.size(); i++) {
			if(pf.get(i).size() != 0) {
				right = false;
			}
		}
		assertTrue(right);
	}

}
