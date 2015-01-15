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
public class ControlColidateBishop implements IControlColidateBishop{
	
	private Injector inj = Guice.createInjector(new ControlModule());
	private ColidatingFields coli;
	
	public ControlColidateBishop() {
		coli = inj.getInstance(ColidatingFields.class);
	}

	/**
	 * 
	 * @return
	 */
	@Override
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
	public void colidateBishop(IFigure f, Player p, Player p2) {
		getColi().colidateOwnFigure(f, p);
		getColi().colidateOtherFigure(f, p2);
	}

}
