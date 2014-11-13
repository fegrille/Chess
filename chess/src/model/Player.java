package model;

import java.util.ArrayList;
import java.util.List;

public class Player {
	
	private List<Figure> figureList;
	private char col;
	
	public Player(char color) {
		this.figureList = new ArrayList<Figure>();
		addPawns();
		addRooks();
		addKnights();
		addBishops();
		addQueen();
		addKing();
		this.col = color;
	}
	
	private void addPawns() {
		int yKord = ChessConstants.PAWNYKORDS[0];
		if(this.col == 'b') {
			yKord = ChessConstants.PAWNYKORDS[1];
		}
		for(int i = 1; i <= ChessConstants.MAXPAWNS; i++) {
			this.figureList.add(new Pawn(yKord, i, this.col));
		}
	}
	
	private void addQueen() {
		int xKord = ChessConstants.QUEENXKORDS;
		int yKord = blackOrWhite();
		this.figureList.add(new Queen(xKord,yKord,this.col));
	}
	
	private void addKing() {
		int xKord = ChessConstants.KINGXKORDS;
		int yKord = blackOrWhite();
		this.figureList.add(new King(xKord,yKord,this.col));
	}
	
	private void addKnights() {
		int xKord = ChessConstants.KNIGHTXKORDS[0];
		int yKord = blackOrWhite();
		this.figureList.add(new King(xKord,yKord,this.col));
		xKord = ChessConstants.KNIGHTXKORDS[1];
		this.figureList.add(new King(xKord,yKord,this.col));
	}
	
	private void addBishops() {
		int xKord = ChessConstants.BISHOPXKORDS[0];
		int yKord = blackOrWhite();
		this.figureList.add(new King(xKord,yKord,this.col));
		xKord = ChessConstants.BISHOPXKORDS[1];
		this.figureList.add(new King(xKord,yKord,this.col));
	}
	
	private void addRooks() {
		int xKord = ChessConstants.ROOKXKORDS[0];
		int yKord = blackOrWhite();
		this.figureList.add(new King(xKord,yKord,this.col));
		xKord = ChessConstants.ROOKXKORDS[1];
		this.figureList.add(new King(xKord,yKord,this.col));
	}
	
	private int blackOrWhite() {
		int yKord = ChessConstants.MINAXIS;
		if(this.col == 'b') {
			yKord = ChessConstants.MAXAXIS;
		}
		return yKord;
	}

}
