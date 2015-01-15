package control;

import java.util.List;

import com.google.inject.Guice;
import com.google.inject.Injector;

import model.IFigure;
import model.King;
import model.Pawn;
import model.Player;
/**
 * 
 * @author Felix
 *
 */
public class ControlColidateKing implements IControlColidateKing{
	
	private Injector inj = Guice.createInjector(new ControlModule());
	private ColidatingFields coli;
	private List<IFigure> figureList;
	private List<List<Integer[]>> possibleFields;
	private List<List<Integer[]>> possibleFields2;
	private boolean blocked = false;
	private int c;
	
	public ControlColidateKing() {
		coli = inj.getInstance(ColidatingFields.class);
	}
	
	/**
	 * 
	 * @return
	 */
	public int getC() {
		return c;
	}

	/**
	 * 
	 * @param counterFields
	 */
	public void setC(int counterFields) {
		this.c = counterFields;
	}

	/**
	 * 
	 * @return
	 */
	public List<List<Integer[]>> getPossibleFields2() {
		return possibleFields2;
	}

	/**
	 * 
	 * @param possibleFields
	 */
	public void setPossibleFields2(List<List<Integer[]>> possibleFields) {
		this.possibleFields2 = possibleFields;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean isBlocked() {
		return blocked;
	}
	
	/**
	 * 
	 * @param blocked
	 */
	public void setBlocked(boolean blocked) {
		this.blocked = blocked;
	}
	
	/**
	 * 
	 * @return
	 */
	public ColidatingFields getColi() {
		return coli;
	}
	
	/**
	 * 
	 * @return
	 */
	public List<IFigure> getFigureList() {
		return figureList;
	}

	/**
	 * 
	 * @param figureList
	 */
	public void setFigureList(List<IFigure> figureList) {
		this.figureList = figureList;
	}
	
	/**
	 * 
	 * @return
	 */
	public List<List<Integer[]>> getPossibleFields() {
		return possibleFields;
	}

	/**
	 * 
	 * @param possibleFields
	 */
	public void setPossibleFields(List<List<Integer[]>> possibleFields) {
		this.possibleFields = possibleFields;
	}
	
	/**
	 * 
	 * @param f
	 * @param p
	 */
	@Override
	public void colidateOwnFigureKing(IFigure f, Player p) {
		setFigureList(p.getFigureList());
		getColi().setFigureList(getFigureList());
		getColi().unmovedFigures(f);
		setPossibleFields(f.getPosFields());
		checkColidateOwn();
		f.setPosFields(getPossibleFields());
	}
	
	/**
	 * 
	 */
	private void checkColidateOwn() {
		for(int i = 0; i < getPossibleFields().size(); i++) {
			checkFieldsOwn(i);
		}
	}

	/**
	 * 
	 * @param i
	 */
	private void checkFieldsOwn(int i) {
		for(setC(0); getC() < getPossibleFields().get(i).size(); setC(getC() + 1)) {
			checkForNullOwn(i, getC());
		}
	}

	/**
	 * 
	 * @param i
	 * @param j
	 */
	private void checkForNullOwn(int i, int j) {
		if(getPossibleFields().get(i).get(j) != null) {
			checkColidateOwnFigureKing(i , j);
		} else {
			getPossibleFields().get(i).remove(j);
			setC(getC() - 1);
		}
	}
	
	/**
	 * 
	 * @param i
	 * @param j
	 */
	private void checkColidateOwnFigureKing(int i, int j) {
		if(getColi().colidate(getPossibleFields().get(i).get(j))) {
			getPossibleFields().get(i).remove(j);
			setC(getC() - 1);
		}
	}
	
	/**
	 * 
	 * @param f
	 * @param p
	 */
	@Override
	public void colidateOtherFigureKing(IFigure f, Player p) {
		setFigureList(p.getFigureList());
		getColi().setFigureList(getFigureList());
		setPossibleFields(f.getPosFields());
		checkColidateOther(p);
		f.setPosFields(getPossibleFields());
	}
	
	/**
	 * 
	 * @param p
	 */
	private void checkColidateOther(Player p) {
		for(int a = 0; a < getPossibleFields().size(); a++) {
			checkFieldsOther(p, a);
		}
	}

	/**
	 * 
	 * @param p
	 * @param a
	 */
	private void checkFieldsOther(Player p, int a) {
		for(setC(0); getC() < getPossibleFields().get(a).size(); setC(getC() + 1)){
			blockedField(p,a,getC());
		}
	}

	/**
	 * 
	 * @param p
	 * @param a
	 * @param t
	 */
	private void blockedField(Player p, int a, int t) {
		setBlocked(false);
		isFieldBlocked(p,getPossibleFields().get(a).get(t)[0], getPossibleFields().get(a).get(t)[1]);
		if(isBlocked()) {
			getPossibleFields().get(a).remove(getC());
			setC(getC() - 1);
		}
	}
	
	/**
	 * 
	 * @param p
	 * @param y
	 * @param x
	 */
	private void isFieldBlocked(Player p, int y, int x) {
		for(int i = 0; i < p.getFigureList().size(); i++) {
			IFigure f = p.getFigureList().get(i);
			checkForKing(y,x,f);
		}
	}

	/**
	 * 
	 * @param y
	 * @param x
	 * @param f
	 */
	private void checkForKing(int y, int x, IFigure f) {
		if(f instanceof King) {
			checkFigureType(y, x, f);
		} else {
			f.possibleFields();
			checkFigureType(y, x, f);
		}
		
	}

	/**
	 * 
	 * @param y
	 * @param x
	 * @param f
	 */
	private void checkFigureType(int y, int x, IFigure f) {
		if(f instanceof Pawn) {
			isFieldBlockedByPawn(f,y,x);
		} else {
			setPossibleFields2(f.getPosFields());
			isAPossibleField(y,x);
		}
	}
	
	/**
	 * 
	 * @param f
	 * @param y
	 * @param x
	 */
	private void isFieldBlockedByPawn(IFigure f, int y, int x) {
		setPossibleFields2(f.getPosFields());
		for(int i = 0; i < getPossibleFields2().get(1).size(); i++) {
			checkBlock(getPossibleFields2().get(1).get(i),y, x);
		}
	}

	/**
	 * 
	 * @param y
	 * @param x
	 */
	private void isAPossibleField(int y, int x) {
		for(int i = 0; i < getPossibleFields2().size(); i++) {
			getFieldForCheckBlock(y, x, i);
		}
	}

	/**
	 * 
	 * @param y
	 * @param x
	 * @param i
	 */
	private void getFieldForCheckBlock(int y, int x, int i) {
		for(int b = 0; b < getPossibleFields2().get(i).size(); b++) {
			checkBlock(getPossibleFields2().get(i).get(b), y, x);
		}
	}
	
	/**
	 * 
	 * @param pf
	 * @param y
	 * @param x
	 */
	private void checkBlock(Integer[] pf, int y, int x) {
		if(pf != null && pf[0] == y && pf[1] == x) {
			setBlocked(true);
		}
	}
}
