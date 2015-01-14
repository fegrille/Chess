package model;

public class FigureFactory {
	
	private IFigure i;
	
	public IFigure getFigure(String figureType, int y, int x, char c) {
		createPawn(figureType, y, x, c);
		createKing(figureType, y, x, c);
		createBishop(figureType, y, x, c);
		createKnight(figureType, y, x, c);
		createQueen(figureType, y, x, c);
		createRook(figureType, y, x, c);
		return i;
	}

	private void createRook(String figureType, int y, int x, char c) {
		if (figureType.equals(ChessConstants.ROOK)) {
			i = new Rook(y, x, c);
		}
	}

	private void createQueen(String figureType, int y, int x, char c) {
		if (figureType.equals(ChessConstants.QUEEN)) {
			i = new Queen(y, x, c);
		}
	}

	private void createKnight(String figureType, int y, int x, char c) {
		if (figureType.equals(ChessConstants.KNIGHT)) {
			i = new Knight(y, x, c);
		}
	}

	private void createBishop(String figureType, int y, int x, char c) {
		if (figureType.equals(ChessConstants.BISHOP)) {
			i = new Bishop(y, x, c);
		}
	}

	private void createKing(String figureType, int y, int x, char c) {
		if (figureType.equals(ChessConstants.KING)) {
			i = new King(y, x, c);
		}
	}

	private void createPawn(String figureType, int y, int x, char c) {
		if (figureType.equals(ChessConstants.PAWN)) {
			i = new Pawn(y, x, c);
		}
	}
}
