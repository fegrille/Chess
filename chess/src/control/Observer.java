package control;

import java.util.List;

import model.IFigure;

public interface Observer {

	void update(List<IFigure> availableFigures, List<Integer[]> availableFields, char tmpCase, List<IFigure> curPlayer, List<IFigure> opPlayer);
}
