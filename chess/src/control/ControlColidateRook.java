package control;

import com.google.inject.Guice;
import com.google.inject.Injector;

import model.IFigure;
import model.Player;
/**
 * 
 * @author Felix
 *
 */
public class ControlColidateRook implements IControlColidateRook{
	
	private Injector inj = Guice.createInjector(new ControlModule());
	private ColidatingFields coli;
	
	public ControlColidateRook() {
		coli = inj.getInstance(ColidatingFields.class);
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
	 * @param p2
	 */
	public void colidateRook(IFigure f, Player p, Player p2) {
		getColi().colidateOwnFigure(f, p);
		getColi().colidateOtherFigure(f, p2);
	}

}
