package control;

import java.util.List;

import model.Bishop;
import model.ChessConstants;
import model.Figure;
import model.King;
import model.Knight;
import model.Pawn;
import model.Player;
import model.Queen;
import model.Rook;

public class ControlColidate {
	
	private List<Integer[]> possibleFields;
	private List<Figure> figureList;
	private ControlColidateBishop colBis = new ControlColidateBishop();
	private ControlColidatePawnKnight colPawKnig = new ControlColidatePawnKnight();
	private ControlColidateQueen colQueen = new ControlColidateQueen();
	private ControlColidateKing colKing = new ControlColidateKing();
	private ControlColidateRook colRook = new ControlColidateRook();
	private boolean colidate = false;
	
	public ControlColidateBishop getColBis() {
		return colBis;
	}

	public ControlColidatePawnKnight getColPawKnig() {
		return colPawKnig;
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
	
	public  List<Integer[]> colidate(Figure f, List<Integer[]> pf, Player p, Player p2) {
		isPawn(f,pf,p);
		isRook(f,pf,p,p2);
		isBishop(f,pf,p,p2);
		isKnight(f,pf,p,p2);
		isQueen(f,pf,p,p2);
		isKing(f,pf,p,p2);
		return getPossibleFields(); 
	}
	
	public void isPawn(Figure f, List<Integer[]> pf, Player p) {
		if(f instanceof Pawn) {
			setPossibleFields(getColPawKnig().colidateFigurePawnKnight(f,pf,p));
		}
	}
	
	public void isRook(Figure f, List<Integer[]> pf, Player p, Player p2) {
		if(f instanceof Rook) {
			getColRook().colidateRook(f, pf, p, p2);
		}
	}
	
	public void isBishop(Figure f, List<Integer[]> pf, Player p, Player p2) {
		if(f instanceof Bishop) {
			getColBis().colidateBishop(f, pf, p, p2);
		}
	}
	
	public void isKnight(Figure f, List<Integer[]> pf, Player p, Player p2) {
		if(f instanceof Knight) {
			getColPawKnig().colidateFigurePawnKnight(f,pf,p);
		}
	}
	
	public void isQueen(Figure f, List<Integer[]> pf, Player p, Player p2) {
		if(f instanceof Queen) {
			getColQueen().colidateQueen(f, pf, p, p2);
		}
	}
	
	public void isKing(Figure f, List<Integer[]> pf, Player p, Player p2) {
		if(f instanceof King) {
			getColKing().colidateOwnFigureKing(f,pf,p);
			getColKing().colidateOtherFigureKing(f,pf,p2);
		}
	}

	public void setColidate(boolean colidate) {
		this.colidate = colidate;
	}

	public List<Figure> getFigureList() {
		return figureList;
	}

	public void setFigureList(List<Figure> figureList) {
		this.figureList = figureList;
	}

	public List<Integer[]> getPossibleFields() {
		return possibleFields;
	}

	public void setPossibleFields(List<Integer[]> possibleFields) {
		this.possibleFields = possibleFields;
	}
}
