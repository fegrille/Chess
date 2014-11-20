package control;

import java.util.List;

import model.ChessConstants;
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
	
	public List<Integer[]> colidateOwnFigureHorVer(Figure f, List<Integer[]> pf, Player p) {
		unmovedFigures(f);
		setPossibleFields(pf);
		setFigureList(p.getFigureList());
		for(int i = 0; i < getPossibleFields().size(); i++) {
			if(colidate(getPossibleFields().get(i))) {
				removeUp(i);
				removeDown(i);
				removeLeft(i);
				removeRight(i);
			}
		}
		return getPossibleFields();
	}
	
	public List<Integer[]> colidateOtherFigureHorVer(Figure f, List<Integer[]> pf, Player p) {
		unmovedFigures(f);
		setPossibleFields(pf);
		setFigureList(p.getFigureList());
		for(int i = 0; i < getPossibleFields().size(); i++) {
			if(colidate(getPossibleFields().get(i)) && (i + 1) < getPossibleFields().size()) {
				removeUp(i + 1);
				removeDown(i + 1);
				removeLeft(i + 1);
				removeRight(i + 1);
			}
		}
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
	
	private void removeUp(int index) {
		int y = getPossibleFields().get(index)[0];
		int yNext = getPossibleFields().get(index + 1)[0];
		getPossibleFields().remove(index);
		while(y < yNext && (index + 1) < getPossibleFields().size() || y == ChessConstants.MAXAXIS) {
			if(y != ChessConstants.MAXAXIS) {
				y = getPossibleFields().get(index)[0];
				yNext = getPossibleFields().get(index + 1)[0];
			}
			getPossibleFields().remove(index);
		}
	}
	
	private void removeDown(int index) {
		int y = getPossibleFields().get(index)[0];
		int yNext = getPossibleFields().get(index + 1)[0];
		getPossibleFields().remove(index);
		while(y > yNext && (index + 1) < getPossibleFields().size() || y == ChessConstants.MINAXIS) {
			if(y != ChessConstants.MINAXIS) {
				y = getPossibleFields().get(index)[0];
				yNext = getPossibleFields().get(index + 1)[0];
			}
			getPossibleFields().remove(index);
		}
	}

	private void removeLeft(int index) {
		int x = getPossibleFields().get(index)[1];
		int xNext = getPossibleFields().get(index + 1)[1];
		getPossibleFields().remove(index);
		while(x > xNext && (index + 1) < getPossibleFields().size() || x == ChessConstants.MINAXIS) {
			if(x != ChessConstants.MINAXIS) {
				x = getPossibleFields().get(index)[0];
				xNext = getPossibleFields().get(index + 1)[0];
			}
			getPossibleFields().remove(index);
		}
	}

	private void removeRight(int index) {
		int x = getPossibleFields().get(index)[1];
		int xNext = getPossibleFields().get(index + 1)[1];
		getPossibleFields().remove(index);
		while(x < xNext && (index + 1) < getPossibleFields().size() || x == ChessConstants.MAXAXIS) {
			if(x != ChessConstants.MAXAXIS) {
				x = getPossibleFields().get(index)[0];
				xNext = getPossibleFields().get(index + 1)[0];
			}
			getPossibleFields().remove(index);
		}
	}
	
	private void removeRightUp(int index) {
		int x = getPossibleFields().get(index)[1];
		int xNext = getPossibleFields().get(index + 1)[1];
		int y = getPossibleFields().get(index)[0];
		int yNext = getPossibleFields().get(index + 1)[0];
		getPossibleFields().remove(index);
		while(x < xNext && y < yNext && (index + 1) < getPossibleFields().size() || y == ChessConstants.MAXAXIS && x == ChessConstants.MAXAXIS) {
			if(y != ChessConstants.MAXAXIS && x != ChessConstants.MAXAXIS) {
				x = getPossibleFields().get(index)[0];
				xNext = getPossibleFields().get(index + 1)[0];
				y = getPossibleFields().get(index)[0];
				yNext = getPossibleFields().get(index + 1)[0];
			}
			getPossibleFields().remove(index);
		}
	}
	
    private void removeLeftUp(int index) {
    	int x = getPossibleFields().get(index)[1];
		int xNext = getPossibleFields().get(index + 1)[1];
		int y = getPossibleFields().get(index)[0];
		int yNext = getPossibleFields().get(index + 1)[0];
		getPossibleFields().remove(index);
		while(x > xNext && y < yNext && (index + 1) < getPossibleFields().size() || y == ChessConstants.MAXAXIS && x == ChessConstants.MINAXIS) {
			if(y != ChessConstants.MAXAXIS && x != ChessConstants.MINAXIS) {
				x = getPossibleFields().get(index)[0];
				xNext = getPossibleFields().get(index + 1)[0];
				y = getPossibleFields().get(index)[0];
				yNext = getPossibleFields().get(index + 1)[0];
			}
			getPossibleFields().remove(index);
		}
	}
    
    private void removeRightDown(int index) {
    	int x = getPossibleFields().get(index)[1];
		int xNext = getPossibleFields().get(index + 1)[1];
		int y = getPossibleFields().get(index)[0];
		int yNext = getPossibleFields().get(index + 1)[0];
		getPossibleFields().remove(index);
		while(x < xNext && y > yNext && (index + 1) < getPossibleFields().size() || y == ChessConstants.MINAXIS && x == ChessConstants.MAXAXIS) {
			if(y != ChessConstants.MINAXIS && x != ChessConstants.MAXAXIS) {
				x = getPossibleFields().get(index)[0];
				xNext = getPossibleFields().get(index + 1)[0];
				y = getPossibleFields().get(index)[0];
				yNext = getPossibleFields().get(index + 1)[0];
			}
			getPossibleFields().remove(index);
		}
    }
    
    private void removeLeftDown(int index) {
    	int x = getPossibleFields().get(index)[1];
		int xNext = getPossibleFields().get(index + 1)[1];
		int y = getPossibleFields().get(index)[0];
		int yNext = getPossibleFields().get(index + 1)[0];
		getPossibleFields().remove(index);
		while(x > xNext && y > yNext && (index + 1) < getPossibleFields().size() || y == ChessConstants.MINAXIS && x == ChessConstants.MINAXIS) {
			if(x != ChessConstants.MINAXIS && y != ChessConstants.MINAXIS) {
				x = getPossibleFields().get(index)[0];
				xNext = getPossibleFields().get(index + 1)[0];
				y = getPossibleFields().get(index)[0];
				yNext = getPossibleFields().get(index + 1)[0];
			}
			getPossibleFields().remove(index);
		}
    }

}
