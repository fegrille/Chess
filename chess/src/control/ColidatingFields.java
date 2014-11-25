package control;

import java.util.List;

import model.ChessConstants;
import model.Figure;
import model.Player;

public class ColidatingFields {
	
	private List<Integer[]> fields;
	private List<Figure> figureList;
	private boolean colidate = false;
	private int x;
	private int y;
	private int xNext;
	private int yNext;
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getxNext() {
		return xNext;
	}

	public void setxNext(int xNext) {
		this.xNext = xNext;
	}

	public int getyNext() {
		return yNext;
	}

	public void setyNext(int yNext) {
		this.yNext = yNext;
	}

	public List<Figure> getFigureList() {
		return figureList;
	}

	public void setFigureList(List<Figure> figureList) {
		this.figureList = figureList;
	}
	private void setColidate(boolean b) {
		this.colidate = b;
	}
	
	public boolean isColidate() {
		return colidate;
	}
	
	public List<Integer[]> getFields() {
		return fields;
	}
	
	public void setFields(List<Integer[]> fields) {
		this.fields = fields;
	}
	
	public void unmovedFigures(Figure f) {
		int[] fPos = f.getField();
		for(int i = 0; i < getFigureList().size(); i++) {
			int[] figPos = getFigureList().get(i).getField();
			removeFigure(fPos, i, figPos);
		}
	}

	private void removeFigure(int[] fPos, int i, int[] figPos) {
		if(fPos[0] == figPos[0] && fPos[1] == figPos[1]) {
			getFigureList().remove(i);
		}
	}
	
	public boolean colidate(Integer[] posF) {
		checkColidateFigures(posF);
		return isColidate();
	}

	private void checkColidateFigures(Integer[] posF) {
		for(int i = 0; i < getFigureList().size(); i++) {
			int[] position = getFigureList().get(i).getField();
			checkColidatePosition(posF, position);
		}
	}

	private void checkColidatePosition(Integer[] posF, int[] position) {
		if(posF[0] == position[0] && posF[1] == position[1]) {
			setColidate(true);
		}
	}
	
	public List<Integer[]> colidateOwnFigureHorVer(Figure f, List<Integer[]> pf, Player p) {
		setFigureList(p.getFigureList());
		unmovedFigures(f);
		setFields(pf);
		checkColiOwnHorVer();
		return getFields();
	}

	private void checkColiOwnHorVer() {
		for(int i = 0; i < getFields().size(); i++) { 
			checkColidateHorVer(i);
		}
	}
	
	private void checkColidateHorVer(int i) {
		if(colidate(getFields().get(i))) {
			removeUp(i);
			removeDown(i);
			removeLeft(i);
			removeRight(i);
		}
	}
	
	public List<Integer[]> colidateOtherFigureDiagonal(Figure f, List<Integer[]> pf, Player p) {
		setFigureList(p.getFigureList());
		unmovedFigures(f);
		setFields(pf);
		checkColiOtherDiag();
		return getFields();
	}

	private void checkColiOtherDiag() {
		for(int i = 0; i < getFields().size(); i++) {
			checkColidateDiagonal(i);
		}
	}
	
	public List<Integer[]> colidateOwnFigureDiagonal(Figure f, List<Integer[]> pf, Player p) {
		setFigureList(p.getFigureList());
		unmovedFigures(f);
		setFields(pf);
		checkColiOwnDiag();
		return getFields();
	}

	private void checkColiOwnDiag() {
		for(int i = 0; i < getFields().size(); i++) {
			checkColidateDiagonal(i + 1);
		}
	}

	private void checkColidateDiagonal(int i) {
		if(colidate(getFields().get(i))) {
			removeRightUp(i);
			removeLeftUp(i);
			removeRightDown(i);
			removeLeftDown(i);
		}
	}
	
	public List<Integer[]> colidateOtherFigureHorVer(Figure f, List<Integer[]> pf, Player p) {
		setFigureList(p.getFigureList());
		unmovedFigures(f);
		setFields(pf);
		checkColiOtherHorVer();
		return getFields();
	}

	private void checkColiOtherHorVer() {
		for(int i = 0; i < getFields().size(); i++) {
			checkColidateHorVer(i + 1);
		}
	}
	
	public void removeRightUp(int index) {
		int x = getFields().get(index)[1];
		int xNext = getFields().get(index + 1)[1];
		int y = getFields().get(index)[0];
		int yNext = getFields().get(index + 1)[0];
		getFields().remove(index);
		while(checkXandYSmaller(index, x, xNext, y, yNext) || y == ChessConstants.MAXAXIS && x == ChessConstants.MAXAXIS) {
			if(y != ChessConstants.MAXAXIS && x != ChessConstants.MAXAXIS) {
				x = getFields().get(index)[0];
				xNext = getFields().get(index + 1)[0];
				y = getFields().get(index)[0];
				yNext = getFields().get(index + 1)[0];
			}
			getFields().remove(index);
		}
	}
	
	private boolean checkXandYSmaller(int index, int x, int xNext,
			int y, int yNext) {
		return x < xNext && y < yNext && (index + 1) < getFields().size();
	}
	
	public void removeLeftUp(int index) {
		int x = getFields().get(index)[1];
		int xNext = getFields().get(index + 1)[1];
		int y = getFields().get(index)[0];
		int yNext = getFields().get(index + 1)[0];
		getFields().remove(index);
		while(checkXgreaterYsmaller(index, x, xNext, y, yNext) || y == ChessConstants.MAXAXIS && x == ChessConstants.MINAXIS) {
			if(y != ChessConstants.MAXAXIS && x != ChessConstants.MINAXIS) {
				x = getFields().get(index)[0];
				xNext = getFields().get(index + 1)[0];
				y = getFields().get(index)[0];
				yNext = getFields().get(index + 1)[0];
			}
			getFields().remove(index);
		}
	}
	
	private boolean checkXgreaterYsmaller(int index, int x, int xNext, int y,
			int yNext) {
		return x > xNext && y < yNext && (index + 1) < getFields().size();
	}
	
	public void removeRightDown(int index) {
		setX(getFields().get(index)[1]);
		setxNext(getFields().get(index + 1)[1]);
		int y = getFields().get(index)[0];
		int yNext = getFields().get(index + 1)[0];
		getFields().remove(index);
		while(checkXsmallerYgreater(index, x, xNext, y, yNext) || y == ChessConstants.MINAXIS && x == ChessConstants.MAXAXIS) {
			if(y != ChessConstants.MINAXIS && x != ChessConstants.MAXAXIS) {
				setX(getFields().get(index)[0]);
				setxNext(getFields().get(index + 1)[0]);
				y = getFields().get(index)[0];
				yNext = getFields().get(index + 1)[0];
			}
			getFields().remove(index);
		}
	}
	
	private boolean checkXsmallerYgreater(int index, int x, int xNext, int y,
			int yNext) {
		return x < xNext && y > yNext && (index + 1) < getFields().size();
	}
	
	public void removeLeftDown(int index) {
		int x = getFields().get(index)[1];
		setxNext(getFields().get(index + 1)[1]);
		int y = getFields().get(index)[0];
		int yNext = getFields().get(index + 1)[0];
		getFields().remove(index);
		while(checkXandYGreater(index, x, xNext, y, yNext) || y == ChessConstants.MINAXIS && x == ChessConstants.MINAXIS) {
			if(x != ChessConstants.MINAXIS && y != ChessConstants.MINAXIS) {
				x = getFields().get(index)[0];
				setxNext(getFields().get(index + 1)[0]);
				y = getFields().get(index)[0];
				yNext = getFields().get(index + 1)[0];
			}
			getFields().remove(index);
		}
	}
	
	private boolean checkXandYGreater(int index, int x, int xNext, int y,
			int yNext) {
		return x > xNext && y > yNext && (index + 1) < getFields().size();
	}
	
	public void removeUp(int index) {
		setY(getFields().get(index)[0]);
		setyNext(getFields().get(index + 1)[0]);
		getFields().remove(index);
		while(checkNextFieldGrater(index, getY(), getyNext()) || getY() == ChessConstants.MAXAXIS) {
			if(getY() != ChessConstants.MAXAXIS) {
				setY(getFields().get(index)[0]);
				setyNext(getFields().get(index + 1)[0]);
			}
			getFields().remove(index);
		}
	}
	
	public void removeDown(int index) {
		setY(getFields().get(index)[0]);
		setyNext(getFields().get(index + 1)[0]);
		getFields().remove(index);
		while(checkFieldSmaller(index, getY(), getyNext()) || getY() == ChessConstants.MINAXIS) {
			if(getY() != ChessConstants.MINAXIS) {
				setY(getFields().get(index)[0]);
				setyNext(getFields().get(index + 1)[0]);
			}
			getFields().remove(index);
		}
	}

	public void removeLeft(int index) {
		setX(getFields().get(index)[1]);
		setxNext(getFields().get(index + 1)[1]);
		getFields().remove(index);
		while(checkFieldSmaller(index, getX(), getxNext()) || getX() == ChessConstants.MINAXIS) {
			if(getX() != ChessConstants.MINAXIS) {
				setX(getFields().get(index)[0]);
				setxNext(getFields().get(index + 1)[0]);
			}
			getFields().remove(index);
		}
	}

	private boolean checkFieldSmaller(int index, int kord, int nextKord) {
		return kord > nextKord && (index + 1) < getFields().size();
	}

	public void removeRight(int index) {
		setX(getFields().get(index)[1]);
		setxNext(getFields().get(index + 1)[1]);
		getFields().remove(index);
		while(checkNextFieldGrater(index, getX(), getxNext()) || getX() == ChessConstants.MAXAXIS) {
			if(getX() != ChessConstants.MAXAXIS) {
				setX(getFields().get(index)[0]);
				setxNext(getFields().get(index + 1)[0]);
			}
			getFields().remove(index);
		}
	}

	private boolean checkNextFieldGrater(int index, int kord , int nextKord) {
		return kord < nextKord && (index + 1) < getFields().size();
	}
}
