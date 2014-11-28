package control;

import java.util.Arrays;
import java.util.List;

import model.Figure;
import model.Player;

public class ControlColidatePawn {
	
	private ColidatingFields coli = new ColidatingFields();
	private List<Integer[]> fields;
	private List<Figure> figureList;
	
	public ColidatingFields getColi() {
		return coli;
	}

	public void setColi(ColidatingFields coli) {
		this.coli = coli;
	}
	public List<Figure> getFigureList() {
		return figureList;
	}

	public void setFigureList(List<Figure> figureList) {
		this.figureList = figureList;
	}

	public List<Integer[]> getFields() {
		return fields;
	}
	
	public void setFields(List<Integer[]> fields) {
		this.fields = fields;
	}
	
	public List<Integer[]> colidateOwnFigurePawn(Figure f, List<Integer[]> pf, Player p, Player p2) {
		setFigureList(p.getFigureList());
		getColi().setFigureList(getFigureList());
		getColi().unmovedFigures(f);
		setFigureList(getColi().getFigureList());
		setFields(pf);
		checkColidation(f);
		return getFields();
	}

	private void checkColidateOwn() {
		for(int i = 0; i < getFields().size(); i++) {
			checkColidateOwnFigurePawn(i);
		}
	}
	
	private void checkColidateOwnFigurePawn(int i) {
		if(getColi().colidate(getFields().get(i))) {
			getFields().remove(i);
		}
	}
	
	private void checkColidation(Figure f) {
		for(int i = 0; i < getFields().size(); i++) {
			checkColidatePawn(f, i);
		}
	}
	
	private void checkColidatePawn(Figure f, int i) {
		if(getColi().colidate(getFields().get(i))) {
			removeFieldsPawn(getFields().get(i),f.getColor());
		}
	}
	
	public void removeFieldsPawn(Integer[] colField, char color) {
		for(int i = 0; i < getFields().size(); i++) {
			isBlack(colField, i, color);
			isWhite(colField, i, color);
		}
	}
	
	private void isBlack(Integer[] colField, int index, char color) {
		Integer[] position = getFields().get(index);
		if(color == 'b') {
			removeForBlack(colField, index, position);
		}
	}
	
	private void isWhite(Integer[] colField, int index, char color) {
		Integer[] position = getFields().get(index);
		if(color == 'w') {
			removeForWhite(colField, index, position);
		}
	}

	private void removeForWhite(Integer[] colField, int index, Integer[] position) {
		if(Arrays.equals(colField, position) || position[0] > colField[0]) {
			getFields().remove(index);
		}
	}

	private void removeForBlack(Integer[] colField, int index, Integer[] position) {
		if(Arrays.equals(colField, position) || position[0] < colField[0]) {
			getFields().remove(index);
		}
	}

}
