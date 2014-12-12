package control;

import java.util.List;

import model.ChessConstants;
import model.Figure;
import model.Player;

public class ColidatingFields {
	
	private List<Integer[]> fields;
	private List<Figure> figureList;
	private boolean colidate = false;
	private int counter;
	private int x;
	private int y;
	private int xNext;
	private int yNext;
	private int[] curKords = new int[ChessConstants.FIGUREFIELDSIZE];
	private int[] nextKords = new int[ChessConstants.FIGUREFIELDSIZE];
	
	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}
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
		int[] cords = f.getField();
		for(setCounter(0); getCounter() < getFigureList().size(); setCounter(getCounter() + 1)) {
			int[] figPos = getFigureList().get(getCounter()).getField();
			removeFigure(cords,figPos);
		}
	}

	private void removeFigure(int[] fPos,int[] figPos) {
		if(fPos[0] == figPos[0] && fPos[1] == figPos[1]) {
			getFigureList().remove(getCounter());
			setCounter(getCounter() - 1);
		}
	}
	
	public boolean colidate(Integer[] posF) {
		setColidate(false);
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
		if(equalsArray(posF, position)) {
			setColidate(true);
		}
	}
	
	public void colidateOwnFigureHorVer(Figure f, Player p) {
		setFigureList(p.getFigureList());
		unmovedFigures(f);
		setFields(f.getPosFields());
		checkColiOwnHorVer();
		f.setPosFields(getFields());
	}

	private void checkColiOwnHorVer() {
		for(int i = 0; i < getFields().size(); i++) { 
			checkColidateHorVer(i);
		}
	}
	
	private void checkColiOtherIndex(int i) {
		if( i < getFields().size()) {
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
	
	public void colidateOtherFigureDiagonal(Figure f, Player p) {
		setFigureList(p.getFigureList());
		unmovedFigures(f);
		setFields(f.getPosFields());
		checkColiOtherDiag();
		f.setPosFields(getFields());
	}

	private void checkColiOtherDiag() {
		for(int i = 0; i < getFields().size(); i++) {
			checkColidateDiagonal(i);
		}
	}
	
	public void colidateOwnFigureDiagonal(Figure f, Player p) {
		setFigureList(p.getFigureList());
		unmovedFigures(f);
		setFields(f.getPosFields());
		checkColiOwnDiag();
		f.setPosFields(getFields());
	}

	private void checkColiOwnDiag() {
		for(int i = 0; i < getFields().size(); i++) {
			checkColidateDiagonal(i);
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
	
	public void colidateOtherFigureHorVer(Figure f, Player p) {
		setFigureList(p.getFigureList());
		unmovedFigures(f);
		setFields(f.getPosFields());
		checkColiOtherHorVer();
		f.setPosFields(getFields());
	}

	private void checkColiOtherHorVer() {
		for(int i = 0; i < getFields().size(); i++) {
			checkColiOtherIndex(i + 1);
		}
	}
	
	public void removeRightUp(int index) {
		checkXYnotequalMaxAxis(index);
		getFields().remove(index);
		while(checkXandYSmaller(index) || cordsAtLimit(ChessConstants.MAXAXIS,ChessConstants.MAXAXIS)) {
			checkXYnotequalMaxAxis(index);
			getFields().remove(index);
		}
	}

	private boolean cordsAtLimit(int yLimit , int xLimit) {
		return getY() == yLimit && getX() == xLimit;
	}

	private void checkXYnotequalMaxAxis(int index) {
		if(getY() != ChessConstants.MAXAXIS && getX() != ChessConstants.MAXAXIS && (index + 1) < getFields().size()) {
			setYKords(index);
			setXKords(index);
			setCurKords();
			setNextKords();
		}
	}
	
	private boolean checkXandYSmaller(int index) {
		return getX() < getxNext() && getY() < getyNext() && (index + 1) < getFields().size();
	}
	
	public void removeLeftUp(int index) {
		checkYnotequalMaxXnotequalMinAxis(index);
		getFields().remove(index);
		while(checkXgreaterYsmaller(index) || cordsAtLimit(ChessConstants.MAXAXIS,ChessConstants.MINAXIS)) {
			checkYnotequalMaxXnotequalMinAxis(index);
			getFields().remove(index);
		}
	}

	private void checkYnotequalMaxXnotequalMinAxis(int index) {
		if(getY() != ChessConstants.MAXAXIS && getX() != ChessConstants.MINAXIS && (index + 1) < getFields().size()) {
			setYKords(index);
			setXKords(index);
			setCurKords();
			setNextKords();
		}
	}
	
	private boolean checkXgreaterYsmaller(int index) {
		return getX() > getxNext() && getY() < getyNext() && (index + 1) < getFields().size();
	}
	
	public void removeRightDown(int index) {
		checkYnotequalMinXnotequalMaxAxis(index);
		getFields().remove(index);
		while(checkXsmallerYgreater(index) || cordsAtLimit(ChessConstants.MINAXIS,ChessConstants.MAXAXIS)) {
			checkYnotequalMinXnotequalMaxAxis(index);
			getFields().remove(index);
		}
	}

	private void checkYnotequalMinXnotequalMaxAxis(int index) {
		if(getY() != ChessConstants.MINAXIS && getX() != ChessConstants.MAXAXIS && (index + 1) < getFields().size()) {
			setYKords(index);
			setXKords(index);
			setCurKords();
			setNextKords();
		}
	}
	
	private boolean checkXsmallerYgreater(int index) {
		return getX() < getxNext() && getY() > getyNext() && (index + 1) < getFields().size();
	}
	
	public void removeLeftDown(int index) {
		checkXYnotequalMinAxis(index);
		getFields().remove(index);
		while(checkXandYGreater(index) || cordsAtLimit(ChessConstants.MINAXIS,ChessConstants.MINAXIS)) {
			checkXYnotequalMinAxis(index);
			getFields().remove(index);
		}
	}

	private void checkXYnotequalMinAxis(int index) {
		if(getX() != ChessConstants.MINAXIS && getY() != ChessConstants.MINAXIS && (index + 1) < getFields().size()) {
			setYKords(index);
			setXKords(index);
			setCurKords();
			setNextKords();
		}
	}
	
	private boolean checkXandYGreater(int index) {
		return getX() > getxNext() && getY() > getyNext() && (index + 1) < getFields().size();
	}
	
	public void removeUp(int index) {
		checkYnotequalMaxAxis(index);
		getFields().remove(index);
		while(checkNextFieldUp(index, getCurKords(), getNextKords()) || cordAtLimit(index, getY(), ChessConstants.MAXAXIS)) {
			checkYnotequalMaxAxis(index);
			getFields().remove(index);
		}
	}

	private boolean cordAtLimit(int index, int cord, int limit) {
		return cord == limit && (index + 1) > getFields().size();
	}

	private void checkYnotequalMaxAxis(int index) {
		if(getY() != ChessConstants.MAXAXIS && (index + 1) < getFields().size()) {
			setYKords(index);
			setXKords(index);
			setCurKords();
			setNextKords();
		}
	}

	private void setYKords(int index) {
		setY(getFields().get(index)[0]);
		setyNext(getFields().get(index + 1)[0]);
		
	}
	
	public void removeDown(int index) {
		checkYnotequalMinAxis(index);
		getFields().remove(index);
		while(checkFieldSmallerUp(index, getCurKords(), getNextKords()) || cordAtLimit(index, getY(), ChessConstants.MINAXIS)) {
			checkYnotequalMinAxis(index);
			getFields().remove(index);
		}
	}

	private void checkYnotequalMinAxis(int index) {
		if(getY() != ChessConstants.MINAXIS && (index + 1) < getFields().size()) {
			setYKords(index);
			setXKords(index);
			setCurKords();
			setNextKords();
		}
	}

	public void removeLeft(int index) {
		checkXnotequalMinAxis(index);
		getFields().remove(index);
		while(checkFieldSmallerLeft(index, getCurKords(), getNextKords()) || cordAtLimit(index, getX(), ChessConstants.MINAXIS)) {
			checkXnotequalMinAxis(index);
			getFields().remove(index);
		}
	}

	private boolean checkFieldSmallerLeft(int index, int[] kords,
			int[] nextKords) {
		return kords[1] > nextKords[1] && kords[0] == nextKords[0]&& (index + 1) < getFields().size();
	}

	private void checkXnotequalMinAxis(int index) {
		if(getX() != ChessConstants.MINAXIS && (index + 1) > getFields().size()) {
			setYKords(index);
			setXKords(index);
			setCurKords();
			setNextKords();
		}
	}

	private void setXKords(int index) {
		setX(getFields().get(index)[1]);
		setxNext(getFields().get(index + 1)[1]);
	}

	private boolean checkFieldSmallerUp(int index, int[] kords, int[] nextKords) {
		return kords[0] > nextKords[0] && kords[1] == nextKords[1]&& (index + 1) < getFields().size();
	}

	public void removeRight(int index) {
		checkXnotequalMaxAxis(index);
		getFields().remove(index);
		while(checkNextFieldRight(index, getCurKords(), getNextKords()) || cordAtLimit(index, getX(), ChessConstants.MAXAXIS)) {
			checkXnotequalMaxAxis(index);
			getFields().remove(index);
		}
	}

	private boolean checkNextFieldRight(int index, int[] kords,
			int[] nextKords) {
		return kords[1] < nextKords[1] && kords[0] == nextKords[0] && (index + 1) < getFields().size();
	}

	private void checkXnotequalMaxAxis(int index) {
		if(getX() != ChessConstants.MAXAXIS && (index + 1) > getFields().size()) {
			setYKords(index);
			setXKords(index);
			setCurKords();
			setNextKords();
		}
	}

	private boolean checkNextFieldUp(int index, int[] kords, int[] nextKords) {
		return kords[0] < nextKords[0] && kords[1] == nextKords[1] && (index + 1) < getFields().size();
	}
	
	private boolean equalsArray(Integer[] arr1, int[] arr2) {
		boolean equals = false;
		if(arr1[0] == arr2[0] && arr1[1] == arr2[1]) {
			equals = true;
		}
		return equals;
	}

	public int[] getNextKords() {
		return nextKords;
	}

	public void setNextKords() {
		this.nextKords[0] = getyNext();
		this.nextKords[1] = getxNext();
	}

	public int[] getCurKords() {
		return curKords;
	}

	public void setCurKords() {
		this.curKords[0] = getY();
		this.curKords[1] = getX();
	}
}
