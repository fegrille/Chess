package model;

import java.util.ArrayList;
import java.util.List;

public class Player {
	
	public List<Figure> figureList;
	private char col;
	
	public Player(char color) {
		figureList = new ArrayList<Figure>();
		figureList = addPawns(figureList);
		figureList = addRooks(figureList);
		figureList = addKnights(figureList);
		figureList = addBishops(figureList);
		figureList = addQueen(figureList);
		figureList = addKing(figureList);
		this.col = color;
	}
	
	private List<Figure> addPawns(List<Figure> figures) {
		int yKord = ChessConstants.PAWNYKORDS[0];
		if(this.col == 'b') {
			yKord = ChessConstants.PAWNYKORDS[1];
		}
		for(int i = 1; i <= ChessConstants.MAXPAWNS; i++) {
			figures.add(new Pawn(yKord, i, this.col));
		}
		return figures;
	}
	
	private List<Figure> addQueen(List<Figure> figures) {
		int xKord = ChessConstants.QUEENXKORDS;
		int yKord = blackOrWhite();
		figures.add(new Queen(xKord,yKord,this.col));
		return figures;
	}
	
	private List<Figure> addKing(List<Figure> figures) {
		int xKord = ChessConstants.KINGXKORDS;
		int yKord = blackOrWhite();
		figures.add(new King(xKord,yKord,this.col));
		return figures;
	}
	
	private List<Figure> addKnights(List<Figure> figures) {
		int xKord = ChessConstants.KNIGHTXKORDS[0];
		int yKord = blackOrWhite();
		figures.add(new King(xKord,yKord,this.col));
		xKord = ChessConstants.KNIGHTXKORDS[1];
		figures.add(new King(xKord,yKord,this.col));
		return figures;
	}
	
	private List<Figure> addBishops(List<Figure> figures) {
		int xKord = ChessConstants.BISHOPXKORDS[0];
		int yKord = blackOrWhite();
		figures.add(new King(xKord,yKord,this.col));
		xKord = ChessConstants.BISHOPXKORDS[1];
		figures.add(new King(xKord,yKord,this.col));
		return figures;
	}
	
	private List<Figure> addRooks(List<Figure> figures) {
		int xKord = ChessConstants.ROOKXKORDS[0];
		int yKord = blackOrWhite();
		figures.add(new King(xKord,yKord,this.col));
		xKord = ChessConstants.ROOKXKORDS[1];
		figures.add(new King(xKord,yKord,this.col));
		return figures;
	}
	
	private int blackOrWhite() {
		int yKord = ChessConstants.MINAXIS;
		if(this.col == 'b') {
			yKord = ChessConstants.MAXAXIS;
		}
		return yKord;
	}

}
