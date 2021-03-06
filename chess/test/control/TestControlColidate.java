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

import control.ControlColidate;

public class TestControlColidate {
	
	ControlColidate test;
	Player p1;
	Player p2;
	boolean right;
	Field f;
	List<List<Integer[]>> pf;

	@Before
	public void setUp() throws Exception {
		test = new ControlColidate();
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
	public void testUpdatePossibleFields() {
		IFigure f = p1.getFigureList().get(15);
		moveFigures();
		p1.getFigureList().get(3).setField(7, 4);
		p2.getFigureList().get(3).setField(2, 4);
		f.possibleFields();
		test.colidate(p1, p2);
		pf = f.getPosFields();
		right = true;
		for(List<Integer[]> fields : pf) {
			if(!fields.isEmpty()) {
				right = false;
			}
		}
		assertTrue(right);
	}
	
	private void moveFigures() {
		p1.getFigureList().get(0).setField(7, 1);
		p1.getFigureList().get(2).setField(7, 3);
		p1.getFigureList().get(4).setField(7, 5);
		p1.getFigureList().get(6).setField(7, 7);
		p1.getFigureList().get(8).setField(8, 1);
		p1.getFigureList().get(11).setField(8, 7);
		p1.getFigureList().get(12).setField(8, 3);
		p1.getFigureList().get(14).setField(8, 5);
		
		p2.getFigureList().get(0).setField(2, 1);
		p2.getFigureList().get(2).setField(2, 3);
		p2.getFigureList().get(4).setField(2, 5);
		p2.getFigureList().get(6).setField(2, 7);
		p2.getFigureList().get(8).setField(1, 1);
		p2.getFigureList().get(11).setField(1, 7);
		p2.getFigureList().get(12).setField(1, 3);
		p2.getFigureList().get(14).setField(3, 3);
	}

}
