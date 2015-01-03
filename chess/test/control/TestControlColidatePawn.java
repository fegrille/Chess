package control;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.Field;
import model.Figure;
import model.IFigure;
import model.Pawn;
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
	List<Integer[]> pf;

	@Before
	public void setUp() throws Exception {
		test = new ControlColidatePawn();
		f = new Field();
		p1 = new Player('w',f);
		p2 = new Player('b',f);
		pf = new ArrayList<Integer[]>();
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


	/*@Test
	public void testColidateOtherFigurePawn(IFigure f, Player p2) {
		colidateOtherFigurePawn(IFigure f, Player p2)
		setFigureList(p2.getFigureList());
		getColi().setFigureList(getFigureList());
		setFigureList(getColi().getFigureList());
		setFields(f.getPosFields());
		getColi().setFields(getFields());
		checkColidateOther(f);
		f.setPosFields(getFields());
	}
	
	private void checkColidateOther(IFigure f) {
		for(setC1(0); getC1() < getFields().size(); setC1(getC1() + 1)) {
			checkColidateInFrontPawn(f);
		}
	}

	private void checkColidateInFrontPawn(IFigure f) {
		if(fieldInFront(f)) {
			checkColidatePawn(f);
		}
	}

	private boolean fieldInFront(IFigure f) {
		Integer[] firstMov = forColorFirstMove(f);
		Integer[] field = forColor(f);
		Integer[] posField = getFields().get(getC1());
		return Arrays.equals(posField, firstMov) || Arrays.equals(posField, field);
	}

	private Integer[] forColor(IFigure f) {
		Integer[] i = new Integer[2];
		if(f.getColor() == 'b') {
			i[0] = f.getY() - 2;
		} else {
			i[0] = f.getY() + 2;
		}
		i[1] = f.getX();
		return i;
	}

	private Integer[] forColorFirstMove(IFigure f) {
		Integer[] i = new Integer[2];
		if(f.getColor() == 'b') {
			i[0] = f.getY() - 1;
		} else {
			i[0] = f.getY() + 1;
		}
		i[1] = f.getX();
		return i;
	}

	@Test
	public void testColidateOwnFigurePawn() {
		ownPawn = new Pawn(3, 3, 'w');
		
		test.colidateOwnFigurePawn(ownPawn, p1);

	}
	
	private void checkColidationOwn(IFigure f) {
		for(setC1(0); getC1() < getFields().size(); setC1(getC1() + 1)) {
			checkColidatePawn(f);
		}
	}
	
	private void checkColidatePawn(IFigure f) {
		if(getColi().colidate(getFields().get(getC1()))) {
			isBlack(f.getColor());
			isWhite(f.getColor());
		}
	}

	private void isWhite(char color) {
		if(color == 'w') {
			coli.removeUp(getC1(),0);
		}
		
	}

	private void isBlack(char color) {
		if(color == 'b') {
			coli.removeDown(getC1(),0);
		}
	}*/

}
