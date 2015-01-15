package control;

import model.ChessConstants;
import model.IFigure;
/**
 * 
 * @author Felix
 *
 */
public class ControlPawn implements IControlPawn{
	
	private boolean endField = false;
	
	/**
	 * 
	 * @return
	 */
	public boolean isEndField() {
		return endField;
	}

	/**
	 * 
	 * @param endField
	 */
	public void setEndField(boolean endField) {
		this.endField = endField;
	}


	/**
	 * 
	 * @param pawn
	 * @return
	 */
	@Override
	public boolean checkEndfield(IFigure pawn) {
		setEndField(false);
		int y = pawn.getY();
		int color = pawn.getColor();
		checkEndFieldWhite(y, color);
		checkEndFieldBlack(y, color);
		return isEndField();
	}

	/**
	 * 
	 * @param y
	 * @param color
	 */
	private void checkEndFieldWhite(int y, int color) {
		if(color == 'w' && y == ChessConstants.MAXAXIS) {
			setEndField(true);
		}
	}

	/**
	 * 
	 * @param y
	 * @param color
	 */
	private void checkEndFieldBlack(int y, int color) {
		if(color == 'b'&& y == ChessConstants.MINAXIS) {
			setEndField(true);
		}
	}

}