package control;

import java.util.List;

import model.Bishop;
import model.IFigure;
import model.King;
import model.Knight;
import model.Pawn;
import model.Player;
import model.Queen;
import model.Rook;

public class ControlColidate {
	
	private List<IFigure> figureList;
	private ControlColidateBishop colBis = new ControlColidateBishop();
	private ControlColidatePawn colPaw = new ControlColidatePawn();
	private ControlColidateKnight colKnig = new ControlColidateKnight();
	private ControlColidateQueen colQueen = new ControlColidateQueen();
	private ControlColidateKing colKing = new ControlColidateKing();
	private ControlColidateRook colRook = new ControlColidateRook();
	private boolean colidate = false;
	
	public ControlColidateBishop getColBis() {
		return colBis;
	}
	
	public ControlColidateKnight getColKnig() {
		return colKnig;
	}
	public ControlColidatePawn getColPaw() {
		return colPaw;
	}

	public ControlColidateQueen getColQueen() {
		return colQueen;
	}

	public ControlColidateKing getColKing() {
		return colKing;
	}

	public ControlColidateRook getColRook() {
		return colRook;
	}
	public boolean isColidate() {
		return colidate;
	}
	
	public  void colidate(IFigure f, Player p, Player p2) {
		updatePossibleFieldsKing(p,p2);
		updatePossibleFieldsKing(p2,p);
		updatePossibleFields(p,p2);
		updatePossibleFields(p2,p);
		
	}
	
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

	private void updatePossibleFieldsKing(Player p, Player p2) {
		for(int i = 0; i < p.getFigureList().size(); i++) {
			IFigure f = p.getFigureList().get(i);
			isKing(f,p,p2);
		}
	}

	public void isPawn(IFigure f, Player p, Player p2) {
		if(f instanceof Pawn) {
			f.possibleFields();
			getColPaw().colidateOwnFigurePawn(f,p);
			getColPaw().colidateOtherFigurePawn(f, p2);
		}
	}
	
	public void isRook(IFigure f, Player p, Player p2) {
		if(f instanceof Rook) {
			f.possibleFields();
			getColRook().colidateRook(f, p, p2);
		}
	}
	
	public void isBishop(IFigure f, Player p, Player p2) {
		if(f instanceof Bishop) {
			f.possibleFields();
			getColBis().colidateBishop(f, p, p2);
		}
	}

	public void isKnight(IFigure f, Player p, Player p2) {
		if(f instanceof Knight) {
			f.possibleFields();
			getColKnig().colidateOwnFigureKnight(f,p);
		}
	}

	public void isQueen(IFigure f, Player p, Player p2) {
		if(f instanceof Queen) {
			f.possibleFields();
			getColQueen().colidateQueen(f, p, p2);
		}
	}
	
	public void isKing(IFigure f, Player p, Player p2) {
		if(f instanceof King) {
			f.possibleFields();
			getColKing().colidateOwnFigureKing(f,p);
			getColKing().colidateOtherFigureKing(f,p2);
		}
	}

	public void setColidate(boolean colidate) {
		this.colidate = colidate;
	}

	public List<IFigure> getFigureList() {
		return figureList;
	}

	public void setFigureList(List<IFigure> figureList) {
		this.figureList = figureList;
	}

}
