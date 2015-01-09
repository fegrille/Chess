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

public class TestControlColidateQueen {
	
	ControlColidateQueen test;
	Player p1;
	Player p2;
	boolean right;
	Field f;
	List<List<Integer[]>> pf;

	@Before
	public void setUp() throws Exception {
		test = new ControlColidateQueen();
		f = new Field();
		p1 = new Player('w',f);
		p2 = new Player('b',f);
		pf = new ArrayList<List<Integer[]>>();
		right = false;
	}

	@After
	public void tearDown() throws Exception {
		test = null;
		p1 = null;
		p2 = null;
		pf = null;
		f = null;
	}

	@Test
	public void testColidationQueen() {
		p1.getFigureList().get(14).setField(5, 5);
		IFigure fig = p1.getFigureList().get(14);
		fig.possibleFields();
		test.colidateQueen(fig, p1, p2);
		pf = fig.getPosFields();
		if(pf.get(0).size() == 2 && pf.get(1).size() == 2 && pf.get(2).size() == 4 && pf.get(3).size() == 3 
				&& pf.get(4).size() == 2 && pf.get(5).size() == 2 && pf.get(6).size() == 2 && pf.get(7).size() == 2) {
			right = true;
		}
		assertTrue(right);
	}

}
