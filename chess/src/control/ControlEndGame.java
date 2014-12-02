package control;

import java.util.List;

import com.sun.glass.ui.Size;

import model.Figure;
import model.King;
import model.Player;

public class ControlEndGame {
	/*
	 * Gewonnen: setzt gegnerischen könig schach:
	 * 1. könig kann sich nicht bewegen.
	 * 2. gegner kann die Figur nicht schmeißen.
	 * 3. gegner kann keine Figur so bewegen, dass König nicht mehr im Schach ist
	 * 
	 * Unentschieden:
	 * 1. König gegen gegn. König + Läufer oder König + Pferd
	 * 2. König + Läufer gegen gegn. König + Läufer (Beide Läufer auf der gleichen Farbe)
	 * 3.
	 */
	
	private boolean win = false;
	private boolean kingCantMove = false;
	private boolean cantKillBadFigure = false;
	private boolean cantBlockBadFigure = false;
	
	public void controlWin(Player pl) {
		if(checkChess(pl)) {
			checkRetireOptions(pl);
		}
	}

	private void checkRetireOptions(Player pl) {
		checkPossibleFieldsKing(pl);
		killBadFigure(pl);
		blockBadFigure(pl);
		if(isKingCantMove() && isCantKillBadFigure() && isCantBlockBadFigure()) {
			setWin(true);
		}
	}

	private boolean checkChess(Player pl) {
		/*
		 * checking if chess
		 */
		return false;
	}

	private boolean blockBadFigure(Player pl) {
		
		return false;
	}

	private boolean killBadFigure(Player pl) {
		
		return false;
	}

	private void checkPossibleFieldsKing(Player pl) {
		int size = pl.getFigureList().size();
		Figure king = pl.getFigureList().get(size - 1);
		//if(king.possibleFields().size() == 0)
		setKingCantMove(true);
		//
	}


	public boolean getWin() {
		return win;
	}

	private void setWin(boolean win) {
		this.win = win;
	}

	public boolean isKingCantMove() {
		return kingCantMove;
	}

	public void setKingCantMove(boolean kingCantMove) {
		this.kingCantMove = kingCantMove;
	}

	public boolean isCantKillBadFigure() {
		return cantKillBadFigure;
	}

	public void setCantKillBadFigure(boolean cantKillBadFigure) {
		this.cantKillBadFigure = cantKillBadFigure;
	}

	public boolean isCantBlockBadFigure() {
		return cantBlockBadFigure;
	}

	public void setCantBlockBadFigure(boolean cantBlockBadFigure) {
		this.cantBlockBadFigure = cantBlockBadFigure;
	}
	
	
}
