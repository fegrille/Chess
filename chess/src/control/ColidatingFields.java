package control;

import java.util.List;

import model.ChessConstants;
import model.IFigure;
import model.Player;

public class ColidatingFields {
	
	private List<Integer[]> fields;
	private List<IFigure> figureList;
	private boolean colidate = false;
	private boolean deleted = false;
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

	public List<IFigure> getFigureList() {
		return figureList;
	}

	public void setFigureList(List<IFigure> figureList) {
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
	
	public void unmovedFigures(IFigure f) {
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
	
	public void colidateOwnFigureHorVer(IFigure f, Player p) {
		setFigureList(p.getFigureList());
		unmovedFigures(f);
		setFields(f.getPosFields());
		checkColiOwnHorVer();
		f.setPosFields(getFields());
	}

	private void checkColiOwnHorVer() {
		for(setCounter(0); getCounter() + 1 < getFields().size(); setCounter(getCounter() + 1)) {
			setDeleted(false);
			int i = getCounter();
			checkColidateHorVer(i);
		}
	}
	
	private void checkColidateHorVerOther(int i) {
		removeUp(i, 1);
		removeDown(i, 1);
		removeLeft(i, 1);
		removeRight(i, 1);
		if(isDeleted()) {
			setCounter(getCounter() - 1);
		}
	}

	private void checkColidateHorVer(int i) {
		removeUp(i, 0);
		removeDown(i, 0);
		removeLeft(i, 0);
		removeRight(i, 0);
		if(isDeleted()) {
			setCounter(getCounter() - 1);
		}
	}
	
	public void colidateOtherFigureDiagonal(IFigure f, Player p) {
		setFigureList(p.getFigureList());
		setFields(f.getPosFields());
		checkColiOtherDiag();
		f.setPosFields(getFields());
	}

	private void checkColiOtherDiag() {
		for(setCounter(0); getCounter() + 1 < getFields().size(); setCounter(getCounter() + 1)) {
			setDeleted(false);
			int i = getCounter();
			checkColidateDiagonalOther(i);
		}
	}
	
	private void checkColidateDiagonalOther(int i) {
		removeRightUp(i,1);
		removeLeftUp(i,1);
		removeRightDown(i,1);
		removeLeftDown(i,1);
		if(isDeleted()) {
			setCounter(getCounter() - 1);
		}
	}

	public void colidateOwnFigureDiagonal(IFigure f, Player p) {
		setFigureList(p.getFigureList());
		unmovedFigures(f);
		setFields(f.getPosFields());
		checkColiOwnDiag();
		f.setPosFields(getFields());
	}

	private void checkColiOwnDiag() {
		for(setCounter(0); getCounter() < getFields().size(); setCounter(getCounter() + 1)) {
			setDeleted(false);
			int i = getCounter();
			checkColidateDiagonal(i);
		}
	}

	private void checkColidateDiagonal(int i) {
		removeRightUp(i,0);
		removeLeftUp(i,0);
		removeRightDown(i,0);
		removeLeftDown(i,0);
		if(isDeleted()) {
			setCounter(getCounter() - 1);
		}
	}
	
	public void colidateOtherFigureHorVer(IFigure f, Player p) {
		setFigureList(p.getFigureList());
		unmovedFigures(f);
		setFields(f.getPosFields());
		checkColiOtherHorVer();
		f.setPosFields(getFields());
	}

	private void checkColiOtherHorVer() {
		for(setCounter(0); getCounter() + 1 < getFields().size(); setCounter(getCounter() + 1)) {
			setDeleted(false);
			int i = getCounter();
			checkColidateHorVerOther(i);
		}
	}
	
	public void removeRightUp(int index, int i) {
		int ind = index + i;
		checkXYnotequalMaxAxis(index);
		if(!getFields().isEmpty() && checkXandYSmaller(index) && colidate(getFields().get(index))) {
			checkXYnotequalMaxAxis(ind);
			while(checkXandYSmaller(ind)) {
				getFields().remove(ind);
				checkXYnotequalMaxAxis(ind);
			}
			if(ind < getFields().size()) {
				removeLastField(ind);
			}
			setDeleted(true);
		}
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
	
	public void removeLeftUp(int index, int i) {
		int ind = index + i;
		checkYnotequalMaxXnotequalMinAxis(index);
		if(!getFields().isEmpty() && checkXgreaterYsmaller(index) && colidate(getFields().get(index))) {
			checkYnotequalMaxXnotequalMinAxis(ind);
			while(checkXgreaterYsmaller(ind)) {
				getFields().remove(ind);
				checkYnotequalMaxXnotequalMinAxis(ind);
			}
			if(ind < getFields().size()) {
				removeLastField(ind);
			}
			setDeleted(true);
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
		boolean b = getX() > getxNext() && getY() < getyNext() && (index + 1) < getFields().size();
		return b;
	}
	
	public void removeRightDown(int index, int i) {
		int ind = index + i;
		checkYnotequalMinXnotequalMaxAxis(index);
		if(!getFields().isEmpty() && checkXsmallerYgreater(index) &&  colidate(getFields().get(index))) {
			checkYnotequalMinXnotequalMaxAxis(ind);
			while(checkXsmallerYgreater(ind)) {
				getFields().remove(ind);
				checkYnotequalMinXnotequalMaxAxis(ind);
			}
			if(ind < getFields().size()) {
				removeLastField(ind);
			}
			setDeleted(true);
		}
	}

	private void removeLastField(int index) {
		if(!getFields().isEmpty()) {
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
	
	public void removeLeftDown(int index, int i) {
		int ind = index + i;
		checkXYnotequalMinAxis(index);
		if(!getFields().isEmpty() && checkXandYGreater(index) && colidate(getFields().get(index))) {
			checkXYnotequalMinAxis(ind);
			while(checkXandYGreater(ind)) {
				getFields().remove(ind);
				checkXYnotequalMinAxis(ind);
			}
			if(ind < getFields().size()) {
				removeLastField(ind);
			}
			setDeleted(true);
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
	
	public void removeUp(int index, int i) {
		int ind = index + i;
		checkYnotequalMaxAxis(index);
		if(!getFields().isEmpty() && checkNextFieldUp(index, getCurKords(), getNextKords()) && colidate(getFields().get(index))) {
			checkYnotequalMaxAxis(ind);
			while(checkNextFieldUp(ind, getCurKords(), getNextKords())) {
				getFields().remove(ind);
				checkYnotequalMaxAxis(ind);
			}
			if(ind < getFields().size()) {
				removeLastField(ind);
			}
			setDeleted(true);
		}
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
	
	public void removeDown(int index, int i) {
		int ind = index + i;
		checkYnotequalMinAxis(index);
		if(!getFields().isEmpty() && checkFieldSmallerUp(index, getCurKords(), getNextKords()) && colidate(getFields().get(index))) {
			checkYnotequalMinAxis(ind);
			while(checkFieldSmallerUp(ind, getCurKords(), getNextKords())) {
				getFields().remove(ind);
				checkYnotequalMinAxis(ind);
			}
			if(ind < getFields().size()) {
				removeLastField(ind);
			}
			setDeleted(true);
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

	public void removeLeft(int index, int i) {
		int ind = index + i;
		checkXnotequalMinAxis(index);
		if(!getFields().isEmpty() && checkFieldSmallerLeft(index, getCurKords(), getNextKords()) && colidate(getFields().get(index))) {
			checkXnotequalMinAxis(ind);
			while(checkFieldSmallerLeft(ind, getCurKords(), getNextKords())) {
				getFields().remove(ind);
				checkXnotequalMinAxis(ind);
			}
			if(ind < getFields().size()) {
				removeLastField(ind);
			}
			setDeleted(true);
		}
	}

	private boolean checkFieldSmallerLeft(int index, int[] kords,
			int[] nextKords) {
		//TODO update methode einfügen
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

	public void removeRight(int index, int i) {
		int ind = index + i;
		checkXnotequalMaxAxis(index);
		if(!getFields().isEmpty() && checkNextFieldRight(index, getCurKords(), getNextKords()) && colidate(getFields().get(index))) {
			checkXnotequalMaxAxis(ind);
			while(checkNextFieldRight(ind, getCurKords(), getNextKords())) {
				getFields().remove(ind);
				checkXnotequalMaxAxis(ind);
			}
			if(ind < getFields().size()) {
				removeLastField(ind);
			}
			setDeleted(true);
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

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
}
