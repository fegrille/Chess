package control;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

import model.Bishop;
import model.IFigure;
import model.King;
import model.Knight;
import model.Pawn;
import model.Player;
import model.Queen;
import model.Rook;

/**
 * 
 * @author Felix
 *
 */
public class ControlColidate implements IControlColidate{
	
	private Injector inj = Guice.createInjector(new ControlModule());
	private ControlColidateBishop colBis;
	private ControlColidatePawn colPaw;
	private ControlColidateKnight colKnig;
	private ControlColidateQueen colQueen;
	private ControlColidateKing colKing;
	private ControlColidateRook colRook;
	
	@Inject
	public ControlColidate() {
		colBis = inj.getInstance(ControlColidateBishop.class);
		colPaw = inj.getInstance(ControlColidatePawn.class);
		colKnig = inj.getInstance(ControlColidateKnight.class);
		colQueen = inj.getInstance(ControlColidateQueen.class);
		colKing = inj.getInstance(ControlColidateKing.class);
		colRook = inj.getInstance(ControlColidateRook.class);
	}
	
	/**
	 * 
	 * @return
	 */
	public ControlColidateBishop getColBis() {
		return colBis;
	}
	
	/**
	 * 
	 * @return
	 */
	public ControlColidateKnight getColKnig() {
		return colKnig;
	}
	
	/**
	 * 
	 * @return
	 */
	public ControlColidatePawn getColPaw() {
		return colPaw;
	}

	/**
	 * 
	 * @return
	 */
	public ControlColidateQueen getColQueen() {
		return colQueen;
	}

	/**
	 * 
	 * @return
	 */
	public ControlColidateKing getColKing() {
		return colKing;
	}

	/**
	 * 
	 * @return
	 */
	public ControlColidateRook getColRook() {
		return colRook;
	}
	
	/**
	 * 
	 * @param p
	 * @param p2
	 */
	@Override
	public void colidate(Player p, Player p2) {
		updatePossibleFieldsKing(p,p2);
		updatePossibleFields(p,p2);
		updatePossibleFields(p2,p);
		
	}
	
	/**
	 * 
	 * @param p
	 * @param p2
	 */
	private void updatePossibleFields(Player p, Player p2) {
		for(int i = 0; i < p.getFigureList().size(); i++) {
			IFigure f = p.getFigureList().get(i);
			isPawn(f,p,p2);
			isRook(f,p,p2);
			isBishop(f,p,p2);
			isKnight(f,p,p2);
			isQueen(f,p,p2);
		}
		
	}

	/**
	 * 
	 * @param p
	 * @param p2
	 */
	private void updatePossibleFieldsKing(Player p, Player p2) {
		for(int i = 0; i < p.getFigureList().size(); i++) {
			IFigure f = p.getFigureList().get(i);
			isKing(f,p,p2);
		}
	}

	/**
	 * 
	 * @param f
	 * @param p
	 * @param p2
	 */
	public void isPawn(IFigure f, Player p, Player p2) {
		if(f instanceof Pawn) {
			f.possibleFields();
			getColPaw().colidateOwnFigurePawn(f,p);
			getColPaw().colidateOtherFigurePawn(f, p2);
		}
	}
	
	/**
	 * 
	 * @param f
	 * @param p
	 * @param p2
	 */
	public void isRook(IFigure f, Player p, Player p2) {
		if(f instanceof Rook) {
			f.possibleFields();
			getColRook().colidateRook(f, p, p2);
		}
	}
	
	/**
	 * 
	 * @param f
	 * @param p
	 * @param p2
	 */
	public void isBishop(IFigure f, Player p, Player p2) {
		if(f instanceof Bishop) {
			f.possibleFields();
			getColBis().colidateBishop(f, p, p2);
		}
	}

	/**
	 * 
	 * @param f
	 * @param p
	 * @param p2
	 */
	public void isKnight(IFigure f, Player p, Player p2) {
		if(f instanceof Knight) {
			f.possibleFields();
			getColKnig().colidateOwnFigureKnight(f,p);
		}
	}

	/**
	 * 
	 * @param f
	 * @param p
	 * @param p2
	 */
	public void isQueen(IFigure f, Player p, Player p2) {
		if(f instanceof Queen) {
			f.possibleFields();
			getColQueen().colidateQueen(f, p, p2);
		}
	}
	
	/**
	 * 
	 * @param f
	 * @param p
	 * @param p2
	 */
	public void isKing(IFigure f, Player p, Player p2) {
		if(f instanceof King) {
			f.possibleFields();
			IFigure k = getKingP2(p2);
			k.possibleFields();
			getColKing().colidateOwnFigureKing(f,p);
			getColKing().colidateOtherFigureKing(f,p2);
			getColKing().colidateOwnFigureKing(k, p2);
			getColKing().colidateOtherFigureKing(k, p);
		}
	}

	/**
	 * 
	 * @param p2
	 * @return
	 */
	private IFigure getKingP2(Player p2) {
		IFigure king = null;
		for(IFigure k : p2.getFigureList()) {
			king = returnKing(k);
		}
		return king;
	}

	/**
	 * @param k
	 */
	private IFigure returnKing(IFigure k) {
		IFigure king = null;
		if(k instanceof King) {
			king = k;
		}
		return king;
	}

}
