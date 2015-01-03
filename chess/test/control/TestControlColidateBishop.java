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

public class TestControlColidateBishop {
	
	ControlColidateBishop test;
	Player p1;
	Player p2;
	boolean right;
	Field f;
	List<Integer[]> pf;

	@Before
	public void setUp() throws Exception {
		test = new ControlColidateBishop();
		f = new Field();
		p1 = new Player('w',f);
		p2 = new Player('b',f);
		pf = new ArrayList<Integer[]>();
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
/*
	@Test
	public void testColidateBishop() {
		IFigure f = p1.getFigureList().get(12);
		f.possibleFields();
		test.colidateBishop(f, p1, p2);
		pf = f.getPosFields();
		if(pf.isEmpty()) {
			right = true;
		}
		assertTrue(right);
	}*/

}
