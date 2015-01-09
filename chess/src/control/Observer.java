package control;

import java.util.List;

import model.IFigure;

public interface Observer {

	public void update(List<IFigure> availableFigures, List<Integer[]> availableFields, char tmpCase);
}
