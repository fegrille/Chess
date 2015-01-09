package control;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import model.Field;
import model.Figure;
import model.IFigure;
import model.Player;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestControlColidateRook {
	
	Player p1;
	Player p2;
	Figure king;
	ControlColidateRook ck;
	boolean right;
	Field f;
	List<List<Integer[]>> pf;

	@Before
	public void setUp() throws Exception {
		ck = new ControlColidateRook();
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
		f = null;
	}

	@Test
	public void test() {
		IFigure r = p1.getFigureList().get(8);
		r.setField(5, 5);
		p2.getFigureList().get(15).setField(3, 5);
		r.possibleFields();
		ck.colidateRook(r, p1, p2);
		pf = r.getPosFields();
		if(pf.get(0).size() == 2 && pf.get(1).size() == 2 && pf.get(2).size() == 4 && pf.get(3).size() == 3) {
			right = true;
		}
		assertTrue(right);
	}

}
