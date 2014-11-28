package model;

import java.util.ArrayList;
import java.util.List;

public class Player {
	
	private List<Figure> figureList;
	private Figure f;
	private char col;
	
	public Player(char color) {
		this.figureList = new ArrayList<Figure>();
		this.col = color;
	}
	
	public List<Figure> getFigureList() {
		return figureList;
	}

	public void setFigureList(List<Figure> figureList) {
		this.figureList = figureList;
	}

	public char getCol() {
		return col;
	}

	public void setCol(char col) {
		this.col = col;
	}
	
	private void addPawns(Field field) {
		int yKord = ChessConstants.PAWNYKORDS[0];
		if(this.col == 'b') {
			yKord = ChessConstants.PAWNYKORDS[1];
		}
		for(int i = 1; i <= ChessConstants.MAXPAWNS; i++) {
			f = new Pawn(yKord, i, this.col);
			getFigureList().add(f);
			field.initializeField(f);
		}
	}
	
	private void addQueen(Field field) {
		int xKord = ChessConstants.QUEENXKORDS;
		int yKord = blackOrWhite();
		f = new Queen(yKord,xKord,this.col);
		getFigureList().add(f);
		field.initializeField(f);
	}
	
	private void addKing(Field field) {
		int xKord = ChessConstants.KINGXKORDS;
		int yKord = blackOrWhite();
		f = new King(yKord,xKord,this.col);
		getFigureList().add(f);
		field.initializeField(f);
	}
	
	private void addKnights(Field field) {
		int xKord = ChessConstants.KNIGHTXKORDS[0];
		int yKord = blackOrWhite();
		f = new Knight(yKord,xKord,this.col);
		getFigureList().add(f);
		field.initializeField(f);
		xKord = ChessConstants.KNIGHTXKORDS[1];
		f = new Knight(yKord,xKord,this.col);
		getFigureList().add(f);
		field.initializeField(f);
	}
	
	private void addBishops(Field field) {
		int xKord = ChessConstants.BISHOPXKORDS[0];
		int yKord = blackOrWhite();
		f = new Bishop(yKord,xKord,this.col);
		getFigureList().add(f);
		field.initializeField(f);
		xKord = ChessConstants.BISHOPXKORDS[1];
		f = new Bishop(yKord,xKord,this.col);
		getFigureList().add(f);
		field.initializeField(f);
	}
	
	private void addRooks(Field field) {
		int xKord = ChessConstants.ROOKXKORDS[0];
		int yKord = blackOrWhite();
		f = new Rook(yKord,xKord,this.col);
		getFigureList().add(f);
		field.initializeField(f);
		xKord = ChessConstants.ROOKXKORDS[1];
		f = new Rook(yKord,xKord,this.col);
		getFigureList().add(f);
		field.initializeField(f);
	}
	
	private int blackOrWhite() {
		int yKord = ChessConstants.MINAXIS;
		if(this.col == 'b') {
			yKord = ChessConstants.MAXAXIS;
		}
		return yKord;
	}
	
	public void initializeFigures(Field field) {
		addPawns(field);
		addRooks(field);
		addKnights(field);
		addBishops(field);
		addQueen(field);
		addKing(field);
	}

}
