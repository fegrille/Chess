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

public class TestControlColidateKnight {
	
	ControlColidateKnight test;
	Player p1;
	Player p2;
	boolean right;
	Field f;
	List<List<Integer[]>> pf;

	@Before
	public void setUp() throws Exception {
		test = new ControlColidateKnight();
		f = new Field();
		p1 = new Player('w',f);
		p2 = new Player('b',f);
		pf = new ArrayList<>();
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
	public void test() {
		IFigure fig = p1.getFigureList().get(10);
		fig.setField(5, 5);
		p1.getFigureList().get(1).setField(7, 4);
		p1.getFigureList().get(0).setField(7, 6);
		p1.getFigureList().get(2).setField(6, 3);
		p1.getFigureList().get(3).setField(4, 7);
		fig.possibleFields();
		test.colidateOwnFigureKnight(fig, p1);
		if(fig.getPosFields().get(0).isEmpty() && fig.getPosFields().get(1).size() == 2 
				&& fig.getPosFields().get(2).size() == 1 && fig.getPosFields().get(3).size() == 1) {
			right = true;
		}
		assertTrue(right);
	}

}
