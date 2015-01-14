package control;

import java.util.List;

import model.IFigure;
import model.Player;

/**
 * 
 * @author Felix
 *
 */
public class ControlColidateKnight {
	
	private ColidatingFields coli = new ColidatingFields();
	private List<List<Integer[]>> fields;
	private List<IFigure> figureList;
	private int c;
	
	/**
	 * 
	 * @return
	 */
	public int getC() {
		return c;
	}

	/**
	 * 
	 * @param counter
	 */
	public void setC(int counter) {
		this.c = counter;
	}

	/**
	 * 
	 * @return
	 */
	public List<List<Integer[]>> getFields() {
		return fields;
	}

	/**
	 * 
	 * @param fields
	 */
	public void setFields(List<List<Integer[]>> fields) {
		this.fields = fields;
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
	public ColidatingFields getColi() {
		return coli;
	}

	/**
	 * 
	 * @param f
	 * @param p
	 */
	public void colidateOwnFigureKnight(IFigure f, Player p) {
		setFigureList(p.getFigureList());
		getColi().setFigureList(getFigureList());
		getColi().unmovedFigures(f);
		setFields(f.getPosFields());
		checkColidateField();
		f.setPosFields(getFields());
	}

	/**
	 * 
	 */
	private void checkColidateField() {
		for(int i = 0; i < getFields().size(); i++) {
			checkEntriesForColidate(i);
		}
		
	}

	/**
	 * 
	 * @param i
	 */
	private void checkEntriesForColidate(int i) {
		for(setC(0); getC() < getFields().get(i).size(); setC(getC() + 1)) {
			checkColidateKnight(i);
		}
	}

	/**
	 * 
	 * @param i
	 */
	private void checkColidateKnight(int i) {
		Integer[] field = getFields().get(i).get(getC());
		if(getColi().colidate(field)) {
			getFields().get(i).remove(getC());
			setC(getC() - 1);
		}
	}
	

}
