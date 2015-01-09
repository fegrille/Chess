package model;

public class FigureFactory {

	// use getFigure method to get object of type Figure
	public Figure getFigure(String figureType, int y, int x, char c) {
		if (figureType.equals(ChessConstants.PAWN)) {
			return new Pawn(y, x, c);
		}
		if (figureType.equals(ChessConstants.KING)) {
			return new King(y, x, c);
		}
		if (figureType.equals(ChessConstants.BISHOP)) {
			return new Bishop(y, x, c);
		}
		if (figureType.equals(ChessConstants.KNIGHT)) {
			return new Knight(y, x, c);
		}
		if (figureType.equals(ChessConstants.QUEEN)) {
			return new Queen(y, x, c);
		}
		if (figureType.equals(ChessConstants.ROOK)) {
			return new Rook(y, x, c);
		}
		return null;
	}
}
