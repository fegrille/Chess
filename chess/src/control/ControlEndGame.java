package control;

import java.util.List;

import model.Figure;
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
	private boolean canKillBadFigure = false;
	private boolean cantBlockBadFigure = false;
	
	private ControlChess cChess = new ControlChess();
	
	private Player pl = null;
	private Player plOpp = null;
	private ControlColidate col = null;
	private Figure lastMovedFigure = null;
	
	public void controlWin(Player pl, Player plOpp, ControlColidate col, Figure lastMovedFigure) {
		setPl(pl);
		setPlOpp(plOpp);
		setCol(col);
		setLastMovedFigure(lastMovedFigure);
		resetValues();
		if(cChess.checkChess(pl, lastMovedFigure, col, plOpp)) {
			checkRetireOptions();
		}
	}

	private void checkRetireOptions() {
		checkPossibleFieldsKing();
		killBadFigure();
		blockBadFigure();
		if(isKingCantMove() && !isCanKillBadFigure() && isCantBlockBadFigure()) {
			setWin(true);
		}
	}

	private void blockBadFigure() {
		
	}

	private void killBadFigure() {
		List<Figure> figureList = getPl().getFigureList();
		for(Figure f : figureList) {
			killingPossibleAllFields(f);
		}
	}

	private void killingPossibleAllFields(Figure f) {
		List<Integer[]> finalFields = getCol().colidate(f, f.possibleFields(), getPl(), getPlOpp());
		for(Integer[] field : finalFields) {
			killingPossibleOneField(field);
		}
	}

	private void killingPossibleOneField(Integer[] field) {
		int[] evilField = getLastMovedFigure().getField();
		if(field[0] == evilField[0] && field[1] == evilField[1]) {
			setCanKillBadFigure(true);
		}
	}

	private void checkPossibleFieldsKing() {
		int size = getPl().getFigureList().size();
		Figure king = getPl().getFigureList().get(size - 1);
		if(getCol().colidate(king, king.possibleFields(), getPl(), getPlOpp()).size() == 0) {
			setKingCantMove(true);
		}
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

	public boolean isCanKillBadFigure() {
		return canKillBadFigure;
	}

	public void setCanKillBadFigure(boolean canKillBadFigure) {
		this.canKillBadFigure = canKillBadFigure;
	}

	public boolean isCantBlockBadFigure() {
		return cantBlockBadFigure;
	}

	public void setCantBlockBadFigure(boolean cantBlockBadFigure) {
		this.cantBlockBadFigure = cantBlockBadFigure;
	}
	
	private Player getPl() {
		return pl;
	}

	private void setPl(Player pl) {
		this.pl = pl;
	}

	private Player getPlOpp() {
		return plOpp;
	}

	private void setPlOpp(Player plOpp) {
		this.plOpp = plOpp;
	}

	private ControlColidate getCol() {
		return col;
	}

	private void setCol(ControlColidate col) {
		this.col = col;
	}

	private Figure getLastMovedFigure() {
		return lastMovedFigure;
	}

	private void setLastMovedFigure(Figure lastMovedFigure) {
		this.lastMovedFigure = lastMovedFigure;
	}
	
	private void resetValues() {
		setKingCantMove(false);
		setCanKillBadFigure(false);
		setCantBlockBadFigure(false);
	}
	
}
