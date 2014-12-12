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
	private boolean cantBlockBadFigure = true;
	
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
		CheckOwnFiguresBlock();
	}
	
	private void isRook(Player pl, Player plOpp, ControlColidate col, Figure lastMovedFigure) {
		if(lastMovedFigure instanceof Rook) {
			checkBlockRook();
		}
	}
	
	//Evil Figure is Rook
	private void checkBlockRook() {
		int size = getPl().getFigureList().size();
		int[] kingField = getPl().getFigureList().get(size - 1).getField();
		int[] evilField = getLastMovedFigure().getField();
		setPossBlockFields(new ArrayList<int[]>());
		getPossibleBlockingFieldsRook(kingField, evilField);
	}

	private void getPossibleBlockingFieldsRook(int[] kingField, int[] evilField) {
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
			getPossBlockFields().add(i);
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
			getPossBlockFields().add(i);
		}
	}

	//Evil Figure is Bishop
	private void isBishop(Player pl, Player plOpp, ControlColidate col, Figure lastMovedFigure) {
		if(lastMovedFigure instanceof Bishop) {
			checkBlockBishop();
		}
	}
	
	private void checkBlockBishop() {
		int size = getPl().getFigureList().size();
		int[] kingField = getPl().getFigureList().get(size - 1).getField();
		int[] evilField = getLastMovedFigure().getField();
		setPossBlockFields(new ArrayList<int[]>());
		getPossibleBlockingFieldsBishop(kingField, evilField);
	}
	
	private void getPossibleBlockingFieldsBishop(int[] kingField, int[] evilField) {
		if(kingField[1] > evilField[1]) {
			getXOrderedFieldsBishop(kingField, evilField);
		} else {
			getXOrderedFieldsBishop(evilField, kingField);
		}
	}

	private void getXOrderedFieldsBishop(int[] XBigField, int[] XSmallField) {
		if(XBigField[0] > XSmallField[0]) {
			getBothOrderedFieldsBishopPlus(XBigField[1], XSmallField[1], XBigField[0], XSmallField[0]);
		} else {
			getBothOrderedFieldsBishopMinus(XBigField[1], XSmallField[1], XSmallField[0], XBigField[0]);
		}
	}

	private void getBothOrderedFieldsBishopPlus(int xBigField, int xSmallField, int yBigField, int ySmallField) {
		int y = ySmallField;
		for(int x = xSmallField; (x + 1) < xBigField; x++) {
			int i[] = {x + 1, y + 1};
			getPossBlockFields().add(i);
			y++;
		}
	}
	
	private void getBothOrderedFieldsBishopMinus(int xBigField, int xSmallField, int yBigField, int ySmallField) {
		int y = yBigField;
		for(int x = xSmallField; (x + 1) < xBigField; x++) {
			int i[] = {x + 1, y - 1};
			getPossBlockFields().add(i);
			y--;
		}
	}

	//Evil Figure is Queen
	private void isQueen(Player pl, Player plOpp, ControlColidate col, Figure lastMovedFigure) {
		if(lastMovedFigure instanceof Queen) {
			checkBlockQueen();
		}
	}


	private void checkBlockQueen() {
		int size = getPl().getFigureList().size();
		int[] kingField = getPl().getFigureList().get(size - 1).getField();
		int[] evilField = getLastMovedFigure().getField();
		setPossBlockFields(new ArrayList<int[]>());
		if(kingField[0] == evilField[0] || kingField[1] == evilField[1]) {
			getPossibleBlockingFieldsRook(kingField, evilField);
		} else {
			getPossibleBlockingFieldsBishop(kingField, evilField);
		}
	}
	
	//Method for check if a own Figure is able to block
	private void CheckOwnFiguresBlock() {
		List<Figure> figureList = getPl().getFigureList();
		for(Figure f : figureList) {
			compareBlockingFields(f);
		}
	}

	private void compareBlockingFields(Figure f) {
		for(Integer[] field : f.getPosFields()) {
			compareAvailableBlockFields(field);
		}
	}

	private void compareAvailableBlockFields(Integer[] ownField) {
		for(int[] field :getPossBlockFields()) {
			compareBothFields(ownField, field);
		}
	}

	private void compareBothFields(Integer[] ownField, int[] field) {
		if(ownField[0] == field[0] && ownField[1] == field[1]) {
			setCantBlockBadFigure(false);
		}
	}

	//Methods for Killing bad Figure
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

	//Method for King escape
	private void checkPossibleFieldsKing() {
		int size = getPl().getFigureList().size();
		Figure king = getPl().getFigureList().get(size - 1);
		getCol().colidate(king, getPl(), getPlOpp());
		if(king.getPosFields().size() == 0) {
			setKingCantMove(true);
		}
	}

	//Getter and Setter
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

	private List<int[]> getPossBlockFields() {
		return possBlockFields;
	}

	private void setPossBlockFields(List<int[]> possBlockFields) {
		this.possBlockFields = possBlockFields;
	}
	
	//Reset Global Values
	private void resetValues() {
		setKingCantMove(false);
		setCanKillBadFigure(false);
		setCantBlockBadFigure(true);
	}
}
