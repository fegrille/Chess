package control;

import java.util.List;

import model.Bishop;
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
	
	public  List<Integer[]> colidate(Figure f, List<Integer[]> pf, Player p, Player p2) {
		isPawn(f,pf,p,p2);
		isRook(f,pf,p,p2);
		isBishop(f,pf,p,p2);
		isKnight(f,pf,p,p2);
		isQueen(f,pf,p,p2);
		isKing(f,pf,p,p2);
		return getPossibleFields(); 
	}
	
	public void isPawn(Figure f, List<Integer[]> pf, Player p, Player p2) {
		if(f instanceof Pawn) {
			setPossibleFields(getColPaw().colidateFigurePawn(f,pf,p,p2));
		}
	}
	
	public void isRook(Figure f, List<Integer[]> pf, Player p, Player p2) {
		if(f instanceof Rook) {
			setPossibleFields(getColRook().colidateRook(f, pf, p, p2));
		}
	}
	
	public void isBishop(Figure f, List<Integer[]> pf, Player p, Player p2) {
		if(f instanceof Bishop) {
			setPossibleFields(getColBis().colidateBishop(f, pf, p, p2));
		}
	}
	
	public void isKnight(Figure f, List<Integer[]> pf, Player p, Player p2) {
		if(f instanceof Knight) {
			setPossibleFields(getColKnig().colidateOwnFigureKnight(f,pf,p));
		}
	}
	
	public void isQueen(Figure f, List<Integer[]> pf, Player p, Player p2) {
		if(f instanceof Queen) {
			setPossibleFields(getColQueen().colidateQueen(f, pf, p, p2));
		}
	}
	
	public void isKing(Figure f, List<Integer[]> pf, Player p, Player p2) {
		if(f instanceof King) {
			setPossibleFields(getColKing().colidateOwnFigureKing(f,pf,p));
			setPossibleFields(getColKing().colidateOtherFigureKing(f,pf,p2));
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
