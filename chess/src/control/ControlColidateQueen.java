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
public class ControlColidateQueen implements IControlColidateQueen{
	
	private Injector inj = Guice.createInjector(new ControlModule());
	private ColidatingFields coli;
	
	public ControlColidateQueen() {
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
	@Override
	public void colidateQueen(IFigure f, Player p, Player p2) {
		getColi().colidateOwnQueen(f, p);
		getColi().colidateOtherQueen(f, p2);
	}

}
