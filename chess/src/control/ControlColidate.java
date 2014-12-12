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
	
	public  void colidate(Figure f, Player p, Player p2) {
		updatePossibleFields(p,p2);
		updatePossibleFields(p2,p);
		updatePossibleFieldsKing(p,p2);
		updatePossibleFieldsKing(p2,p);
	}
	
	private void updatePossibleFields(Player p, Player p2) {
		for(int i = 0; i < p.getFigureList().size(); i++) {
			Figure f = p.getFigureList().get(i);
			f.possibleFields();
			isPawn(f,p,p2);
			isRook(f,p,p2);
			isBishop(f,p,p2);
			isKnight(f,p,p2);
			isQueen(f,p,p2);
		}
		
	}

	private void updatePossibleFieldsKing(Player p, Player p2) {
		for(int i = 0; i < p.getFigureList().size(); i++) {
			Figure f = p.getFigureList().get(i);
			isKing(f,p,p2);
		}
	}

	public void isPawn(Figure f, Player p, Player p2) {
		if(f instanceof Pawn) {
			getColPaw().colidateOwnFigurePawn(f,p,p2);
		}
	}
	
	public void isRook(Figure f, Player p, Player p2) {
		if(f instanceof Rook) {
			getColRook().colidateRook(f, p, p2);
		}
	}
	
	public void isBishop(Figure f, Player p, Player p2) {
		if(f instanceof Bishop) {
			getColBis().colidateBishop(f, p, p2);
		}
	}

	public void isKnight(Figure f, Player p, Player p2) {
		if(f instanceof Knight) {
			getColKnig().colidateOwnFigureKnight(f,p);
		}
	}

	public void isQueen(Figure f, Player p, Player p2) {
		if(f instanceof Queen) {
			getColQueen().colidateQueen(f, p, p2);
		}
	}
	
	public void isKing(Figure f, Player p, Player p2) {
		if(f instanceof King) {
			getColKing().colidateOwnFigureKing(f,p);
			getColKing().colidateOwnFigureKing(f,p2);
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

}
