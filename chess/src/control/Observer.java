package control;

import java.util.List;

import model.IFigure;
/**
 * 
 * @author Felix
 *
 */
public interface Observer {

	/**
	 * 
	 * @param availableFigures
	 * @param availableFields
	 * @param tmpCase
	 * @param curPlayer
	 * @param opPlayer
	 */
	void update(List<IFigure> availableFigures, List<Integer[]> availableFields, char tmpCase, List<IFigure> curPlayer, List<IFigure> opPlayer);
}
