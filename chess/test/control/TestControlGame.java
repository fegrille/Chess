package control;

import static org.junit.Assert.*;
import model.Field;
import model.Figure;
import model.IFigure;
import model.Player;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestControlGame {
	
	private ControlGame test;
	private Player p1;
	private Player p2;
	private IFigure lastMovedFigure;
	private ControlColidate col;
	private Field f;


	@Before
	public void setUp() throws Exception {
		test = new ControlGame();
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
	public void testGameHandling() {
		boolean testWin = false;
		lastMovedFigure = p2.getFigureList().get(14); //Queen
		lastMovedFigure.possibleFields();
		
		//assertEquals(test);
	}

	@Test
	public void testCheckFigure() {
		
	}

}
