package control;

import java.util.List;

import model.Figure;
import model.Player;

public class ControlColidate {
	
	private List<Integer[]> possibleFields;
	private List<Figure> figureList;
	
	public List<Figure> getFigureList() {
		return figureList;
	}

	public void setFigureList(List<Figure> figureList) {
		this.figureList = figureList;
	}

	public List<Integer[]> getPossibleFields() {
		return possibleFields;
	}

	public void setPossibleFields(List<Integer[]> possibleFields) {
		this.possibleFields = possibleFields;
	}

	public List<Integer[]> colidateFigurePawn(Figure f, List<Integer[]> pf, Player p) {
		unmovedFigures(f);
		setPossibleFields(pf);
		setFigureList(p.getFigureList());
		for(int i = 0; i < getPossibleFields().size(); i++) {
			if(colidate(getPossibleFields().get(i))) {
				removeFieldsPawn(getPossibleFields().get(i),f.getColor());
			}
		}
		return getPossibleFields();
	}
	
	public List<Integer[]> colidateOwnFigureRook(Figure f, List<Integer[]> pf, Player p) {
		unmovedFigures(f);
		setPossibleFields(pf);
		setFigureList(p.getFigureList());
		
		return getPossibleFields();
	}
	
	public List<Integer[]> colidateOtherFigureRook(Figure f, List<Integer[]> pf, Player p) {
		unmovedFigures(f);
		setPossibleFields(pf);
		setFigureList(p.getFigureList());
		
		return getPossibleFields();
	}
	
	public void unmovedFigures(Figure f) {
		int[] fPos = f.getField();
		for(int i = 0; i < getFigureList().size(); i++) {
			int[] figPos = getFigureList().get(i).getField();
			if(fPos[0] == figPos[0] && fPos[1] == figPos[1]) {
				getFigureList().remove(i);
			}
		}
	}
	
	public boolean colidate(Integer[] posF) {
		boolean col = false;
		for(int i = 0; i < getFigureList().size(); i++) {
			int[] position = getFigureList().get(i).getField();
			if(posF[0] == position[0] && posF[1] == position[1]) {
				col = true;
				break;
			}
		}
		return col;
	}
	
	public void removeFieldsPawn(Integer[] colField, char color) {
		for(int i = 0; i < getPossibleFields().size(); i++) {
			removeFieldForColor(colField, i, color);
		}
	}
	
	public void removeFieldForColor(Integer[] colField, int index, char color) {
		Integer[] position = getPossibleFields().get(index);
		if(color == 'b') {
			removeForBlack(colField, index, position);
		} else {
			removeForWhite(colField, index, position);
		}
	}

	private void removeForWhite(Integer[] colField, int index, Integer[] position) {
		if(position[0] == colField[0] && position[1] == colField[1] || position[0] > colField[0]) {
			getPossibleFields().remove(index);
		}
	}

	private void removeForBlack(Integer[] colField, int index, Integer[] position) {
		if(position[0] == colField[0] && position[1] == colField[1] || position[0] < colField[0]) {
			getPossibleFields().remove(index);
		}
	}

}
