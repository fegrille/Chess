package control;

import java.util.ArrayList;
import java.util.List;

import model.Bishop;
import model.Figure;
import model.Player;
import model.Queen;
import model.Rook;

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
	private List<int[]> possBlockFields = new ArrayList<int[]>();
	
	
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
		isRook(pl, plOpp, col, lastMovedFigure);
		isBishop(pl, plOpp, col, lastMovedFigure);
		isQueen(pl, plOpp, col, lastMovedFigure);
	}
	
	public void isRook(Player pl, Player plOpp, ControlColidate col, Figure lastMovedFigure) {
		if(lastMovedFigure instanceof Rook) {
			checkBlockRook();
		}
	}
	
	private void checkBlockRook() {
		int size = getPl().getFigureList().size();
		int[] kingField = getPl().getFigureList().get(size - 1).getField();
		int[] evilField = getLastMovedFigure().getField();
		possBlockFields = new ArrayList<int[]>();
		getPossibleBlockingFieldsRook(kingField, evilField);
	}

	private void getPossibleBlockingFieldsRook(int[] kingField, int[] evilField) {;
		if(kingField[0] != evilField[0]) {
			getYFieldsRook(kingField, evilField);
		} else {
			getXFieldsRook(kingField, evilField);
		}
	}

	private void getXFieldsRook(int[] kingField, int[] evilField) {
		if(kingField[1] > evilField[1]) {
			getFinalXFieldsRook(kingField, evilField);
		} else {
			getFinalXFieldsRook(evilField, kingField);
		}
	}

	private void getFinalXFieldsRook(int[] bigField, int[] smallField) {
		int big = bigField[1];
		int small = smallField[1];
		for(int x = small; (x + 1) < big; x++) {
			int i[] = {bigField[0], x + 1};
			possBlockFields.add(i);
		}
	}

	private void getYFieldsRook(int[] kingField, int[] evilField) {
		if(kingField[0] > evilField[0]) {
			getFinalYFieldsRook(kingField, evilField);
		} else {
			getFinalYFieldsRook(evilField, kingField);
		}
	}

	private void getFinalYFieldsRook(int[] bigField, int[] smallField) {
		int big = bigField[0];
		int small = smallField[0];
		for(int x = small; (x + 1) < big; x++) {
			int i[] = {x + 1, bigField[1]};
			possBlockFields.add(i);
		}
	}

	public void isBishop(Player pl, Player plOpp, ControlColidate col, Figure lastMovedFigure) {
		if(lastMovedFigure instanceof Bishop) {
			checkBlockBishop();
		}
	}
	
	private void checkBlockBishop() {
		
	}

	public void isQueen(Player pl, Player plOpp, ControlColidate col, Figure lastMovedFigure) {
		if(lastMovedFigure instanceof Queen) {
			checkBlockQueen();
		}
	}


	private void checkBlockQueen() {
		
	}

	private void killBadFigure() {
		List<Figure> figureList = getPl().getFigureList();
		for(Figure f : figureList) {
			killingPossibleAllFields(f);
		}
	}

	private void killingPossibleAllFields(Figure f) {
		getCol().colidate(f, getPl(), getPlOpp());
		List<Integer[]> finalFields = f.getPosFields();
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
		getCol().colidate(king, getPl(), getPlOpp());
		if(king.getPosFields().size() == 0) {
			setKingCantMove(true);
		}
	}


	public boolean getWin() {
		return win;
	}

	private void setWin(boolean win) {
		this.win = win;
	}

	private boolean isKingCantMove() {
		return kingCantMove;
	}

	private void setKingCantMove(boolean kingCantMove) {
		this.kingCantMove = kingCantMove;
	}

	private boolean isCanKillBadFigure() {
		return canKillBadFigure;
	}

	private void setCanKillBadFigure(boolean canKillBadFigure) {
		this.canKillBadFigure = canKillBadFigure;
	}

	private boolean isCantBlockBadFigure() {
		return cantBlockBadFigure;
	}

	private void setCantBlockBadFigure(boolean cantBlockBadFigure) {
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
