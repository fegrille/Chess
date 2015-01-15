package control;

import java.util.List;

import com.google.inject.Guice;
import com.google.inject.Injector;

import model.IFigure;
import model.Player;
/**
 * 
 * @author Felix
 *
 */
public class ControlColidatePawn implements IControlColidatePawn{
	
	private Injector inj = Guice.createInjector(new ControlModule());
	private ColidatingFields coli;
	private List<List<Integer[]>> fields;
	private int c;
	
	public ControlColidatePawn() {
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
	 * @param c1
	 */
	public void setC(int c1) {
		this.c = c1;
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
	 * @param f
	 * @param p2
	 */
	@Override
	public void colidateOtherFigurePawn(IFigure f, Player p2) {
		getColi().colidateInFrontPawn(f,p2);
		setFields(f.getPosFields());
		checkColiateSideFieldsOther();
	}

	/**
	 * 
	 */
	private void checkColiateSideFieldsOther() {
		if(getFields().get(1) != null) {
			iterateFields();
		}
	}

	/**
	 * 
	 */
	private void iterateFields() {
		for(setC(0); getC() < getFields().get(1).size(); setC(getC() + 1)) {
			checkColidationOther();
		}
	}

	/**
	 * 
	 */
	private void checkColidationOther() {
		if(!getColi().colidate(getFields().get(1).get(getC()))) {
			getFields().get(1).remove(getC());
			setC(getC() - 1);
		}
		
	}

	/**
	 * 
	 * @param f
	 * @param p
	 */
	@Override
	public void colidateOwnFigurePawn(IFigure f, Player p) {
		setFields(f.getPosFields());
		getColi().colidateInFrontPawn(f,p);
		colidateSideFieldsOwn();
		f.setPosFields(getColi().getFields());
	}

	/**
	 * 
	 */
	private void colidateSideFieldsOwn() {
		for(setC(0); getC() < getFields().get(1).size(); setC(getC() + 1)) {
			checkColidationOwn();
		}
	}

	/**
	 * 
	 */
	private void checkColidationOwn() {
		if(getColi().colidate(getFields().get(1).get(getC()))) {
			getFields().get(1).remove(getC());
			setC(getC() - 1);
		}
	}

}
