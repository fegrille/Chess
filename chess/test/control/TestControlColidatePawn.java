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

public class TestControlColidatePawn {

	ControlColidatePawn test;
	Player p1;
	Player p2;
	boolean right;
	Field f;
	IFigure ownPawn;
	List<List<Integer[]>> pf;

	@Before
	public void setUp() throws Exception {
		test = new ControlColidatePawn();
		f = new Field();
		p1 = new Player('w',f);
		p2 = new Player('b',f);
		pf = new ArrayList<List<Integer[]>>();
		right = false;
		ownPawn = new Figure();
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
	public void testOwnFigure() {
		IFigure f = p1.getFigureList().get(2);
		p1.getFigureList().get(3).setField(3, 4);
		p1.getFigureList().get(1).setField(3, 2);
		p1.getFigureList().get(0).setField(3, 3);
		f.possibleFields();
		test.colidateOwnFigurePawn(f, p1);
		if(f.getPosFields().get(0).isEmpty() && f.getPosFields().get(1).isEmpty()) {
			right = true;
		}
		assertTrue(right);
	}
	
	@Test
	public void testOtherFigure() {
		IFigure f = p1.getFigureList().get(2);
		p2.getFigureList().get(3).setField(3, 4);
		p2.getFigureList().get(1).setField(3, 2);
		p2.getFigureList().get(0).setField(3, 3);
		f.possibleFields();
		test.colidateOtherFigurePawn(f, p2);
		if(f.getPosFields().get(0).isEmpty() && f.getPosFields().get(1).size() == 2) {
			right = true;
		}
		assertTrue(right);
	}

}
