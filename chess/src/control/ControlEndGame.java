package control;

import java.util.ArrayList;
import java.util.List;

import model.Bishop;
import model.IFigure;
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
	private IFigure lastMovedFigure = null;
	private List<int[]> possBlockFields = new ArrayList<int[]>();

	public void controlWin(Player pl, Player plOpp, ControlColidate col, IFigure lastMovedFigure) {
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
		isRook(lastMovedFigure);
		isBishop(lastMovedFigure);
		isQueen(lastMovedFigure);
		checkOwnFiguresBlock();
	}
	
	private void isRook(IFigure lastMovedFigure) {
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
	private void isBishop(IFigure lastMovedFigure) {
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

	private void getXOrderedFieldsBishop(int[] xBigField, int[] xSmallField) {
		if(xBigField[0] > xSmallField[0]) {
			getBothOrderedFieldsBishopPlus(xBigField[1], xSmallField[1], xBigField[0], xSmallField[0]);
		} else {
			getBothOrderedFieldsBishopMinus(xBigField[1], xSmallField[1], xSmallField[0], xBigField[0]);
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
	private void isQueen(IFigure lastMovedFigure) {
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
	private void checkOwnFiguresBlock() {
		List<IFigure> figureList = getPl().getFigureList();
		for(IFigure f : figureList) {
			compareBlockingFields(f);
		}
	}

	private void compareBlockingFields(IFigure f) {
		f.possibleFields();
		getCol().colidate(f, getPl(), getPlOpp());
		for(List<Integer[]> fields : f.getPosFields()) {
			for(Integer[] field : fields) {
				compareAvailableBlockFields(field);
			}
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
		List<IFigure> figureList = getPl().getFigureList();
		for(IFigure f : figureList) {
			killingPossibleAllFields(f);
		}
	}

	private void killingPossibleAllFields(IFigure f) {
		getCol().colidate(f, getPl(), getPlOpp());
		List<List<Integer[]>> finalFields = f.getPosFields();
		for(List<Integer[]> fields: finalFields) {
			for(Integer[] field : fields) {
				killingPossibleOneField(field);
			}
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
		IFigure king = getPl().getFigureList().get(size - 1);
		getCol().colidate(king, getPl(), getPlOpp());
		if(king.getPosFields().size() == 0) {
			setKingCantMove(true);
		}
	}

	//Getter and Setter
	public boolean getWin() {
		return win;
	}

	public void setWin(boolean win) {
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
	
	public Player getPl() {
		return pl;
	}

	public void setPl(Player pl) {
		this.pl = pl;
	}

	public Player getPlOpp() {
		return plOpp;
	}

	public void setPlOpp(Player plOpp) {
		this.plOpp = plOpp;
	}

	public ControlColidate getCol() {
		return col;
	}

	public void setCol(ControlColidate col) {
		this.col = col;
	}

	public IFigure getLastMovedFigure() {
		return lastMovedFigure;
	}

	public void setLastMovedFigure(IFigure lastMovedFigure) {
		this.lastMovedFigure = lastMovedFigure;
	}

	public List<int[]> getPossBlockFields() {
		return possBlockFields;
	}

	public void setPossBlockFields(List<int[]> possBlockFields) {
		this.possBlockFields = possBlockFields;
	}
	
	//Reset Global Values
	private void resetValues() {
		setKingCantMove(false);
		setCanKillBadFigure(false);
		setCantBlockBadFigure(true);
	}
}
