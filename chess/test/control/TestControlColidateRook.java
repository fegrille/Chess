package control;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import model.Field;
import model.Figure;
import model.Player;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestControlColidateRook {
	
	Player p1;
	Player p2;
	Figure king;
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
		f = null;
	}

	@Test
	public void test() {
		
	}

}
