package model;

import java.util.ArrayList;
import java.util.List;

public class Player implements IPlayer{
	
	private List<IFigure> figureList;
	private IFigure f;
	private char col;
	private FigureFactory figureFactory = new FigureFactory();
	
	public Player(char color, IField field) {
		this.figureList = new ArrayList<IFigure>();
		this.col = color;
		initializeFigures(field);
	}
	
	public List<IFigure> getFigureList() {
		return figureList;
	}

	public void setFigureList(List<IFigure> figureList) {
		this.figureList = figureList;
	}

	public char getCol() {
		return col;
	}
	
	private void addPawns(IField field) {
		int yKord = ChessConstants.PAWNYKORDS[0];
		if(this.col == 'b') {
			yKord = ChessConstants.PAWNYKORDS[1];
		}
		for(int i = 1; i <= ChessConstants.MAXPAWNS; i++) {
			f = figureFactory.getFigure(ChessConstants.PAWN, yKord, i, this.col);
			getFigureList().add(f);
			field.initializeField(f);
		}
	}
	
	private void addQueen(IField field) {
		int xKord = ChessConstants.QUEENXKORDS;
		int yKord = blackOrWhite();
		f = figureFactory.getFigure(ChessConstants.QUEEN, yKord, xKord, this.col);
		getFigureList().add(f);
		field.initializeField(f);
	}
	
	private void addKing(IField field) {
		int xKord = ChessConstants.KINGXKORDS;
		int yKord = blackOrWhite();
		f = figureFactory.getFigure(ChessConstants.KING, yKord, xKord, this.col);
		getFigureList().add(f);
		field.initializeField(f);
	}
	
	private void addKnights(IField field) {
		int xKord = ChessConstants.KNIGHTXKORDS[0];
		int yKord = blackOrWhite();
		f = figureFactory.getFigure(ChessConstants.KNIGHT, yKord, xKord, this.col);
		getFigureList().add(f);
		field.initializeField(f);
		xKord = ChessConstants.KNIGHTXKORDS[1];
		f = figureFactory.getFigure(ChessConstants.KNIGHT, yKord, xKord, this.col);
		getFigureList().add(f);
		field.initializeField(f);
	}
	
	private void addBishops(IField field) {
		int xKord = ChessConstants.BISHOPXKORDS[0];
		int yKord = blackOrWhite();
		f = figureFactory.getFigure(ChessConstants.BISHOP, yKord, xKord, this.col);
		getFigureList().add(f);
		field.initializeField(f);
		xKord = ChessConstants.BISHOPXKORDS[1];
		f = figureFactory.getFigure(ChessConstants.BISHOP, yKord, xKord, this.col);
		getFigureList().add(f);
		field.initializeField(f);
	}
	
	private void addRooks(IField field) {
		int xKord = ChessConstants.ROOKXKORDS[0];
		int yKord = blackOrWhite();
		f = figureFactory.getFigure(ChessConstants.ROOK, yKord, xKord, this.col);
		getFigureList().add(f);
		field.initializeField(f);
		xKord = ChessConstants.ROOKXKORDS[1];
		f = figureFactory.getFigure(ChessConstants.ROOK, yKord, xKord, this.col);
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
	
	private void initializeFigures(IField field) {
		addPawns(field);
		addRooks(field);
		addKnights(field);
		addBishops(field);
		addQueen(field);
		addKing(field);
	}

}
