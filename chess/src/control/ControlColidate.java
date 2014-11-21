package control;

import java.util.List;

import model.Bishop;
import model.ChessConstants;
import model.Figure;
import model.King;
import model.Knight;
import model.Pawn;
import model.Player;
import model.Queen;
import model.Rook;

public class ControlColidate {
	
	private List<Integer[]> possibleFields;
	private List<Figure> figureList;
	private boolean colidate = false;
	
	public boolean isColidate() {
		return colidate;
	}
	
	public  List<Integer[]> colidate(Figure f, List<Integer[]> pf, Player p, Player p2) {
		return getPossibleFields(); 
	}
	
	public void isPawn(Figure f, List<Integer[]> pf, Player p, Player p2) {
		if(f instanceof Pawn) {
			colidateFigurePawn(f,pf,p,p2);
		}
	}
	
	public void isRook(Figure f, List<Integer[]> pf, Player p, Player p2) {
		if(f instanceof Rook) {
			colidateOwnFigureHorVer(f,pf,p);
			colidateOtherFigureHorVer(f,pf,p2);
		}
	}
	
	public void isBishop(Figure f, List<Integer[]> pf, Player p, Player p2) {
		if(f instanceof Bishop) {
			colidateOwnFigureDiagonal(f,pf,p);
			colidateOtherFigureDiagonal(f,pf,p2);
		}
	}
	
	public void isKnight(Figure f, List<Integer[]> pf, Player p, Player p2) {
		if(f instanceof Knight) {
			colidateFigurePawn(f,pf,p,p2);
		}
	}
	
	public void isQueen(Figure f, List<Integer[]> pf, Player p, Player p2) {
		if(f instanceof Queen) {
			colidateOwnFigureHorVer(f,pf,p);
			colidateOtherFigureHorVer(f,pf,p2);
			colidateOwnFigureDiagonal(f,pf,p);
			colidateOtherFigureDiagonal(f,pf,p2);
		}
	}
	
	public void isKing(Figure f, List<Integer[]> pf, Player p, Player p2) {
		if(f instanceof King) {
			colidateOwnFigureKing(f,pf,p);
			colidateOtherFigureKing(f,pf,p2);
		}
	}
	
	private void colidateOwnFigureKing(Figure f, List<Integer[]> pf, Player p) {
		unmovedFigures(f);
		setPossibleFields(pf);
		setFigureList(p.getFigureList());
		for(int i = 0; i < getPossibleFields().size(); i++) {
			checkColidateOwnFigureKing(f, i);
		}
	}
	
	private void checkColidateOwnFigureKing(Figure f, int i) {
		if(colidate(getPossibleFields().get(i))) {
			getPossibleFields().remove(i);
		}
	}
	
	private void colidateOtherFigureKing(Figure f, List<Integer[]> pf, Player p) {
		unmovedFigures(f);
		setPossibleFields(pf);
		setFigureList(p.getFigureList());
		for(int i = 0; i < getPossibleFields().size(); i++) {
			checkColidateOtherFigureKing(f,i,p);
		}
	}
	
	private void checkColidateOtherFigureKing(Figure f, int i, Player p) {
		if(colidate(getPossibleFields().get(i))) {
			blockedField(i, p);
		}
		
	}

	private void blockedField(int i, Player p) {
		if(isFieldBlocked(p,getPossibleFields().get(i)[0], getPossibleFields().get(i)[1])) {
			getPossibleFields().remove(i);
		}
	}
	
	private boolean isFieldBlocked(Player p, int y, int x) {
		boolean blocked = true;
		for(Figure f : p.getFigureList()) {
			blocked = isAPossibleField(f.possibleFields(),y,x);
		}
		return blocked;
	}
	
	private boolean isAPossibleField(List<Integer[]> pf, int y, int x) {
		boolean check = true;
		for(int i = 0; i < pf.size(); i++) {
			if(pf.get(i)[0] == y && pf.get(i)[1] == x) {
				check = true;
			}
		}
		return check;
	}

	public void setColidate(boolean colidate) {
		this.colidate = colidate;
	}

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

	public List<Integer[]> colidateFigurePawn(Figure f, List<Integer[]> pf, Player p, Player p2) {
		unmovedFigures(f);
		setPossibleFields(pf);
		setFigureList(p.getFigureList());
		for(int i = 0; i < getPossibleFields().size(); i++) {
			checkColidatePawn(f, i);
		}
		return getPossibleFields();
	}

	private void checkColidatePawn(Figure f, int i) {
		if(colidate(getPossibleFields().get(i))) {
			removeFieldsPawn(getPossibleFields().get(i),f.getColor());
		}
	}
	
	public List<Integer[]> colidateOwnFigureHorVer(Figure f, List<Integer[]> pf, Player p) {
		unmovedFigures(f);
		setPossibleFields(pf);
		setFigureList(p.getFigureList());
		for(int i = 0; i < getPossibleFields().size(); i++) { 
			checkColidateHorVer(i);
		}
		return getPossibleFields();
	}

	private void checkColidateHorVer(int i) {
		if(colidate(getPossibleFields().get(i))) {
			removeUp(i);
			removeDown(i);
			removeLeft(i);
			removeRight(i);
		}
	}
	
	public List<Integer[]> colidateOtherFigureDiagonal(Figure f, List<Integer[]> pf, Player p) {
		unmovedFigures(f);
		setPossibleFields(pf);
		setFigureList(p.getFigureList());
		for(int i = 0; i < getPossibleFields().size(); i++) {
			checkColidateDiagonal(i);
		}
		return getPossibleFields();
	}
	
	public List<Integer[]> colidateOwnFigureDiagonal(Figure f, List<Integer[]> pf, Player p) {
		unmovedFigures(f);
		setPossibleFields(pf);
		setFigureList(p.getFigureList());
		for(int i = 0; i < getPossibleFields().size(); i++) {
			checkColidateDiagonal(i + 1);
		}
		return getPossibleFields();
	}

	private void checkColidateDiagonal(int i) {
		if(colidate(getPossibleFields().get(i))) {
			removeRightUp(i);
			removeLeftUp(i);
			removeRightDown(i);
			removeLeftDown(i);
		}
	}
	
	public List<Integer[]> colidateOtherFigureHorVer(Figure f, List<Integer[]> pf, Player p) {
		unmovedFigures(f);
		setPossibleFields(pf);
		setFigureList(p.getFigureList());
		for(int i = 0; i < getPossibleFields().size(); i++) {
			checkColidateHorVer(i + 1);
		}
		return getPossibleFields();
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
		for(int i = 0; i < getFigureList().size(); i++) {
			int[] position = getFigureList().get(i).getField();
			checkColidatePosition(posF, position);
		}
		return isColidate();
	}

	private void checkColidatePosition(Integer[] posF, int[] position) {
		if(posF[0] == position[0] && posF[1] == position[1]) {
			setColidate(true);
		}
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
		while(checkNextFieldGrater(index, y, yNext) || y == ChessConstants.MAXAXIS) {
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
		while(checkFieldSmaller(index, y, yNext) || y == ChessConstants.MINAXIS) {
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
		while(checkFieldSmaller(index, x, xNext) || x == ChessConstants.MINAXIS) {
			if(x != ChessConstants.MINAXIS) {
				x = getPossibleFields().get(index)[0];
				xNext = getPossibleFields().get(index + 1)[0];
			}
			getPossibleFields().remove(index);
		}
	}

	private boolean checkFieldSmaller(int index, int x, int xNext) {
		return x > xNext && (index + 1) < getPossibleFields().size();
	}

	private void removeRight(int index) {
		int x = getPossibleFields().get(index)[1];
		int xNext = getPossibleFields().get(index + 1)[1];
		getPossibleFields().remove(index);
		while(checkNextFieldGrater(index, x, xNext) || x == ChessConstants.MAXAXIS) {
			if(x != ChessConstants.MAXAXIS) {
				x = getPossibleFields().get(index)[0];
				xNext = getPossibleFields().get(index + 1)[0];
			}
			getPossibleFields().remove(index);
		}
	}

	private boolean checkNextFieldGrater(int index, int x, int xNext) {
		return x < xNext && (index + 1) < getPossibleFields().size();
	}
	
	private void removeRightUp(int index) {
		int x = getPossibleFields().get(index)[1];
		int xNext = getPossibleFields().get(index + 1)[1];
		int y = getPossibleFields().get(index)[0];
		int yNext = getPossibleFields().get(index + 1)[0];
		getPossibleFields().remove(index);
		while(checkXandYSmaller(index, x, xNext, y, yNext) || y == ChessConstants.MAXAXIS && x == ChessConstants.MAXAXIS) {
			if(y != ChessConstants.MAXAXIS && x != ChessConstants.MAXAXIS) {
				x = getPossibleFields().get(index)[0];
				xNext = getPossibleFields().get(index + 1)[0];
				y = getPossibleFields().get(index)[0];
				yNext = getPossibleFields().get(index + 1)[0];
			}
			getPossibleFields().remove(index);
		}
	}

	private boolean checkXandYSmaller(int index, int x, int xNext,
			int y, int yNext) {
		return x < xNext && y < yNext && (index + 1) < getPossibleFields().size();
	}
	
    private void removeLeftUp(int index) {
    	int x = getPossibleFields().get(index)[1];
		int xNext = getPossibleFields().get(index + 1)[1];
		int y = getPossibleFields().get(index)[0];
		int yNext = getPossibleFields().get(index + 1)[0];
		getPossibleFields().remove(index);
		while(checkXgreaterYsmaller(index, x, xNext, y, yNext) || y == ChessConstants.MAXAXIS && x == ChessConstants.MINAXIS) {
			if(y != ChessConstants.MAXAXIS && x != ChessConstants.MINAXIS) {
				x = getPossibleFields().get(index)[0];
				xNext = getPossibleFields().get(index + 1)[0];
				y = getPossibleFields().get(index)[0];
				yNext = getPossibleFields().get(index + 1)[0];
			}
			getPossibleFields().remove(index);
		}
	}

	private boolean checkXgreaterYsmaller(int index, int x, int xNext, int y,
			int yNext) {
		return x > xNext && y < yNext && (index + 1) < getPossibleFields().size();
	}
    
    private void removeRightDown(int index) {
    	int x = getPossibleFields().get(index)[1];
		int xNext = getPossibleFields().get(index + 1)[1];
		int y = getPossibleFields().get(index)[0];
		int yNext = getPossibleFields().get(index + 1)[0];
		getPossibleFields().remove(index);
		while(checkXsmallerYgreater(index, x, xNext, y, yNext) || y == ChessConstants.MINAXIS && x == ChessConstants.MAXAXIS) {
			if(y != ChessConstants.MINAXIS && x != ChessConstants.MAXAXIS) {
				x = getPossibleFields().get(index)[0];
				xNext = getPossibleFields().get(index + 1)[0];
				y = getPossibleFields().get(index)[0];
				yNext = getPossibleFields().get(index + 1)[0];
			}
			getPossibleFields().remove(index);
		}
    }

	private boolean checkXsmallerYgreater(int index, int x, int xNext, int y,
			int yNext) {
		return x < xNext && y > yNext && (index + 1) < getPossibleFields().size();
	}
    
    private void removeLeftDown(int index) {
    	int x = getPossibleFields().get(index)[1];
		int xNext = getPossibleFields().get(index + 1)[1];
		int y = getPossibleFields().get(index)[0];
		int yNext = getPossibleFields().get(index + 1)[0];
		getPossibleFields().remove(index);
		while(checkXandYGreater(index, x, xNext, y, yNext) || y == ChessConstants.MINAXIS && x == ChessConstants.MINAXIS) {
			if(x != ChessConstants.MINAXIS && y != ChessConstants.MINAXIS) {
				x = getPossibleFields().get(index)[0];
				xNext = getPossibleFields().get(index + 1)[0];
				y = getPossibleFields().get(index)[0];
				yNext = getPossibleFields().get(index + 1)[0];
			}
			getPossibleFields().remove(index);
		}
    }

	private boolean checkXandYGreater(int index, int x, int xNext, int y,
			int yNext) {
		return x > xNext && y > yNext && (index + 1) < getPossibleFields().size();
	}

}
