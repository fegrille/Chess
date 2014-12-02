package control;

import java.util.List;

import com.sun.glass.ui.Size;

import model.Figure;
import model.King;
import model.Player;

public class ControlEndGame {
	/*
	 * Gewonnen: setzt gegnerischen k�nig schach:
	 * 1. k�nig kann sich nicht bewegen.
	 * 2. gegner kann die Figur nicht schmei�en.
	 * 3. gegner kann keine Figur so bewegen, dass K�nig nicht mehr im Schach ist
	 * 
	 * Unentschieden:
	 * 1. K�nig gegen gegn. K�nig + L�ufer oder K�nig + Pferd
	 * 2. K�nig + L�ufer gegen gegn. K�nig + L�ufer (Beide L�ufer auf der gleichen Farbe)
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
